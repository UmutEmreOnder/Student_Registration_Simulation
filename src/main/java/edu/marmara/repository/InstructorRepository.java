package edu.marmara.repository;

import edu.marmara.model.Instructor;
import edu.marmara.model.School;

public interface InstructorRepository {
    void save(Instructor instructor);

    Instructor findByEmail(String email);
}
