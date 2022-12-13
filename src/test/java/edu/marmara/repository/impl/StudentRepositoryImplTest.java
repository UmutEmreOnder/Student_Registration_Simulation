package edu.marmara.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.model.Student;
import org.junit.jupiter.api.Test;

class StudentRepositoryImplTest {

    /**
     * Method under test:
     *
     * Class:StudentRepositoryImpl Method:findByStudentId(Long)
     */
    @Test
    void testFindByStudentId() {
        assertNull((new StudentRepositoryImpl()).findByStudentId(123L));
        assertNull((new StudentRepositoryImpl()).findByStudentId(1L));
    }

    /**
     * Method under test:
     *
     * Class:StudentRepositoryImpl Method:save(Student)
     */
    @Test
    void testSave() {
        // TODO: Complete this test.

        StudentRepositoryImpl studentRepositoryImpl = new StudentRepositoryImpl();
        studentRepositoryImpl.save(new Student());
    }

}

