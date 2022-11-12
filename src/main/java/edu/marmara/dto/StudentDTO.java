package edu.marmara.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class StudentDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private Long studentId;
    private Integer yearEnrolled;
    private Integer semester;
}
