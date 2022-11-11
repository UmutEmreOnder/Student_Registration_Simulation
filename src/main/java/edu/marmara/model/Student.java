package edu.marmara.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Student extends Person {
    private Long studentId;
    private Integer yearEnrolled;
    private Schedule weeklySchedule;
    private Transcript transcript;
    private Advisor advisor;
    private Integer semester;
}
