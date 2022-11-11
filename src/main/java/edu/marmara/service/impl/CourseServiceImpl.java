package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.service.CourseService;

import java.util.List;
import java.util.Random;

public class CourseServiceImpl implements CourseService {
    @Override
    public void assignInstructor(School school) {
        List<Course> courses = school.getCourses();
        Random random = new Random();

        for (Course course : courses) {
            course.setInstructor(school.getInstructors().get(random.nextInt(school.getInstructors().size())));
        }
    }
}
