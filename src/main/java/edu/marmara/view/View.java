package edu.marmara.view;

import edu.marmara.mapper.InstructorMapper;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.mapper.impl.InstructorMapperImpl;
import edu.marmara.mapper.impl.StudentMapperImpl;
import edu.marmara.model.AddCourseReturnType;
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
import edu.marmara.model.Grade;
import edu.marmara.model.Instructor;
import edu.marmara.model.RemoveCourseReturnType;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import java.io.IOException;
import java.text.ParseException;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    public static StudentService studentService = new StudentServiceImpl();
    public static StudentRepository studentRepository = new StudentRepositoryImpl();
    public static InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    public static StudentMapper studentMapper = new StudentMapperImpl();
    public static InstructorMapper instructorMapper = new InstructorMapperImpl();
    public static SchoolService schoolService = new SchoolServiceImpl();
    public static AdvisorService advisorService = new AdvisorServiceImpl();
    public static Scanner scanner = new Scanner(System.in);

    private static final School school = School.getInstance();

    private static final Logger logger = Logger.getLogger(View.class.getName());


    private static void configureLogger() {
        try {
            // get the current time
            Date date = new Date();

            // generate the log file name using the current time
            String fileName = "log-" + date.toString() + ".txt";

            // configure the logger
            FileHandler handler = new FileHandler("logs/" + fileName);
            // Create a console handler that writes log messages to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();

            // Set the formatter for both handlers to use the CustomFormatter
            handler.setFormatter(new edu.marmara.view.formatter.CustomFormatter());
            consoleHandler.setFormatter(new edu.marmara.view.formatter.CustomFormatter());

            // Add the file and console handlers to the logger
            logger.addHandler(handler);
            logger.addHandler(consoleHandler);

            // Set the logger to not use the parent (default) handlers
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "an error occurred while configuring the logger", e);
        }
    }
    private View() {
    }

    public static void start() throws IOException, ParseException {
        schoolService.uploadJsons();
        configureLogger();
        while (true) {
            logger.info("Select User Type: \n1- Student\n2- Instructor\n9- Exit");
            Integer input = scanner.nextInt();
            if (input == 1) {
                printStudentMenu();
            } else if (input == 2) {
                printInstructorMenu();
            } else if (input == 9) {
                logger.info("User chose to 9- Exit.");
                break;
            } else {
                logger.warning("Wrong input!");
            }
        }
    }

    private static void printStudentMenu() {
        int input;

        logger.info("Enter your Student ID: ");
        long id = scanner.nextLong();
        logger.info("Student entered his/her ID as: " + id);
        Student student = studentRepository.findByStudentId(id);
        if (student != null) {
            while (true) {
                logger.info("\nWelcome " + student.getName() + " " + student.getSurname() + "!");
                logger.info("What would you like to do?\n1-View Student Info\n2-Add/Drop Course\n3-View Schedule\n4-View Transcript\n9-Exit\n");
                input = scanner.nextInt();
                switch (input) {
                    case 1: {
                        logger.info("Student chose to check 1-View Student Info.");
                        printStudentInfo(student);
                        break;
                    }
                    case 2: {
                        logger.info("Student chose to check 2-Add/Drop Courses.");
                        printAddDropMenu(student);
                        break;
                    }
                    case 3: {
                        logger.info("Student chose to check 3-View Schedule.");
                        printSchedule(student.getWeeklySchedule(), true);
                        break;
                    }
                    case 4: {
                        logger.info("Student chose to check 4-View Transcript.");
                        printTranscript(student);
                        break;
                    }
                    case 9:
                        logger.info("Student chose to 9-Exit.");
                        break;
                    default:
                        logger.warning("Wrong input!");
                }
                if (input == 9) break;
            }
        } else {
            logger.warning("Cannot find the student with given ID");
        }
    }

    private static void printInstructorMenu() throws IOException {
        int input;
        long studentID;
        logger.info("Enter your Email Address: ");
        String email = scanner.next();
        logger.info("User entered this Email Address: " + email);
        Instructor instructor = instructorRepository.findByEmail(email);
        if (instructor != null) {
            while (true) {
                logger.info("\nWelcome " + instructor.getName() + " " + instructor.getSurname() + "!");
                if (instructor instanceof Advisor) {
                    logger.info("What would you like to do?\n1-View Student Info\n2-View Student Schedule" +
                            "\n3-View List Of Students\n4-View Instructor Info\n5-View Schedule\n9-Exit\n");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1: {
                            logger.info("Instructor wanted to view Student Info -1");
                            logger.info("Enter student ID:");
                            studentID = scanner.nextLong();
                            logger.info("Instructor entered this studentID: " + studentID);
                            Student student = advisorService.getStudent(studentID, (Advisor) instructor);
                            if (student != null) printStudentInfo(student);
                            else
                                logger.info("The student you're trying to reach doesn't exist or you're not the advisor of him/her");
                            break;
                        }
                        case 2: {
                            logger.info("Instructor wanted to view Student Schedule -2");
                            logger.info("Enter student ID:");
                            studentID = scanner.nextLong();
                            logger.info("Instructor wanted to check this student's schedule: " + studentID);
                            Student student = advisorService.getStudent(studentID, (Advisor) instructor);
                            if (student != null) {
                                if (student.getWeeklySchedule().getSendToReview() != Boolean.TRUE) {
                                    logger.info("The student hasn't send his schedule to review yet!");
                                } else {
                                    printSchedule(student.getWeeklySchedule(), false);

                                    if (student.getWeeklySchedule().getApproved() != Boolean.TRUE) {
                                        logger.info("\n1- Approve\n2- Deny");

                                        if (scanner.nextInt() == 1) {
                                            advisorService.approveSchedule(student);
                                            logger.info("You've successfully approved the schedule");
                                        } else {
                                            advisorService.denySchedule(student);
                                            logger.info("You've successfully denied the schedule");
                                        }
                                    }
                                }
                            } else
                                logger.info("The student you're trying to reach doesn't exist or you're not the advisor of him/her");
                            break;
                        }
                        case 3: {
                            logger.info("Instructor wanted to view Student List -3");
                            for (Student student : ((Advisor) instructor).getStudents()) {
                                logger.info(student.getStudentId() + " | " + student.getName() + " " + student.getSurname());
                            }
                            logger.info("\nPress enter to go back");
                            Scanner scanner = new Scanner(System.in);
                            scanner.nextLine();
                            break;
                        }
                        case 4: {
                            logger.info("Instructor wanted to View Instructor Info -4");
                            printInstructorInfo(instructor);
                            break;
                        }
                        case 5: {
                            logger.info("Instructor wanted to View Schedule -5");
                            printSchedule(instructor.getWeeklySchedule(), false);
                            break;
                        }
                        case 9:
                            logger.info("Instructor wanted to Exit -9");
                            break;
                        default:
                            logger.warning("Wrong input!");
                    }
                    if (input == 9) break;
                } else {
                    logger.info("What would you like to do?\n1-View Instructor Info\n2-View Schedule" +
                            "\n9-Exit\n");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1: {
                            logger.info("Instructor wanted to View Instructor Info -1");
                            printInstructorInfo(instructor);
                            break;
                        }
                        case 2: {
                            logger.info("Instructor wanted to View Schedule -2");
                            printSchedule(instructor.getWeeklySchedule(), false);
                            break;
                        }
                        case 9:
                            logger.info("Instructor wanted to Exit -9");
                            break;
                        default:
                            logger.warning("Wrong input!");
                    }
                    if (input == 9) {
                        logger.info("Wanted to Exit -9");
                        break;
                    }

                }
            }
        } else {
            logger.warning("Cannot find the instructor with given email");
        }
    }

    private static void printTranscript(Student student) {
        if (student.getTranscript() != null) {
            logger.info("\n\n\n\n\n");
            int passedCredit = student.getTranscript().getPassedCredit();
            int failedCredit = student.getTranscript().getFailedCredit();
            double gpa = student.getTranscript().getGpa();

            logger.info("\nGPA = \n" + String.format("%.2f", gpa));
            logger.info("Passed Credit = " + passedCredit);
            logger.info("Failed Credit = " + failedCredit);
            logger.info("\nPassed Courses");
            for (Map.Entry<Course, Double> passedCourse : student.getTranscript().getPassedCourses().entrySet()) {
                logger.info("| " + passedCourse.getKey().getCourseCode() + " | " + passedCourse.getKey().getCourseTitle() + " | " + Grade.valueOfGrade(passedCourse.getValue()));
            }
            logger.info("\nFailed Courses");
            for (Course course : student.getTranscript().getFailedCourses()) {
                logger.info("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " | " + "FF");
            }
            logger.info("\nCurrently Taken Courses");
            for (Course course : student.getTranscript().getCurrentlyTakenCourses()) {
                logger.info("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " |");
            }
            logger.info("\nNot Taken Courses");
            for (Course course : student.getTranscript().getNotTakenCourses()) {
                logger.info("| " + course.getCourseCode() + " | " + course.getCourseTitle() + " |");
            }
        } else {
            logger.info("Transcript is empty.");
        }
        logger.info("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printSchedule(Schedule schedule, Boolean isStudent) {
        logger.info("\n\n\n\n\nSchedule");
        if (schedule == null) {
            logger.info(" is empty.");
        } else {
            logger.info("\n");
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


        if (Boolean.TRUE.equals(isStudent)) {
            logger.info("\n\n1-Send to Review\n9-Exit");
            Integer choice = scanner.nextInt();

            if (choice == 1) {
                if (schedule.getApproved() == Boolean.FALSE)
                {
                    if (schedule.getSendToReview() == Boolean.TRUE){
                        logger.info("You've already sent your draft schedule to your advisor!");
                    }else {
                        int totalCredit = 0;

                        for (Course course : schedule.getCourses()) {
                            totalCredit += course.getCourseCredit();
                        }

                        if (totalCredit < school.getConfig().getMinimumCreditReq()){
                            logger.info("You cannot send your schedule to review since your total credit(" + totalCredit + ") is lower than minimum credit requirement " + school.getConfig().getMinimumCreditReq());
                        } else {
                            schedule.setSendToReview(Boolean.TRUE);
                            logger.info("You've successfully sent your schedule to your advisor to review!");
                        }
                    }
                } else {
                    logger.info("You can't modify your schedule since it's already has been approved by your advisor.");
                }
            }
        }

    }

    private static void printScheduleDays(List<Course> courses, DayName dayName) {
        switch (dayName) {
            case MON -> {
                logger.info("\nMonday");
            }
            case TUE -> {
                logger.info("\nTuesday");
            }
            case WED -> {
                logger.info("\nWednesday");
            }
            case THU -> {
                logger.info("\nThursday");
            }
            case FRI -> {
                logger.info("\nFriday");
            }
            case SAT -> {
                logger.info("\nSaturday");
            }
            case SUN -> {
                logger.info("\nSunday");
            }
        }
        boolean isEmpty = true;
        for (int i = 9; i <= 18; i++) {
            L1:
            for (Course course : courses) {
                for (int j = 0; j < course.getDates().size(); j++) {
                    if (course.getDates().get(j).getDayName() == dayName && course.getDates().get(j).getHours() == i) {
                        if (isEmpty) logger.info("\n");
                        String formatted = String.format("%02d", i);
                        String formatted2 = String.format("%02d", i + 1);
                        logger.info(formatted + ".00 -|  " + course.getCourseCode() + " " + course.getCourseTitle() + " |");
                        logger.info(formatted2 + ".00  |          " + course.getInstructor().getName() + " " + course.getInstructor().getSurname() + "          |");
                        if (i != 18) logger.info("------------------------------------");
                        isEmpty = false;
                        break L1;
                    }
                }
            }
        }
        if (isEmpty) logger.info(" is empty.\n");
    }

    private static void printAddDropMenu(Student student) {
        while (true) {
            logger.info("\nSelect the Operation:\n1- Add Course\n2- Remove Course\n9- Exit");
            Integer choice = scanner.nextInt();

            if (choice == 1) {
                addCourseMenu(student);
            } else if (choice == 2) {
                removeCourseMenu(student);
            } else if (choice == 9) {
                break;
            } else {
                logger.info("\nWrong Input!\n");
            }
        }
        scanner.nextLine();
    }

    private static void removeCourseMenu(Student student) {
        for (Course course : student.getWeeklySchedule().getCourses()) {
            logger.info("|  " + course.getCourseCode() + "  |" + course.getCourseTitle());
        }

        while (true) {
            logger.info("\nEnter the course code to remove from your schedule (Type 9 to exit): ");
            String courseCode = scanner.next();

            if (courseCode.equals("9")) {
                break;
            }

            RemoveCourseReturnType isRemoved = studentService.removeCourseFromSchedule(student, courseCode);

            if (isRemoved == RemoveCourseReturnType.Locked){
                logger.info("You can't remove any course since your schedule is already been approved!");
            }

            if (isRemoved == RemoveCourseReturnType.WaitingScheduleReview) {
                logger.info("Your schedule is under review by your advisor right now!");
            }

            if (isRemoved == RemoveCourseReturnType.NotExist) {
                logger.info("You cannot remove " + courseCode + " from your schedule!");
            }

            if (isRemoved == RemoveCourseReturnType.Success) {
                logger.info("You successfully removed " + courseCode + " from your schedule");
            }
        }
    }

    private static void addCourseMenu(Student student) {
        logger.info("\n\n\n\n\nAvailable Courses\n");
        List<Course> availableCourses = studentService.getAvailableCourses(student, Boolean.FALSE);
        for (Course course : availableCourses) {
            logger.info("|  " + course.getCourseCode() + "  |  " + course.getCourseTitle() + "  |  " + course.getTakenSeats() + "/" + course.getMaxSeats() + " |");
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
                logger.info(dayName + " " + formatted + ".00-" + formatted2 + ".00" + (i == course.getDates().size() - 1 ? "" : " & "));
            }
            logger.info("\n");
        }

        while (true) {
            logger.info("\nEnter the course code to add it to your schedule (Type 9 to exit): ");
            String courseCode = scanner.next();

            if (courseCode.equals("9")) {
                break;
            }

            AddCourseReturnType isAdded = studentService.addCourseToSchedule(student, courseCode, availableCourses);

            if (isAdded == AddCourseReturnType.Locked){
                logger.info("You can't add any course right now since your schedule is approved!");
            }

            if (isAdded == AddCourseReturnType.WaitingScheduleReview) {
                logger.info("Your schedule is under review by your advisor right now!");
            }

            if (isAdded == AddCourseReturnType.SlotNotEmpty) {
                logger.info("You cannot add " + courseCode + " because the time slot is not empty!");
            }

            if (isAdded == AddCourseReturnType.Success) {
                logger.info(courseCode + " successfully added to your schedule!");
            }

            if (isAdded == AddCourseReturnType.NotExistOnAvailableCourses) {
                logger.info("You cannot add " + courseCode + " to your schedule!");
            }

            if (isAdded == AddCourseReturnType.NoAvailableSeats) {
                logger.info("You cannot add " + courseCode + " because there isn't any available seats!");
            }
        }
    }

    private static void printStudentInfo(Student student) {
        logger.info("\n\n\n\n\n" + student.getName() + " " + student.getSurname() + "\n");
        logger.info("UUID = " + student.getUuid());
        logger.info("E-mail = " + student.getEmail());
        logger.info("Birth Date = " + student.getBirthDate());
        logger.info("Year enrolled = " + student.getYearEnrolled());
        logger.info("Semester = " + student.getSemester());
        logger.info("Advisor = " + (student.getAdvisor() == null ? "N/A" : (student.getAdvisor().getName() + " " + student.getAdvisor().getSurname())) + "\n");
        logger.info("Press enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printInstructorInfo(Instructor instructor) {
        logger.info("\n\n\n\n\n" + instructor.getName() + " " + instructor.getSurname() + "\n");
        logger.info("UUID = " + instructor.getUuid());
        logger.info("E-mail = " + instructor.getEmail());
        logger.info("Birth Date = " + instructor.getBirthDate());
        logger.info("\nPresented Courses");
        for (Course course : instructor.getPresentedCourses()) {
            logger.info(course.getCourseCode() + " | " + course.getCourseTitle());
        }
        logger.info("\nPress enter to go back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}