package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class StudentServiceImplTest {
    /**
     * Method under test:
     *
     * Class:StudentServiceImpl Method:getAvailableCourses(Student)
     */
    @Test
    void testGetAvailableCourses() {
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        assertTrue(studentServiceImpl.getAvailableCourses(new Student()).isEmpty());
    }

    /**
     * Method under test:
     *
     * Class:StudentServiceImpl Method:addCourseToSchedule(Student, String, List)
     */
    @Test
    void testAddCourseToSchedule() {
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        Student student = new Student();
        ArrayList<Course> courseList = new ArrayList<>();
        assertFalse(studentServiceImpl.addCourseToSchedule(student, "Course Code", courseList));
        assertEquals(courseList, student.getWeeklySchedule().getCourses());
    }



    /**
     * Method under test:
     *
     * Class:StudentServiceImpl Method:addCourseToSchedule(Student, String, List)
     */
    @Test
    void testAddCourseToSchedule3() {
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        Schedule weeklySchedule = new Schedule();
        Transcript transcript = new Transcript();
        Student student = new Student(123L, 1, weeklySchedule, transcript, new Advisor(), 1);

        assertFalse(studentServiceImpl.addCourseToSchedule(student, "Course Code", new ArrayList<>()));
    }

    /**
     * Method under test:
     *
     * Class:StudentServiceImpl Method:assignRandomCourses()
     */
    @Test
    void testAssignRandomCourses() {
        // TODO: Complete this test.

        (new StudentServiceImpl()).assignRandomCourses();
    }

    /**
     * Method under test:
     *
     * Class:StudentServiceImpl Method:addCourseToSchedule(Student, String, List)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCourseToSchedule2() {
        // TODO: Complete this test.

        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        studentServiceImpl.addCourseToSchedule(null, "Course Code", new ArrayList<>());
    }
}

