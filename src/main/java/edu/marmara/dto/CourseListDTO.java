package edu.marmara.dto;

import edu.marmara.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class CourseListDTO {
    private List<CourseGetDTO> courses;
}
