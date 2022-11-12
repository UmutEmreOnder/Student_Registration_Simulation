package edu.marmara.repository.Impl;

import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.repository.StudentRepository;

import java.util.ArrayList;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void save(School school, Student student) {
        if(school.getStudents() == null )
            school.setStudents(new ArrayList<Student>());
        else
            school.getStudents().add(student);
    }

    @Override
    public Student findByStudentId(long studentID, School school) {
        if(school.getStudents() == null)
            return null;
        for(int i = 0; i < school.getStudents().size(); i++){
            if(studentID == school.getStudents().get(i).getStudentId()){
                return school.getStudents().get(i);
            }
        }
        return null;
    }
}
