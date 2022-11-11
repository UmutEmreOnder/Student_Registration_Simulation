package edu.marmara.repository.impl;

import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.repository.InstructorRepository;

import java.util.ArrayList;
import java.util.Objects;

public class InstructorRepositoryImpl implements InstructorRepository {
    // todo: Update the responding json file

    @Override
    public void save(School school, Instructor instructor) {
        if (school.getInstructors() == null) {
            school.setInstructors(new ArrayList<>());
        }

        school.getInstructors().add(instructor);
    }

    @Override
    public Instructor findByEmail(School school, String email) {
        if (school.getInstructors() == null) {
            return null;
        }


        for (Instructor instructor : school.getInstructors()) {
            if (Objects.equals(instructor.getEmail(), email)) {
                return instructor;
            }
        }

        return null;
    }
}
