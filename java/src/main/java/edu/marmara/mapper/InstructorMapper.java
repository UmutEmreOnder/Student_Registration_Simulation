package edu.marmara.mapper;

import edu.marmara.dto.InstructorGetDTO;
import edu.marmara.model.Instructor;

public interface InstructorMapper {
    Instructor mapTo(InstructorGetDTO instructorGetDTO);
}
