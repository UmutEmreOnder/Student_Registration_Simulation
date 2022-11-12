package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentServiceImpl implements StudentService {
    private School school = School.getInstance();
    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public void assignCourses() {
        Random random = new Random();

        for (Student student : school.getStudents()) {
            if (student.getTranscript() == null) {
                student.setTranscript(new Transcript());
                Transcript transcript = student.getTranscript();
                transcript.setFailedCourses(new ArrayList<>());
                transcript.setPassedCourses(new ArrayList<>());
                transcript.setNotTakenCourses(new ArrayList<>());
                transcript.setPassedCredit(0);
                transcript.setFailedCredit(0);
            }

            for (Course course : school.getCourses()) {
                if (course.getGivenSemester() >= student.getSemester()) {
                    student.getTranscript().getNotTakenCourses().add(course);
                    continue;
                }

                if (random.nextInt(10) > 3) {
                    student.getTranscript().getPassedCourses().add(course);
                    student.getTranscript().setPassedCredit(student.getTranscript().getPassedCredit() + course.getCourseCredit());
                } else {
                    student.getTranscript().getFailedCourses().add(course);
                    student.getTranscript().setFailedCredit(student.getTranscript().getFailedCredit() + course.getCourseCredit());
                }
            }
        }
    }

    @Override
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();
        for (Course course : school.getCourses()) {
            if (student.getSemester() <= course.getGivenSemester() && !student.getTranscript().getPassedCourses().contains(course)) {
                courses.add(course);
            }
        }

        return courses;
    }

    @Override
    public void addCourseToSchedule(Student student, String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (student.getWeeklySchedule() == null) {
            student.setWeeklySchedule(new Schedule());
            student.getWeeklySchedule().setCourses(new ArrayList<>());
        }

        if (course != null) {
            student.getWeeklySchedule().getCourses().add(course);
        }
    }
}
