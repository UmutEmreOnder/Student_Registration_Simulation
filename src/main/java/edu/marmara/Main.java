package edu.marmara;

import edu.marmara.mapper.CourseMapper;
import edu.marmara.mapper.impl.CourseMapperImpl;
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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JsonService jsonService = new JsonServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        CourseMapper courseMapper = new CourseMapperImpl();

        Scanner scanner = new Scanner(System.in);


        String studentInfo = Files.readString(Path.of("student.json"));
        List<Student> students = jsonService.readStudentsFromJson(studentInfo);

        String instructorInfo = Files.readString(Path.of("instructor.json"));
        List<Instructor> instructors = jsonService.readInstructorsFromJson(instructorInfo);

        String courseInfo = Files.readString(Path.of("course.json"));
        List<Course> courses = jsonService.readCoursesFromJson(courseInfo);

        School school = School.getInstance();

        school.setStudents(students);
        school.setInstructors(instructors);
        school.setCourses(courses);

        courseService.assignInstructor();
        studentService.assignCourses();


        for (Student student : school.getStudents()) {
            System.out.println(student.getName() + " " + student.getSurname());
            System.out.println("Select a course to add it on your weekly schedule");
            for (Course course : studentService.getAvailableCourses(student)) {
                System.out.println(course.getCourseCode() + " " + course.getCourseTitle());
            }
            System.out.print("\n\nEnter the Course Code: ");
            studentService.addCourseToSchedule(student, scanner.next());

            System.out.println("Your new weekly schedule \n");
            for (Course course : student.getWeeklySchedule().getCourses()) {
                System.out.println(courseMapper.mapTo(course));
            }
 }
}
}