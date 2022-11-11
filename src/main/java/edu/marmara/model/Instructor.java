package edu.marmara.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper=true)
public class Instructor extends Person {
    private List<Course> presentedCourses;
    private Schedule weeklySchedule;
}
