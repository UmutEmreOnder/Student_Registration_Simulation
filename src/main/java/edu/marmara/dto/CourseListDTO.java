package edu.marmara.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseListDTO {
    private List<CourseGetDTO> courses;
}
