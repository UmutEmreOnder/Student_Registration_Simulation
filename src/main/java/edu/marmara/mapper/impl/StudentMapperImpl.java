package edu.marmara.mapper.impl;

import edu.marmara.dto.StudentGetDTO;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;
import edu.marmara.repository.InstructorRepository;
import edu.marmara.repository.impl.InstructorRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentMapperImpl implements StudentMapper {
    School school = School.getInstance();
    InstructorRepository instructorRepository = new InstructorRepositoryImpl();

    @Override
    public Student mapTo(StudentGetDTO studentGetDTO) {
        Student student = new Student();

        student.setUuid(studentGetDTO.getUuid());
        student.setName(studentGetDTO.getName());
        student.setSurname(studentGetDTO.getSurname());
        student.setEmail(studentGetDTO.getEmail());
        student.setBirthDate(studentGetDTO.getBirthDate());
        student.setStudentId(studentGetDTO.getStudentId());
        student.setYearEnrolled(studentGetDTO.getYearEnrolled());
        student.setSemester(studentGetDTO.getSemester());

        student.setTranscript(new Transcript());
        student.getTranscript().setPassedCourses(new HashMap<>());
        student.getTranscript().setFailedCourses(new ArrayList<>());
        student.getTranscript().setFailedCredit(0);
        student.getTranscript().setPassedCredit(0);
        student.getTranscript().setNotTakenCourses(new ArrayList<>());


        Advisor advisor = instructorRepository.findAdvisorByEmail(studentGetDTO.getAdvisor());
        if (advisor != null) {
            student.setAdvisor(advisor);
            advisor.getStudents().add(student);
        }

        return student;
    }
}
