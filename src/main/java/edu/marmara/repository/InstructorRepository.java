package edu.marmara.repository;

import edu.marmara.model.Instructor;
import edu.marmara.model.School;

public interface InstructorRepository {
    void save(School school, Instructor instructor);

    Instructor findByEmail(School school, String email);
}
