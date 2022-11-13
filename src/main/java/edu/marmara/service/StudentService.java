package edu.marmara.service;

import edu.marmara.model.Course;
import edu.marmara.model.Student;

import java.util.List;

public interface StudentService {
    List<Course> getAvailableCourses(Student student);

    void addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses);
}
