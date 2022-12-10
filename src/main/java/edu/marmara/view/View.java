package edu.marmara.view;

import edu.marmara.mapper.InstructorMapper;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.mapper.impl.InstructorMapperImpl;
import edu.marmara.mapper.impl.StudentMapperImpl;
import edu.marmara.model.Grade;
import edu.marmara.model.Instructor;
import edu.marmara.model.Schedule;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.DayName;


import static edu.marmara.model.DayName.FRI;
import static edu.marmara.model.DayName.MON;
import static edu.marmara.model.DayName.SAT;
import static edu.marmara.model.DayName.SUN;
import static edu.marmara.model.DayName.THU;
import static edu.marmara.model.DayName.TUE;
import static edu.marmara.model.DayName.WED;

import edu.marmara.model.Student;
import edu.marmara.model.WeeklyDate;
import edu.marmara.repository.InstructorRepository;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.InstructorRepositoryImpl;
import edu.marmara.repository.impl.StudentRepositoryImpl;
import edu.marmara.service.AdvisorService;
import edu.marmara.service.SchoolService;
import edu.marmara.service.StudentService;
import edu.marmara.service.impl.AdvisorServiceImpl;
import edu.marmara.service.impl.SchoolServiceImpl;
import edu.marmara.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;

public class View {
    public static StudentService studentService = new StudentServiceImpl();
    public static StudentRepository studentRepository = new StudentRepositoryImpl();
    public static InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    public static StudentMapper studentMapper = new StudentMapperImpl();
    public static InstructorMapper instructorMapper = new InstructorMapperImpl();
    public static SchoolService schoolService = new SchoolServiceImpl();
    public static AdvisorService advisorService = new AdvisorServiceImpl();
    public static Scanner scanner = new Scanner(System.in);

    private View() {
    }

