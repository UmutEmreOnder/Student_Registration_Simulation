package edu.marmara.repository;

import edu.marmara.model.School;
import edu.marmara.model.Student;

public interface StudentRepository {
    void save(Student student);
    Student findByStudentId(Long studentID);
}