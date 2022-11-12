package edu.marmara.dto;

import lombok.Data;

import java.util.List;

@Data
public class InstructorListDTO {
    private List<InstructorGetDTO> instructors;
}
