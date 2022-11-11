package edu.marmara.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class Advisor extends Instructor {
    private List<Student> students;
}
