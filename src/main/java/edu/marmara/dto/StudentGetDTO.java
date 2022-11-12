package edu.marmara.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
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
