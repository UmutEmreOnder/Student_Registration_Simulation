package edu.marmara.service.impl;


import edu.marmara.model.AddCourseReturnType;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.RemoveCourseReturnType;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.WeeklyDate;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;
import static edu.marmara.view.View.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class StudentServiceImpl implements StudentService {
    private final School school = School.getInstance();
    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public List<Course> getAvailableCourses(Student student, Boolean isRandom) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (Boolean.FALSE.equals(isRandom) && course.getGivenSemester() % 2 != student.getSemester() % 2) {
                continue;
            }

            if (course.getMinCreditReq() > student.getTranscript().getPassedCredit()) {
                continue;
            }

            if (!student.getTranscript().getPassedCourses().containsKey(course)) {

                if (course.getPrerequisites() != null) {
                    for (Course prerequisiteCourse : course.getPrerequisites()) {
                        if (!student.getTranscript().getPassedCourses().containsKey(prerequisiteCourse)) {
                            continue outerloop;
                        }
                    }
                }

                if (student.getWeeklySchedule() != null) {
                    if (!student.getWeeklySchedule().getCourses().contains(course)) {
                        courses.add(course);
                    }
                } else {
                    courses.add(course);
                }
            }
        }

        return courses;
    }


    @Override
    public AddCourseReturnType addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (course == null) {
            return AddCourseReturnType.NotExistOnAvailableCourses;
        }

        if (student.getWeeklySchedule().getApproved() == Boolean.TRUE) {
            return AddCourseReturnType.Locked;
        }

        if (student.getWeeklySchedule().getSendToReview() == Boolean.TRUE) {
            return AddCourseReturnType.WaitingScheduleReview;
        }

        if (course.getMaxSeats() <= course.getTakenSeats()) {
            return AddCourseReturnType.NoAvailableSeats;
        }

        if (!isSlotEmpty(student.getWeeklySchedule().getCourses(), course)) {
            return AddCourseReturnType.SlotNotEmpty;
        }

        if (availableCourses.contains(course)) {
            student.addCourseToSchedule(course);
            course.increaseTakenSeat();
            return AddCourseReturnType.Success;
        }

        return AddCourseReturnType.NotExistOnAvailableCourses;
    }

    // todo: Find course from courseCode, remove it from Schedule (if the Course is not in schedule, return false). You need to check if the schedule is approved or sendToReview (if it is, then don't let student to change it)
    @Override
    public RemoveCourseReturnType removeCourseFromSchedule(Student student, String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (student.getWeeklySchedule().getApproved() == Boolean.TRUE) {
            return RemoveCourseReturnType.Locked;
        }

        if (student.getWeeklySchedule().getSendToReview() == Boolean.TRUE) {
            return RemoveCourseReturnType.WaitingScheduleReview;
        }

        if (student.getWeeklySchedule().getCourses().contains(course)) {
            student.removeFromSchedule(course);
            course.decreaseTakenSeat();
            return RemoveCourseReturnType.Success;
        }

        return RemoveCourseReturnType.NotExist;
    }

    @Override
    public void assignRandomCourses(Student student) {
        List<Course> listOfCourses = school.getCourses();

        Double passProbability = school.getConfig().getPassProbability();
        Double gradeLuck = school.getConfig().getGradeLuck();
        Double gradeVariance = school.getConfig().getGradeVariance();


        Random rng = new Random();

        for (Course course : listOfCourses) {
            if (course.getGivenSemester() > student.getSemester()) {
                student.addNotTakenCourseToTranscript(course);
                continue;
            }
            if (getAvailableCourses(student, Boolean.TRUE).contains(course)) {
                double rand = rng.nextDouble();
                if (rand <= passProbability) {
                    Double grade = getGrade(gradeLuck, gradeVariance);
                    student.getTranscript().getPassedCourses().put(course, grade);
                    student.getTranscript().setPassedCredit(student.getTranscript().getPassedCredit() + course.getCourseCredit());
                } else {
                    student.addFailedCoursesToTranscript(course);
                    student.getTranscript().setFailedCredit(student.getTranscript().getFailedCredit() + course.getCourseCredit());
                }
            } else {
                student.addNotTakenCourseToTranscript(course);
            }
        }

        student.calculateGPA();
    }

    @Override
    public void enrollRandomCourses() {
        Random random = new Random();
        List<Student> students = School.getInstance().getStudents();
        List<Instructor> instructors = School.getInstance().getInstructors();

        while (true) {
            Integer num = random.nextInt(10000);

            if (num == 1) {
                logger.info("Simulation ended");
                break;
            }

            if (students.isEmpty()) {
                logger.info("There is no students");
                break;
            }

            if (num <= 8000) {
                Integer studentIndex = random.nextInt(students.size());
                Student student = students.get(studentIndex);
                List<Course> availableCourses = getAvailableCourses(student, false);

                if (availableCourses.isEmpty()) {
                    continue;
                }

                Integer courseIndex = random.nextInt(availableCourses.size());
                Course course = availableCourses.get(courseIndex);
                AddCourseReturnType isAdded = addCourseToSchedule(student, course.getCourseCode(), availableCourses);

                if (isAdded == AddCourseReturnType.Locked) {
                    logger.warning(String.format("%d you can't add any course right now since your schedule is approved!\n", student.getStudentId()));
                }

                if (isAdded == AddCourseReturnType.WaitingScheduleReview) {
                    logger.warning(String.format("%d your schedule is under review by your advisor right now!\n", student.getStudentId()));
                }

                if (isAdded == AddCourseReturnType.SlotNotEmpty) {
                    logger.warning(String.format("%d you cannot add %s because the time slot is not empty!\n", student.getStudentId(), course.getCourseTitle()));
                }

                if (isAdded == AddCourseReturnType.Success) {
                    logger.info(String.format("%d successfully added %s to his/her schedule!\n",  student.getStudentId(), course.getCourseTitle()));
                }

                if (isAdded == AddCourseReturnType.NoAvailableSeats) {
                    logger.warning(String.format("%d you cannot add %s because there isn't any available seats!\n", student.getStudentId(), course.getCourseTitle()));
                }

                Boolean send = random.nextInt(100) <= 20;
                if (send) {
                    if (student.getWeeklySchedule().getSendToReview() == Boolean.TRUE) {
                        logger.warning(String.format("%d you've already sent your draft schedule to your advisor!\n", student.getStudentId()));
                    } else {
                        int totalCredit = 0;

                        for (Course ignored : student.getWeeklySchedule().getCourses()) {
                            totalCredit += course.getCourseCredit();
                        }

                        if (totalCredit < school.getConfig().getMinimumCreditReq()) {
                            logger.warning(String.format("%d you cannot send your schedule to review since your total credit(" + totalCredit + ") is lower than minimum credit requirement " + school.getConfig().getMinimumCreditReq() + "\n", student.getStudentId()));
                        } else {
                            student.getWeeklySchedule().setSendToReview(Boolean.TRUE);
                            logger.info(String.format("%d successfully sent his/her schedule to your advisor to review!\n", student.getStudentId()));
                        }
                    }
                }
            } else {
                Integer studentIndex = random.nextInt(students.size());
                Student student = students.get(studentIndex);
                List<Course> enrolledCourses = student.getWeeklySchedule().getCourses();

                if (enrolledCourses.isEmpty()) {
                    continue;
                }

                Integer courseIndex = random.nextInt(enrolledCourses.size());
                Course course = enrolledCourses.get(courseIndex);
                RemoveCourseReturnType isRemoved = removeCourseFromSchedule(student, course.getCourseCode());

                if (isRemoved == RemoveCourseReturnType.Locked) {
                    logger.warning(String.format("%d you can't remove any course since your schedule is already been approved!\n", student.getStudentId()));
                }

                if (isRemoved == RemoveCourseReturnType.WaitingScheduleReview) {
                    logger.warning(String.format("%d your schedule is under review by your advisor right now!\n", student.getStudentId()));
                }

                if (isRemoved == RemoveCourseReturnType.NotExist) {
                    logger.warning(String.format("%d you cannot remove %s from your schedule!\n", student.getStudentId(), course.getCourseTitle()));
                }

                if (isRemoved == RemoveCourseReturnType.Success) {
                    logger.info(String.format("%d successfully removed %s from his/her schedule\n", student.getStudentId(), course.getCourseTitle()));
                }
            }


            if (instructors.isEmpty()) {
                continue;
            }

            Integer instructorIndex = random.nextInt(instructors.size());
            Instructor instructor = instructors.get(instructorIndex);

            if (!(instructor instanceof Advisor)) {
                continue;
            }

            for (Student studentOfAdvisor : ((Advisor) instructor).getStudents()) {
                if (Boolean.TRUE.equals(studentOfAdvisor.getWeeklySchedule().getSendToReview()) && Boolean.FALSE.equals(studentOfAdvisor.getWeeklySchedule().getApproved())) {
                    Boolean approve = random.nextBoolean();

                    if (approve) {
                        studentOfAdvisor.getWeeklySchedule().setApproved(Boolean.TRUE);
                        logger.info(String.format("%s successfully approved %d's schedule\n", instructor.getName(), studentOfAdvisor.getStudentId()));
                    } else {
                        studentOfAdvisor.getWeeklySchedule().setSendToReview(Boolean.FALSE);
                        logger.info(String.format("%s successfully denied %d's schedule\n", instructor.getName(), studentOfAdvisor.getStudentId()));
                    }
                }
            }
        }
    }

    @Override
    public Boolean sendToReview(Schedule schedule) {
        if (schedule.getApproved() == Boolean.FALSE) {
            if (schedule.getSendToReview() == Boolean.TRUE) {
                logger.warning("You've already sent your draft schedule to your advisor!\n");
            } else {
                int totalCredit = 0;

                for (Course course : schedule.getCourses()) {
                    totalCredit += course.getCourseCredit();
                }

                if (totalCredit < school.getConfig().getMinimumCreditReq()) {
                    logger.warning("You cannot send your schedule to review since your total credit(" + totalCredit + ") is lower than minimum credit requirement " + school.getConfig().getMinimumCreditReq() + "\n");
                } else {
                    schedule.setSendToReview(Boolean.TRUE);
                    logger.info("You've successfully sent your schedule to your advisor to review!\n");
                    return Boolean.TRUE;
                }
            }
        } else {
            logger.warning("You can't modify your schedule since it's already has been approved by your advisor.\n");
        }

        return Boolean.FALSE;
    }

    private Double getGrade(Double gradeLuck, Double gradeVariance) {
        Random fRandom = new Random();
        double grade = -1;
        while (grade < 0 || grade > 4.00) {
            grade = gradeLuck * (4) + fRandom.nextGaussian() * gradeVariance;
        }

        if (grade < 0.25) {
            return 0.5;
        } else if (Math.round(grade) < grade) {
            if (grade - Math.round(grade) > 0.25) {
                return Math.round(grade) + 0.5;
            } else {
                return (double) Math.round(grade);
            }
        } else {
            if (Math.round(grade) - grade > 0.25) {
                return Math.round(grade) - 0.5;
            } else {
                return (double) Math.round(grade);
            }
        }
    }

    private boolean isSlotEmpty(List<Course> schedule, Course course) {

        for (Course c : schedule) {
            for (WeeklyDate dt : course.getDates()) {
                for (WeeklyDate dt2 : c.getDates()) {
                    if (dt.getDayName().equals(dt2.getDayName()) && Objects.equals(dt.getHours(), dt2.getHours())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
