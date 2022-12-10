package edu.marmara.service;

import edu.marmara.model.Course;
import edu.marmara.model.Student;

import java.util.List;

public interface StudentService {
    List<Course> getAvailableCourses(Student student);

    Boolean addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses);

    void assignRandomCourses();

    Double calculateGPA(Student student);
}
