package edu.marmara.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private Integer courseCredit;
    private String instructorName;
}