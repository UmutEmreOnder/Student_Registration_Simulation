package edu.marmara.model;

import edu.marmara.Models.Course;
import lombok.Data;

import java.util.List;

@Data
public class Transcript {
    private Double gpa;
    private Integer passedCredit;
    private Integer failedCredit;
    private List<Course> passedCourses;
    private List<Course> failedCourses;
    private List<Course> notTakenCourses;
}
