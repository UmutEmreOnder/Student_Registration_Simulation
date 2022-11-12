package edu.marmara.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private List<Student> enrolledStudents;
    private Integer courseCredit;
    private List<Course> prerequisites;
    private Instructor instructor;
    private List<WeeklyDate> dates;
}
