package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.marmara.model.Student;

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
        assertTrue(studentServiceImpl.getAvailableCourses(new Student(), false).isEmpty());
    }
}

