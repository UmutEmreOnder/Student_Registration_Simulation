package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

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

