package edu.marmara.mapper;

import edu.marmara.dto.StudentDTO;
import edu.marmara.dto.StudentGetDTO;
import edu.marmara.model.Student;

public interface StudentMapper {
    Student mapTo(StudentGetDTO studentGetDTO);

    StudentDTO mapTo(Student student);
}
