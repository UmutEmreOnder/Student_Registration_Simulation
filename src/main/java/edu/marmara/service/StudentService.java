package edu.marmara.service;

import edu.marmara.model.AddCourseReturnType;
import edu.marmara.model.Course;
import edu.marmara.model.RemoveCourseReturnType;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;

import java.util.List;

public interface StudentService {
    List<Course> getAvailableCourses(Student student, Boolean isRandom);

    AddCourseReturnType addCourseToSchedule(Student student, String courseCode, List<Course> availableCourses);

    RemoveCourseReturnType removeCourseFromSchedule(Student student, String courseCode);

    void assignRandomCourses(Student student);

    void enrollRandomCourses();

    Boolean sendToReview(Schedule schedule);
}
