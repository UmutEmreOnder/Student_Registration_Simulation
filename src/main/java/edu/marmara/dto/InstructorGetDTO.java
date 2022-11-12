package edu.marmara.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class InstructorGetDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private List<String> presentedCourses;
    private Boolean isAdvisor;
}
