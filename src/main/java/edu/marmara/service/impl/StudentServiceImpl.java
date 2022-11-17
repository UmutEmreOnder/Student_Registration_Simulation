package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private School school = School.getInstance();
    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public List<Course> getAvailableCourses(Student student) {
        List<Course> courses = new ArrayList<>();

        outerloop:
        for (Course course : school.getCourses()) {
            if (!student.getTranscript().getPassedCourses().contains(course)) {
                // Check prerequisites
                if (course.getPrerequisites() != null) {
                    for (Course prerequisiteCourse : course.getPrerequisites()) {
                        if (! student.getTranscript().getPassedCourses().contains(prerequisiteCourse)) {
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
}
