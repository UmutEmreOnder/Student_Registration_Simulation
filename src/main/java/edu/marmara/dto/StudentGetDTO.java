package edu.marmara.dto;


import java.util.Date;
import java.util.List;
import java.util.UUID;

// todo: Use them to retrieve passed, failed courses and advisor as a String (Course Code of the Course, email of the advisor) then while parsing the json, find the corresponding course and add it.
public class StudentGetDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private Long studentId;
    private Integer yearEnrolled;
    private List<String> passedCourses;
    private List<String> failedCourses;
    private String advisor;
    private Integer semester;
}
