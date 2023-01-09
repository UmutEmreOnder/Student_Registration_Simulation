package edu.marmara.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.marmara.dto.StudentGetDTO;
import edu.marmara.model.Course;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;

import java.util.List;

import org.junit.jupiter.api.Test;

class StudentMapperImplTest {
    /**
     * Method under test:
     *
     * Class:StudentMapperImpl Method:mapTo(StudentGetDTO)
     */
    @Test
    void testMapTo() {
        StudentMapperImpl studentMapperImpl = new StudentMapperImpl();
        Student actualMapToResult = studentMapperImpl.mapTo(new StudentGetDTO());
        assertNull(actualMapToResult.getYearEnrolled());
        assertNull(actualMapToResult.getUuid());
        assertNull(actualMapToResult.getSurname());
        assertNull(actualMapToResult.getBirthDate());
        assertNull(actualMapToResult.getName());
        assertNull(actualMapToResult.getSemester());
        assertNull(actualMapToResult.getEmail());
        assertNull(actualMapToResult.getStudentId());
        Transcript transcript = actualMapToResult.getTranscript();
        List<Course> failedCourses = transcript.getFailedCourses();
        assertTrue(failedCourses.isEmpty());
        assertEquals(0, transcript.getPassedCredit().intValue());
        assertEquals(0, transcript.getFailedCredit().intValue());
        assertEquals(failedCourses, transcript.getNotTakenCourses());
    }
}

