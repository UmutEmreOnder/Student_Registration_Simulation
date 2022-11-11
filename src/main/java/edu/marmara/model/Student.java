package edu.marmara.model;

import lombok.Data;

@Data
public class Student extends Person {
    private Long studentId;
    private Integer yearEnrolled;
    private Schedule weeklySchedule;
    private Transcript transcript;
    private Advisor advisor;
}
