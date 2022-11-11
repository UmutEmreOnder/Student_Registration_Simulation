package edu.marmara.dto;

import edu.marmara.model.Schedule;

import java.util.Date;
import java.util.List;
import java.util.UUID;

// todo: Use them to retrieve presentedCourses as a String (Course Code of the Course) then while parsing the json, find the corresponding course and add it
public class InstructorGetDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private List<String> presentedCourses;
    private Schedule weeklySchedule;
}
