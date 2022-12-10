package edu.marmara.service.impl;

import edu.marmara.model.*;
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
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (!student.getTranscript().getPassedCourses().contains(course)) {
                // Check prerequisites
                if (course.getPrerequisites() != null) {
                    for (Course prerequisiteCourse : course.getPrerequisites()) {
                        if (! student.getTranscript().getPassedCourses().contains(prerequisiteCourse)) {
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
    public boolean isSlotEmpty(List<Course> schedule, Course course) {

        for (Course c: schedule) {
            for (WeeklyDate dt : course.getDates()) {
                for (WeeklyDate dt2 : c.getDates()) {
                    if (dt.getDayName().equals(dt2.getDayName()) && dt.getHours() == dt2.getHours()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public Boolean addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (student.getWeeklySchedule() == null) {
            student.setWeeklySchedule(new Schedule());
            student.getWeeklySchedule().setCourses(new ArrayList<>());
        }

        if (course != null && availableCourses.contains(course) && isSlotEmpty(student.getWeeklySchedule().getCourses(), course)){
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
        Random rng = new Random();

        for (Student student : listOfStudents) {
            for(Course course : listOfCourses){
                if(course.getGivenSemester() > student.getSemester()) {
                    student.getTranscript().getNotTakenCourses().add(course);
                    continue;
                }
                if (getAvailableCourses(student).contains(course)){
                    Double rand = rng.nextDouble();
                    if (rand <= passProbability){
                        student.getTranscript().getPassedCourses().add(course);
                        //todo: Assign letter note to added courses
                    }
                    else{
                        student.getTranscript().getFailedCourses().add(course);
                    }
                }
                else{
                    student.getTranscript().getNotTakenCourses().add(course);
                }
            }
        }
    }
}
