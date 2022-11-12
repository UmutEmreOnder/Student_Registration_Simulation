package edu.marmara.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseGetDTO {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private Integer courseCredit;
    private List<String> prerequisites;
    private List<String> weeklyDate;

    // todo: Give WeeklyDate somehow
}
