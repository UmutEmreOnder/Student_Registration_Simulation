package edu.marmara.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.marmara.dto.CourseListDTO;
import edu.marmara.dto.InstructorListDTO;
import edu.marmara.dto.StudentGetDTO;
import edu.marmara.dto.StudentListDTO;
import edu.marmara.mapper.CourseMapper;
import edu.marmara.mapper.InstructorMapper;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.mapper.impl.CourseMapperImpl;
import edu.marmara.mapper.impl.InstructorMapperImpl;
import edu.marmara.mapper.impl.StudentMapperImpl;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.Student;
import edu.marmara.service.JsonService;

import java.util.List;

public class JsonServiceImpl implements JsonService {
    StudentMapper studentMapper = new StudentMapperImpl();
    CourseMapper courseMapper = new CourseMapperImpl();
    InstructorMapper instructorMapper = new InstructorMapperImpl();

    @Override
    public Student readStudentFromJson(String jsonFormattedStudentList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        StudentGetDTO studentGetDTO = mapper.readValue(jsonFormattedStudentList, StudentGetDTO.class);

        return studentMapper.mapTo(studentGetDTO);
    }

    @Override
    public List<Instructor> readInstructorsFromJson(String jsonFormattedInstructorList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        InstructorListDTO instructorListDTO = mapper.readValue(jsonFormattedInstructorList, InstructorListDTO.class);

        return instructorListDTO.getInstructors().stream().map(instructorMapper::mapTo).toList();
    }

    @Override
    public List<Course> readCoursesFromJson(String jsonFormattedCourseList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        CourseListDTO courseListDTO = mapper.readValue(jsonFormattedCourseList, CourseListDTO.class);

        return courseListDTO.getCourses().stream().map(courseMapper::mapTo).toList();
    }


    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper;
    }
}
