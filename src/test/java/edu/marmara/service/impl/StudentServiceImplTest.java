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
     * Class:StudentServiceImpl Method:assignRandomCourses()
     */
    @Test
    void testAssignRandomCourses() {
        (new StudentServiceImpl()).assignRandomCourses();
    }
}

