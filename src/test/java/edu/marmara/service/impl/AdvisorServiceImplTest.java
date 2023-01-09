package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.model.Advisor;

import org.junit.jupiter.api.Test;

class AdvisorServiceImplTest {
    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:getStudent(Long, Advisor)
     */
    @Test
    void testGetStudent() {
        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();
        assertNull(advisorServiceImpl.getStudent(1L, new Advisor()));
    }
}

