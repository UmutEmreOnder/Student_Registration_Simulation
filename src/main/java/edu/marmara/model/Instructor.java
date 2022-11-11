package edu.marmara.model;

import edu.marmara.Models.Course;
import lombok.Data;

import java.util.List;

@Data
public class Instructor {
    private List<Course> presentedCourses;
    private Schedule weeklySchedule;
}