    public static void start() throws IOException, ParseException {
        schoolService.uploadJsons();

        while (true) {
            System.out.println("Select User Type: \n1- Student\n2- Instructor\n9- Exit");
            Integer input = scanner.nextInt();
            if (input == 1) {
                printStudentMenu();
            } else if (input == 2) {
                printInstructorMenu();
            } else if (input == 9) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private static void printStudentMenu() {
        int input;

        System.out.print("Enter your Student ID: ");
        Student student = studentRepository.findByStudentId(scanner.nextLong());
        if (student != null) {
            while (true) {
                System.out.println("\nWelcome " + student.getName() + " " + student.getSurname() + "!");
                System.out.print("What would you like to do?\n1-View Student Info\n2-View Available Courses\n3-View Schedule\n4-View Transcript\n9-Exit\n");
                input = scanner.nextInt();
                switch (input) {
                    case 1: {
                        printStudentInfo(student);
                        break;
                    }
                    case 2: {
                        printAvailableCoursesStudent(student);
                        break;
                    }
                    case 3: {
                        printSchedule(student.getWeeklySchedule());
                        break;
                    }
                    case 4: {
                        printTranscript(student);
                        break;
                    }
                    case 9:
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
                if (input == 9) break;
            }
        } else {
            System.out.println("Cannot find the student with given ID");
        }
    }

    private static void printInstructorMenu() throws IOException {
        int input;
        long studentID;
        System.out.print("Enter your Email Address: ");
        Instructor instructor = instructorRepository.findByEmail(scanner.next());
        if (instructor != null) {
            while (true) {
                System.out.println("\nWelcome " + instructor.getName() + " " + instructor.getSurname() + "!");
                if (instructor instanceof Advisor) {
                    System.out.print("What would you like to do?\n1-View Student Info\n2-View Student Schedule" +
                            "\n3-View List Of Students\n4-View Instructor Info\n5-View Schedule\n9-Exit\n");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1: {
                            System.out.print("Enter student ID:");
                            studentID = scanner.nextLong();
                            Student student = advisorService.getStudent(studentID, (Advisor) instructor);
                            if (student != null) printStudentInfo(student);
                            else
                                System.out.println("The student you're trying to reach doesn't exist or you're not the advisor of him/her");
                            break;
                        }
                        case 2: {
                            System.out.print("Enter student ID:");
                            studentID = scanner.nextLong();
                            Student student = advisorService.getStudent(studentID, (Advisor) instructor);
                            if (student != null) printSchedule(student.getWeeklySchedule());
                            System.out.println("\n1- Approve\n2- Deny");

                            if (scanner.nextInt() == 1) {
                                advisorService.approveSchedule(student);
                            } else
                                System.out.println("The student you're trying to reach doesn't exist or you're not the advisor of him/her");
                            break;
                        }
                        case 3: {
                            for (Student student : ((Advisor) instructor).getStudents()) {
                                System.out.println(student.getStudentId() + " | " + student.getName() + " " + student.getSurname());
                            }
                            System.out.println("\nPress enter to go back");
                            Scanner scanner = new Scanner(System.in);
                            scanner.nextLine();
                            break;
                        }
                        case 4: {
                            printInstructorInfo(instructor);
                            break;
                        }
                        case 5: {
                            printSchedule(instructor.getWeeklySchedule());
                            break;
                        }
                        case 9:
                            break;
                        default:
                            System.out.println("Wrong input!");
                    }
                    if (input == 9) break;
                } else {
                    System.out.print("What would you like to do?\n1-View Instructor Info\n2-View Schedule" +
                            "\n9-Exit\n");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1: {
                            printInstructorInfo(instructor);
                            break;
                        }
                        case 2: {
                            printSchedule(instructor.getWeeklySchedule());
                            break;
                        }
                        case 9:
                            break;
                        default:
                            System.out.println("Wrong input!");
                    }
                    if (input == 9) break;
                }
            }
        } else {
            System.out.println("Cannot find the instructor with given email");
        }
    }

    private static void printTranscript(Student student) {
        if (student.getTranscript() != null) {
            System.out.println("\n\n\n\n\n");
            int passedCredit = student.getTranscript().getPassedCredit();
            int failedCredit = student.getTranscript().getFailedCredit();
            double gpa = studentService.calculateGPA(student);

            System.out.printf("\nGPA = %.2f\n", gpa);
            System.out.println("Passed Credit = " + passedCredit);
            System.out.println("Failed Credit = " + failedCredit);
            System.out.println("\nPassed Courses");
            for (Map.Entry<Course, Double> passedCourse : student.getTranscript().getPassedCourses().entrySet()) {
                System.out.println("| " + passedCourse.getKey().getCourseCode() + " | " + passedCourse.getKey().getCourseTitle() + " | " + Grade.valueOfGrade(passedCourse.getValue()));
            }
            System.out.println("\nFailed Courses");
            for (Course course : student.getTranscript().getFailedCourses()) {
                System.out.println("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " | " + "FF");
            }
            System.out.println("\nNot Taken Courses");
            for (Course course : student.getTranscript().getNotTakenCourses()) {
                System.out.println("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " |");
            }
        } else {
            System.out.println("Transcript is empty.");
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printSchedule(Schedule schedule) {
        System.out.print("\n\n\n\n\nSchedule");
        if (schedule == null) {
            System.out.print(" is empty.");
        } else {
            System.out.println();
            List<Course> mondayCourses = new ArrayList<Course>(), tuesdayCourses = new ArrayList<Course>(), wednesdayCourses = new ArrayList<Course>(), thursdayCourses = new ArrayList<Course>(), fridayCourses = new ArrayList<Course>(), saturdayCourses = new ArrayList<Course>(), sundayCourses = new ArrayList<Course>();

            for (Course course : schedule.getCourses()) {
                for (WeeklyDate weeklyDate : course.getDates()) {
                    switch (weeklyDate.getDayName()) {
                        case MON -> {
                            mondayCourses.add(course);
                        }
                        case TUE -> {
                            tuesdayCourses.add(course);
                        }
                        case WED -> {
                            wednesdayCourses.add(course);
                        }
                        case THU -> {
                            thursdayCourses.add(course);
                        }
                        case FRI -> {
                            fridayCourses.add(course);
                        }
                        case SAT -> {
                            saturdayCourses.add(course);
                        }
                        case SUN -> {
                            sundayCourses.add(course);
                        }
                    }
                }
            }
            printScheduleDays(mondayCourses, MON);
            printScheduleDays(tuesdayCourses, TUE);
            printScheduleDays(wednesdayCourses, WED);
            printScheduleDays(thursdayCourses, THU);
            printScheduleDays(fridayCourses, FRI);
            printScheduleDays(saturdayCourses, SAT);
            printScheduleDays(sundayCourses, SUN);
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printScheduleDays(List<Course> courses, DayName dayName) {
        switch (dayName) {
            case MON -> {
                System.out.print("\nMonday");
            }
            case TUE -> {
                System.out.print("\nTuesday");
            }
            case WED -> {
                System.out.print("\nWednesday");
            }
            case THU -> {
                System.out.print("\nThursday");
            }
            case FRI -> {
                System.out.print("\nFriday");
            }
            case SAT -> {
                System.out.print("\nSaturday");
            }
            case SUN -> {
                System.out.print("\nSunday");
            }
        }
        boolean isEmpty = true;
        for (int i = 9; i <= 18; i++) {
            L1:
            for (Course course : courses) {
                for (int j = 0; j < course.getDates().size(); j++) {
                    if (course.getDates().get(j).getDayName() == dayName && course.getDates().get(j).getHours() == i) {
                        if (isEmpty) System.out.println();
                        String formatted = String.format("%02d", i);
                        String formatted2 = String.format("%02d", i + 1);
                        System.out.println(formatted + ".00 -|  " + course.getCourseCode() + " " + course.getCourseTitle() + " |");
                        System.out.println(formatted2 + ".00  |          " + course.getInstructor().getName() + " " + course.getInstructor().getSurname() + "          |");
                        if (i != 18) System.out.println("------------------------------------");
                        isEmpty = false;
                        break L1;
                    }
                }
            }
        }
        if (isEmpty) System.out.print(" is empty.\n");
    }

    private static void printAvailableCoursesStudent(Student student) {
        System.out.print("\n\n\n\n\nAvailable Courses\n");
        List<Course> availableCourses = studentService.getAvailableCourses(student);
        for (Course course : availableCourses) {
            System.out.print("|  " + course.getCourseCode() + "  |" + course.getCourseTitle() + "|");
            for (int i = 0; i < course.getDates().size(); i++) {
                String dayName = "";
                switch (course.getDates().get(i).getDayName()) {
                    case MON -> dayName = "Monday";
                    case TUE -> dayName = "Tuesday";
                    case WED -> dayName = "Wednesday";
                    case THU -> dayName = "Thursday";
                    case FRI -> dayName = "Friday";
                    case SAT -> dayName = "Saturday";
                    case SUN -> dayName = "Sunday";
                }
                String formatted = String.format("%02d", course.getDates().get(i).getHours());
                String formatted2 = String.format("%02d", course.getDates().get(i).getHours() + 1);
                System.out.print(dayName + " " + formatted + ".00-" + formatted2 + ".00" + (i == course.getDates().size() - 1 ? "" : " & "));
            }
            System.out.println();
        }
        while (true) {
            System.out.print("\nEnter the course code to add it to your schedule or type 9 to exit and view your schedule: ");
            String courseCode = scanner.next();
            if (Objects.equals(courseCode, "9")) {
                System.out.print("\n\n\n\n\nYour schedule");
                if (student.getWeeklySchedule() != null) {
                    System.out.println();
                    for (Course course : student.getWeeklySchedule().getCourses()) {
                        System.out.println("|  " + course.getCourseCode() + "  |" + course.getCourseTitle());
                    }
                } else {
                    System.out.print(" is empty.");
                }
                break;
            } else {
                if (studentService.addCourseToSchedule(student, courseCode, availableCourses)) {
                    System.out.println(courseCode + " successfully added to your schedule!");
                } else {
                    System.out.println("You cannot add " + courseCode + " to your schedule!");
                }


            }
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printStudentInfo(Student student) {
        System.out.print("\n\n\n\n\n" + student.getName() + " " + student.getSurname() + "\n");
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

    private static void printInstructorInfo(Instructor instructor) {
        System.out.print("\n\n\n\n\n" + instructor.getName() + " " + instructor.getSurname() + "\n");
        System.out.println("UUID = " + instructor.getUuid());
        System.out.println("E-mail = " + instructor.getEmail());
        System.out.println("Birth Date = " + instructor.getBirthDate());
        System.out.println("\nPresented Courses");
        for (Course course : instructor.getPresentedCourses()) {
            System.out.println(course.getCourseCode() + " | " + course.getCourseTitle());
        }
        System.out.println("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}