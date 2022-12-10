package edu.marmara.service.impl;

import edu.marmara.model.*;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.*;

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
                        Double grade = getGrade(gradeRange, gradeLuck);
                        student.getTranscript().getPassedCourses().put(course, grade);
                        student.getTranscript().setPassedCredit(student.getTranscript().getPassedCredit() + course.getCourseCredit());
                    } else {
                        student.getTranscript().getFailedCourses().add(course);
                        student.getTranscript().setFailedCredit(student.getTranscript().getFailedCredit() + course.getCourseCredit());
                    }
                } else {
                    student.getTranscript().getNotTakenCourses().add(course);
                }
            }
        }
    }

    @Override
    public Double calculateGPA(Student student) {
        HashMap<Course, Double> passedCourses = student.getTranscript().getPassedCourses();
        double gpa = 0;

        for (Map.Entry<Course, Double> entry : passedCourses.entrySet())
            gpa += entry.getValue() * entry.getKey().getCourseCredit();

        gpa = gpa / (student.getTranscript().getPassedCredit() + student.getTranscript().getFailedCredit());
        student.getTranscript().setGpa(gpa);

        return gpa;
    }

    private static Double getGrade(List<Double> gradeRange, Double gradeLuck) {
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
