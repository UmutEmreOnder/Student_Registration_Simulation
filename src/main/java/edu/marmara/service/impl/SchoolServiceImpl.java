package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.service.JsonService;
import edu.marmara.service.SchoolService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    private static JsonService jsonService = new JsonServiceImpl();
    private static School school = School.getInstance();

    @Override
    public void uploadJsons() throws IOException, ParseException {
        String courseInfo = Files.readString(Path.of("json/course/course.json"));
        List<Course> courses = jsonService.readCoursesFromJson(courseInfo);

        school.setCourses(courses);

        String instructorInfo = Files.readString(Path.of("json/instructor/instructor.json"));
        List<Instructor> instructors = jsonService.readInstructorsFromJson(instructorInfo);

        school.setInstructors(instructors);


        // todo: Loop this 3 lines so that it will get all json from json/student/*.json path
        String studentInfo = Files.readString(Path.of("json/student/150118047.json"));
        Student studentTest = jsonService.readStudentFromJson(studentInfo);
        school.getStudents().add(studentTest);
    }
}
