package edu.marmara.repository.impl;

import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {
    // todo: Update the responding json file

    @Override
    public void save(Student student) {
        School school = School.getInstance();

        if (school.getStudents() == null) {
            school.setStudents(new ArrayList<>());
        }

        school.getStudents().add(student);
    }

    @Override
    public Student findByStudentId(Long studentId) {
        School school = School.getInstance();

        if (school.getStudents() == null) {
            return null;
        }


        for (Student student : school.getStudents()) {
            if (Objects.equals(student.getStudentId(), studentId)) {
                return student;
            }
        }

        return null;
    }
}
