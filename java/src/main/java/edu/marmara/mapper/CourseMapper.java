package edu.marmara.mapper;

import edu.marmara.dto.CourseGetDTO;
import edu.marmara.model.Course;

public interface CourseMapper {

    Course mapTo(CourseGetDTO courseGetDTO);
}