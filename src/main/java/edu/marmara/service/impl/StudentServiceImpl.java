package edu.marmara.service.impl;


import edu.marmara.model.AddCourseReturnType;
import edu.marmara.model.Course;
import edu.marmara.model.RemoveCourseReturnType;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.WeeklyDate;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class StudentServiceImpl implements StudentService {
    private final School school = School.getInstance();
    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (course.getGivenSemester() % 2 != student.getSemester() % 2) {
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

        if(student.getWeeklySchedule().getApproved() == Boolean.TRUE) {
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

        if(student.getWeeklySchedule().getApproved() == Boolean.TRUE) {
            return RemoveCourseReturnType.Locked;
        }

        if (student.getWeeklySchedule().getSendToReview() == Boolean.TRUE) {
            return RemoveCourseReturnType.WaitingScheduleReview;
        }

        if (student.getWeeklySchedule().getCourses().contains(course)){
            student.removeFromSchedule(course);
            course.decreaseTakenSeat();
            return RemoveCourseReturnType.Success;
        }

        return RemoveCourseReturnType.NotExist;
    }

    @Override
    public void assignRandomCourses() {
        List<Student> listOfStudents = school.getStudents();
        List<Course> listOfCourses = school.getCourses();

        Double passProbability = school.getConfig().getPassProbability();
        Double gradeLuck = school.getConfig().getGradeLuck();
        Double gradeVariance = school.getConfig().getGradeVariance();


        Random rng = new Random();

        for (Student student : listOfStudents) {
            if (student.getTranscript().getPassedCredit() + student.getTranscript().getFailedCredit() > 0) {
                continue;
            }

            for (Course course : listOfCourses) {
                if (course.getGivenSemester() > student.getSemester()) {
                    student.addNotTakenCourseToTranscript(course);
                    continue;
                }
                if (getAvailableCourses(student).contains(course)) {
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
            if (grade - Math.round(grade) > 0.25)  {
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
