package edu.marmara.dto;

import edu.marmara.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentListDTO {
    private List<Student> students;
}
