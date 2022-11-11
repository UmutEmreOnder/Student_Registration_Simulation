package edu.marmara.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.marmara.dto.CourseListDTO;
import edu.marmara.dto.InstructorListDTO;
import edu.marmara.dto.StudentListDTO;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.Student;
import edu.marmara.service.JsonService;

import java.text.ParseException;
import java.util.List;

public class JsonServiceImpl implements JsonService {

    @Override
    public List<Student> readStudentsFromJson(String jsonFormattedStudentList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        StudentListDTO students = mapper.readValue(jsonFormattedStudentList, StudentListDTO.class);

        return students.getStudents();
    }

    @Override
    public List<Instructor> readInstructorsFromJson(String jsonFormattedInstructorList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        InstructorListDTO instructorListDTO = mapper.readValue(jsonFormattedInstructorList, InstructorListDTO.class);

        return instructorListDTO.getInstructors();
    }

    @Override
    public List<Course> readCoursesFromJson(String jsonFormattedCourseList) throws ParseException, JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        CourseListDTO courseListDTO = mapper.readValue(jsonFormattedCourseList, CourseListDTO.class);

        return courseListDTO.getCourses();
    }


    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper;
    }
}
