package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StudentServiceImpl implements StudentService {
    private final School school = School.getInstance();
    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (!student.getTranscript().getPassedCourses().containsKey(course)) {
                // Check prerequisites
                if (course.getPrerequisites() != null) {
                    for (Course prerequisiteCourse : course.getPrerequisites()) {
                        if (!student.getTranscript().getPassedCourses().containsKey(prerequisiteCourse)) {
                            continue outerloop;
                        }
                    }
                }

                if (student.getWeeklySchedule() != null) {
                    if (!student.getWeeklySchedule().getCourses().contains(course)) {
                        courses.add(course);
                    }
                } else {
                    courses.add(course);
                }
            }
        }

        return courses;
    }

    @Override
    public Boolean addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (student.getWeeklySchedule() == null) {
            student.setWeeklySchedule(new Schedule());
            student.getWeeklySchedule().setCourses(new ArrayList<>());
        }

        if (course != null && availableCourses.contains(course)) {
            student.getWeeklySchedule().getCourses().add(course);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public void assignRandomCourses() {
        List<Student> listOfStudents = school.getStudents();
        List<Course> listOfCourses = school.getCourses();

        Double passProbability = school.getConfig().getPassProbability();
        List<Double> gradeRange = school.getConfig().getGradeRange();
        Double gradeLuck = school.getConfig().getGradeLuck();

        if (gradeLuck < 0.5) {
            gradeLuck = 1 - gradeLuck;
            Collections.reverse(gradeRange);
        }

        Random rng = new Random();

        for (Student student : listOfStudents) {
            for (Course course : listOfCourses) {
                if (course.getGivenSemester() > student.getSemester()) {
                    student.getTranscript().getNotTakenCourses().add(course);
                    continue;
                }
                if (getAvailableCourses(student).contains(course)) {
                    Double rand = rng.nextDouble();
                    if (rand <= passProbability) {
                        Double credit = getCredit(gradeRange, gradeLuck);
                        student.getTranscript().getPassedCourses().put(course, credit);
                    } else {
                        student.getTranscript().getFailedCourses().add(course);
                    }
                } else {
                    student.getTranscript().getNotTakenCourses().add(course);
                }
            }
        }
    }

    private static Double getCredit(List<Double> gradeRange, Double gradeLuck) {
        int selectedIndex = -1;

        double[] weights = new double[gradeRange.size()];

        for (int i = 0; i < gradeRange.size(); i++) {
            weights[i] = (gradeRange.get(i) / 4) * gradeLuck;
        }

        Double randForGrade = Math.random();

        double sum = 0;
        for (double weight : weights) {
            sum += weight;
        }
        double value = randForGrade * sum;


        for (int i = 0; i < weights.length; i++) {
            if (value < weights[i]) {
                selectedIndex = i;
                break;
            }
            value -= weights[i];
        }


        return gradeRange.get(selectedIndex);
    }
}
