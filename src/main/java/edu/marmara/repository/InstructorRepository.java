package edu.marmara.repository;

import edu.marmara.model.Instructor;

public interface InstructorRepository {
    void save(Instructor instructor);

    Instructor findByEmail(String email);
}