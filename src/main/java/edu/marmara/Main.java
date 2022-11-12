package edu.marmara;

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
import edu.marmara.repository.InstructorRepository;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.InstructorRepositoryImpl;
import edu.marmara.repository.impl.StudentRepositoryImpl;
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
    public static School school = School.getInstance();
    public static JsonService jsonService = new JsonServiceImpl();
    public static CourseService courseService = new CourseServiceImpl();
    public static StudentService studentService = new StudentServiceImpl();
    public static CourseMapper courseMapper = new CourseMapperImpl();
    public static StudentRepository studentRepository = new StudentRepositoryImpl();
    public static InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    public static StudentMapper studentMapper = new StudentMapperImpl();
    public static Scanner scanner = new Scanner(System.in);
    public static InstructorMapper instructorMapper = new InstructorMapperImpl();

    public static void main(String[] args) throws IOException, ParseException {
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


        while (true) {
            System.out.println("Select User Type: \n1- Student\n2- Instructor\n9- Exit");

            Integer input = scanner.nextInt();

            if (input == 1) {
                System.out.print("Enter your Student ID: ");
                Student student = studentRepository.findByStudentId(scanner.nextLong());

                if (student != null) {
                    System.out.println(studentMapper.mapTo(student));

                    for (Course course : studentService.getAvailableCourses(student)) {
                        System.out.println(course.getCourseCode() + " " + course.getCourseTitle());
                    }

                    System.out.print("\nEnter the course code to add it to your schedule: ");
                    String courseCode = scanner.next();
                    studentService.addCourseToSchedule(student, courseCode);
                    System.out.println("\nYour schedule\n");

                    for (Course course : student.getWeeklySchedule().getCourses()) {
                        System.out.println(course.getCourseCode() + " " + course.getCourseTitle());
                    }
                } else {
                    System.out.println("Cannot find the student with given ID");
                }
            } else if (input == 2) {
                System.out.print("Enter your Email Address: ");
                Instructor instructor = instructorRepository.findByEmail(scanner.next());

                if (instructor != null) {
                    System.out.println(instructorMapper.mapTo(instructor));
                } else {
                    System.out.println("Cannot find the instructor with given email");
                }

            } else if (input == 9) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }
}