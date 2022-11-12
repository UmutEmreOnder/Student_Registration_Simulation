package edu.marmara.mapper.impl;

import edu.marmara.dto.CourseDTO;
import edu.marmara.mapper.CourseMapper;
import edu.marmara.model.Course;

public class CourseMapperImpl implements CourseMapper {
    @Override
    public CourseDTO mapTo(Course course) {
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseTitle(course.getCourseTitle());
        courseDTO.setCourseCredit(course.getCourseCredit());
        courseDTO.setGivenSemester(course.getGivenSemester());
        courseDTO.setInstructorName(course.getInstructor().getName() + " " + course.getInstructor().getSurname());

        return courseDTO;
}
}