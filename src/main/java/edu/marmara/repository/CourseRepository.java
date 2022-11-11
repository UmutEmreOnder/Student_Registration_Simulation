package edu.marmara.repository;

import edu.marmara.model.Course;
import edu.marmara.model.School;

public interface CourseRepository {
    void save(School school, Course course);

    Course findByCourseCode(School school, String CourseCode);
}
