package edu.marmara.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.model.Course;
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

    /**
     * Method under test:
     *
     * Class:CourseRepositoryImpl Method:save(Course)
     */
    @Test
    void testSave() {
        // TODO: Complete this test.

        CourseRepositoryImpl courseRepositoryImpl = new CourseRepositoryImpl();
        courseRepositoryImpl.save(new Course());
    }


}

