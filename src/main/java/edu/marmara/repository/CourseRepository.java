package edu.marmara.repository;

import edu.marmara.model.Course;
import edu.marmara.model.School;

public interface CourseRepository {
    void save(Course course);

    Course findByCourseCode(String CourseCode);
}
