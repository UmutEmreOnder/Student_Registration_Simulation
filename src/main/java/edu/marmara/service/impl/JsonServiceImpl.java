package edu.marmara.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.marmara.dto.CourseGetDTO;
import edu.marmara.dto.InstructorGetDTO;
import edu.marmara.dto.StudentGetDTO;
import edu.marmara.mapper.CourseMapper;
import edu.marmara.mapper.InstructorMapper;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.mapper.impl.CourseMapperImpl;
import edu.marmara.mapper.impl.InstructorMapperImpl;
import edu.marmara.mapper.impl.StudentMapperImpl;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.service.CourseService;
import edu.marmara.service.JsonService;

import java.util.Arrays;
import java.util.List;

public class JsonServiceImpl implements JsonService {
    StudentMapper studentMapper = new StudentMapperImpl();
    CourseMapper courseMapper = new CourseMapperImpl();
    InstructorMapper instructorMapper = new InstructorMapperImpl();
    CourseService courseService = new CourseServiceImpl();

    @Override
    public Student readStudentFromJson(String jsonFormattedStudentList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();
        StudentGetDTO studentGetDTO = mapper.readValue(jsonFormattedStudentList, StudentGetDTO.class);

        return studentMapper.mapTo(studentGetDTO);
    }

    @Override
    public List<Instructor> readInstructorsFromJson(String jsonFormattedInstructorList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        InstructorGetDTO[] instructorGetDTOList = mapper.readValue(jsonFormattedInstructorList, InstructorGetDTO[].class);

        return Arrays.stream(instructorGetDTOList).map(instructorMapper::mapTo).toList();
    }

    @Override
    public List<Course> readCoursesFromJson(String jsonFormattedCourseList) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        CourseGetDTO[] courseGetDTOS = mapper.readValue(jsonFormattedCourseList, CourseGetDTO[].class);

        List<Course> coursesWithoutPrerequisites = Arrays.stream(courseGetDTOS).map(courseMapper::mapTo).toList();

        School school = School.getInstance();

        school.setCourses(coursesWithoutPrerequisites);
        courseService.addPrerequisites(List.of(courseGetDTOS));

        return school.getCourses();
    }


    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper;
    }
}
