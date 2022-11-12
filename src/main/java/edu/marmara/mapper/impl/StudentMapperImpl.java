package edu.marmara.mapper.impl;

import edu.marmara.dto.StudentGetDTO;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;

public class StudentMapperImpl implements StudentMapper {
    CourseRepository courseRepository = new CourseRepositoryImpl();
    School school = School.getInstance();

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
        student.getTranscript().setPassedCourses(new ArrayList<>());
        student.getTranscript().setFailedCourses(new ArrayList<>());
        student.getTranscript().setFailedCredit(0);
        student.getTranscript().setPassedCredit(0);
        student.getTranscript().setNotTakenCourses(new ArrayList<>());

        for (Course course : school.getCourses()) {
            if (studentGetDTO.getPassedCourses().contains(course.getCourseCode())) {
                student.getTranscript().getPassedCourses().add(course);
            } else if (studentGetDTO.getFailedCourses().contains(course.getCourseCode())) {
                student.getTranscript().getFailedCourses().add(course);
            } else {
                student.getTranscript().getNotTakenCourses().add(course);
            }
        }

        return student;
    }
}
