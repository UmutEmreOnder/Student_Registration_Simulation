package edu.marmara.dto;

import edu.marmara.model.Instructor;
import lombok.Data;

import java.util.List;

@Data
public class InstructorListDTO {
    private List<Instructor> instructors;
}
