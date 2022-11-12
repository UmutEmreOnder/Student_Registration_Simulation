package edu.marmara.mapper;

import edu.marmara.dto.CourseDTO;
import edu.marmara.model.Course;

public interface CourseMapper {
    CourseDTO mapTo(Course course);
}