package edu.marmara.model;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;
}
