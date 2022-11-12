package edu.marmara.mapper;

import edu.marmara.dto.CourseDTO;
import edu.marmara.dto.CourseGetDTO;
import edu.marmara.model.Course;

public interface CourseMapper {
    CourseDTO mapTo(Course course);

    Course mapTo(CourseGetDTO courseGetDTO);
}