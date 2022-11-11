package edu.marmara.service;

import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.model.Student;

import java.util.List;

public interface StudentService {
    void assignCourses(School school);

    List<Course> getAvailableCourses(School school, Student student);
}
