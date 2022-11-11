package edu.marmara.repository;

import edu.marmara.model.School;
import edu.marmara.model.Student;

public interface StudentRepository {
    void save(School school, Student student);

    Student findByStudentId(School school, Long studentId);
}
