package edu.marmara.repository;

import edu.marmara.model.Course;

public interface CourseRepository {
    void save(Course course);

    Course findByCourseCode(String CourseCode);
}
