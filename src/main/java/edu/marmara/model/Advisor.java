package edu.marmara.model;

import lombok.Data;

import java.util.List;

@Data
public class Advisor extends Instructor {
    private List<Student> students;
}
