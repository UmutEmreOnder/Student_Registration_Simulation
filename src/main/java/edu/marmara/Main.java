package edu.marmara;

import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.service.CourseService;
import edu.marmara.service.JsonService;
import edu.marmara.service.StudentService;
import edu.marmara.service.impl.CourseServiceImpl;
import edu.marmara.service.impl.JsonServiceImpl;
import edu.marmara.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JsonService jsonService = new JsonServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        StudentService studentService = new StudentServiceImpl();

        String studentInfo = Files.readString(Path.of("student.json"));
        List<Student> students = jsonService.readStudentsFromJson(studentInfo);

        String instructorInfo = Files.readString(Path.of("instructor.json"));
        List<Instructor> instructors = jsonService.readInstructorsFromJson(instructorInfo);

        String courseInfo = Files.readString(Path.of("course.json"));
        List<Course> courses = jsonService.readCoursesFromJson(courseInfo);

        School school = new School();

        school.setStudents(students);
        school.setInstructors(instructors);
        school.setCourses(courses);

        courseService.assignInstructor(school);
        studentService.assignCourses(school);

        for (Student student : school.getStudents()) {
            System.out.println(student);
            System.out.println(student.getTranscript());
            System.out.println(studentService.getAvailableCourses(school, student));
            System.out.println("\n\n");
        }
    }
}
