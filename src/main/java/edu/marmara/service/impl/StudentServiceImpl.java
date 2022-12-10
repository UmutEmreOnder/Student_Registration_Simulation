package edu.marmara.service.impl;

import edu.marmara.model.*;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.*;

public class StudentServiceImpl implements StudentService {
    private final School school = School.getInstance();
    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (!student.getTranscript().getPassedCourses().containsKey(course)) {
                // Check prerequisites
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
    public Boolean addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses) {
        Course course = courseRepository.findByCourseCode(courseCode);

        if (student.getWeeklySchedule() == null) {
            student.setWeeklySchedule(new Schedule());
            student.getWeeklySchedule().setCourses(new ArrayList<>());
        }

        if (course != null && availableCourses.contains(course)) {
            student.getWeeklySchedule().getCourses().add(course);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
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
            for (Course course : listOfCourses) {
                if (course.getGivenSemester() > student.getSemester()) {
                    student.getTranscript().getNotTakenCourses().add(course);
                    continue;
                }
                if (getAvailableCourses(student).contains(course)) {
                    double rand = rng.nextDouble();
                    if (rand <= passProbability) {
                        Double grade = getGrade(gradeLuck, gradeVariance);
                        student.getTranscript().getPassedCourses().put(course, grade);
                        student.getTranscript().setPassedCredit(student.getTranscript().getPassedCredit() + course.getCourseCredit());
                    } else {
                        student.getTranscript().getFailedCourses().add(course);
                        student.getTranscript().setFailedCredit(student.getTranscript().getFailedCredit() + course.getCourseCredit());
                    }
                } else {
                    student.getTranscript().getNotTakenCourses().add(course);
                }
            }
        }
    }

    @Override
    public Double calculateGPA(Student student) {
        HashMap<Course, Double> passedCourses = student.getTranscript().getPassedCourses();
        double gpa = 0;

        for (Map.Entry<Course, Double> entry : passedCourses.entrySet())
            gpa += entry.getValue() * entry.getKey().getCourseCredit();

        gpa = gpa / (student.getTranscript().getPassedCredit() + student.getTranscript().getFailedCredit());
        student.getTranscript().setGpa(gpa);

        return gpa;
    }

    private static Double getGrade(Double gradeLuck, Double gradeVariance) {
        Random fRandom = new Random();
        double grade = -1;
        while (grade < 0 || grade > 4.00)
            grade = gradeLuck * (4) + fRandom.nextGaussian() * gradeVariance;

        if (grade < 0.25){
            return 0.5;
        }
        else if(Math.round(grade) < grade){
            if(grade - Math.round(grade) > 0.25) return Math.round(grade) + 0.5;
            else return (double)Math.round(grade);
        }
        else{
            if(Math.round(grade) - grade > 0.25) return Math.round(grade) - 0.5;
            else return (double)Math.round(grade);
        }
    }
    /*
    private static double getGaussian(double aMean, double aVariance){
        return aMean + fRandom.nextGaussian() * aVariance;
    }
     */
}
