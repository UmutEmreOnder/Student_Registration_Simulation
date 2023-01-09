package edu.marmara.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

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
}

