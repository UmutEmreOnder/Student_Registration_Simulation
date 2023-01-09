package edu.marmara.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CourseRepositoryImplTest {
    /**
     * Method under test:
     *
     * Class:CourseRepositoryImpl Method:findByCourseCode(String)
     */
    @Test
    void testFindByCourseCode() {
        assertNull((new CourseRepositoryImpl()).findByCourseCode("Course Code"));
        assertNull((new CourseRepositoryImpl()).findByCourseCode("foo"));
    }

}

