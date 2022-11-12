package edu.marmara.dto;

import edu.marmara.model.Instructor;

import java.util.List;

// todo: Use them to retrieve prerequisites as a String (Course Code of the Course) then while parsing the json, find the corresponding course and add it.
// todo: If the corresponding course is not in the school's list, first add that course (use Recurrence maybe ?)
public class CourseGetDTO {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private Integer courseCredit;
    private List<String> prerequisites;

    // todo: Give WeeklyDate somehow
}
