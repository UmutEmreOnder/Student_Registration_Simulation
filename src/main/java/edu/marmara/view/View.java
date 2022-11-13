package edu.marmara.view;

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
import edu.marmara.model.WeeklyDate;
import edu.marmara.repository.InstructorRepository;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.InstructorRepositoryImpl;
import edu.marmara.repository.impl.StudentRepositoryImpl;
import edu.marmara.service.CourseService;
import edu.marmara.service.JsonService;
import edu.marmara.service.SchoolService;
import edu.marmara.service.StudentService;
import edu.marmara.service.impl.CourseServiceImpl;
import edu.marmara.service.impl.JsonServiceImpl;
import edu.marmara.service.impl.SchoolServiceImpl;
import edu.marmara.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class View {
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
    public static SchoolService schoolService = new SchoolServiceImpl();

    private View(){

    }
    public static void start() throws IOException, ParseException {
        schoolService.uploadJsons();
        while (true) {
            System.out.println("Select User Type: \n1- Student\n2- Instructor\n9- Exit");
            Integer input = scanner.nextInt();
            if (input == 1) {
                System.out.print("Enter your Student ID: ");
                Student student = studentRepository.findByStudentId(scanner.nextLong());
                if (student != null) {
                    while(true) {
                        studentMapper.mapTo(student);
                        System.out.println("\nWelcome " + student.getName() + " " + student.getSurname() + "!");
                        System.out.print("What would you like to do?\n1-View Student Info\n2-View Available Courses\n3-View Schedule\n4-View Transcript\n9-Exit\n");
                        input = scanner.nextInt();
                        switch (input) {
                            case 1: {
                                printStudentInfo(student);
                                break;
                            }
                            case 2: {
                                printAvailableCourses(student);
                                break;
                            }
                            case 3:{
                                printSchedule(student);
                                break;
                            }
                            case 4:{
                                printTranscript(student);
                                break;
                            }
                            case 9: break;
                            default:
                                System.out.println("Wrong input!");
                        }
                        if (input == 9) break;
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

    private static void printTranscript(Student student) {
        if (student.getTranscript() != null){
            System.out.println("\n\n\n\n\n");
            int passedCredit = 0;
            int failedCredit = 0;
            for (Course course : student.getTranscript().getPassedCourses())
            {
                passedCredit += course.getCourseCredit();
            }
            for (Course course : student.getTranscript().getFailedCourses())
            {
                failedCredit += course.getCourseCredit();
            }
            float gpa = ((float)passedCredit * 4 / (float)(failedCredit + passedCredit * 4)) * 4;
            System.out.printf("\nGPA = %.2f\n", gpa);
            System.out.println("Passed Credit = " + passedCredit);
            System.out.println("Failed Credit = " + failedCredit);
            System.out.println("\nPassed Courses");
            for (Course course : student.getTranscript().getPassedCourses())
            {
                System.out.println("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " |");
            }
            System.out.println("\nFailed Courses");
            for (Course course : student.getTranscript().getFailedCourses())
            {
                System.out.println("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " |");
            }
        }else{
            System.out.println("Transcript is empty.");
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printSchedule(Student student) {
        System.out.print("\n\n\n\n\nSchedule");
        if (student.getWeeklySchedule() == null) {
            System.out.print(" is empty.");
        }else{
            System.out.println();
            for (Course course : student.getWeeklySchedule().getCourses()) {
                System.out.println("|  " + course.getCourseCode() + "  |" + course.getCourseTitle());
            }
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printAvailableCourses(Student student)
    {
        System.out.print("\n\n\n\n\nAvailable Courses\n");
        for (Course course : studentService.getAvailableCourses(student)) {
            System.out.print("|  " + course.getCourseCode() + "  |" + course.getCourseTitle() + "|");
            for (WeeklyDate date : course.getDates()) {
                System.out.print(date.getDayName() + " " + date.getHours() + " ");
            }
            System.out.println();
        }
        System.out.print("\nEnter the course code to add it to your schedule or type 9 to exit: ");
        String courseCode = scanner.next();
        if (Objects.equals(courseCode, "9")) return;
        studentService.addCourseToSchedule(student, courseCode);
        System.out.print("\n\n\n\n\nYour schedule\n");

        for (Course course : student.getWeeklySchedule().getCourses()) {
            System.out.println("|  " + course.getCourseCode() + "  |" + course.getCourseTitle());
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    private static void printStudentInfo(Student student)
    {
        System.out.print("\n\n\n\n\n"+ student.getName() + " " + student.getSurname() + "\n");
        System.out.println("UUID = " + student.getUuid());
        System.out.println("E-mail = " + student.getEmail());
        System.out.println("Birth Date = " + student.getBirthDate());
        System.out.println("Year enrolled = " + student.getYearEnrolled());
        System.out.println("Semester = " + student.getSemester());
        System.out.println("Advisor = " + (student.getAdvisor() == null ? "N/A" : (student.getAdvisor().getName() + " " + student.getAdvisor().getSurname())) + "\n");
        System.out.println("Press enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}