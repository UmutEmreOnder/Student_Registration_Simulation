package edu.marmara.repository.impl;

import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.repository.CourseRepository;

import java.util.ArrayList;
import java.util.Objects;

public class CourseRepositoryImpl implements CourseRepository {
    // todo: Update the corresponding json file

    @Override
    public void save(Course course) {
        School school = School.getInstance();

        if (school.getCourses() == null) {
            school.setCourses(new ArrayList<>());
        }

        school.addCourse(course);
    }

    @Override
    public Course findByCourseCode(String courseCode) {
        School school = School.getInstance();

        if (school.getCourses() == null) {
            return null;
        }

        for (Course course : school.getCourses()) {
            if (Objects.equals(course.getCourseCode(), courseCode)) {
                return course;
            }
        }

        return null;
    }
}