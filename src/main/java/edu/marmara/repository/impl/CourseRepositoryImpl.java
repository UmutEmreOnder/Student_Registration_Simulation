package edu.marmara.repository.impl;

import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.repository.CourseRepository;

import java.util.ArrayList;
import java.util.Objects;

public class CourseRepositoryImpl implements CourseRepository {
    // todo: Update the responding json file

    @Override
    public void save(School school, Course course) {
        if (school.getCourses() == null) {
            school.setCourses(new ArrayList<>());
        }

        school.getCourses().add(course);
    }

    @Override
    public Course findByCourseCode(School school, String courseCode) {
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
