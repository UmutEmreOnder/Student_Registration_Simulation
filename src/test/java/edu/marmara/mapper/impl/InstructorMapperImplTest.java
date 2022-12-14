package edu.marmara.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.marmara.dto.InstructorGetDTO;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InstructorMapperImplTest {

    /**
     * Method under test:
     *
     * Class:InstructorMapperImpl Method:mapTo(InstructorGetDTO)
     */
    @Test
    void testMapTo2() {
        InstructorMapperImpl instructorMapperImpl = new InstructorMapperImpl();

        InstructorGetDTO instructorGetDTO = new InstructorGetDTO();
        ArrayList<String> stringList = new ArrayList<>();
        instructorGetDTO.setPresentedCourses(stringList);
        Instructor actualMapToResult = instructorMapperImpl.mapTo(instructorGetDTO);
        assertNull(actualMapToResult.getBirthDate());
        assertNull(actualMapToResult.getUuid());
        assertNull(actualMapToResult.getEmail());
        assertNull(actualMapToResult.getSurname());
        assertEquals(stringList, actualMapToResult.getPresentedCourses());
        assertNull(actualMapToResult.getName());
        assertEquals(stringList, actualMapToResult.getWeeklySchedule().getCourses());
    }

    /**
     * Method under test:
     *
     * Class:InstructorMapperImpl Method:mapTo(InstructorGetDTO)
     */
    @Test
    void testMapTo3() {
        InstructorMapperImpl instructorMapperImpl = new InstructorMapperImpl();
        UUID randomUUIDResult = UUID.randomUUID();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        ArrayList<String> stringList = new ArrayList<>();
        Instructor actualMapToResult = instructorMapperImpl.mapTo(
                new InstructorGetDTO(randomUUIDResult, "Name", "Doe", "jane.doe@example.org", fromResult, stringList, true));
        assertSame(fromResult, actualMapToResult.getBirthDate());
        assertSame(randomUUIDResult, actualMapToResult.getUuid());
        assertEquals("jane.doe@example.org", actualMapToResult.getEmail());
        assertEquals(stringList, actualMapToResult.getPresentedCourses());
        assertEquals(stringList, ((Advisor) actualMapToResult).getStudents());
        assertEquals("Name", actualMapToResult.getName());
        assertEquals("Doe", actualMapToResult.getSurname());
        assertEquals(stringList, actualMapToResult.getWeeklySchedule().getCourses());
    }

    /**
     * Method under test:
     *
     * Class:InstructorMapperImpl Method:mapTo(InstructorGetDTO)
     */
    @Test
    void testMapTo6() {
        InstructorMapperImpl instructorMapperImpl = new InstructorMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        InstructorGetDTO instructorGetDTO = new InstructorGetDTO();
        instructorGetDTO.setPresentedCourses(stringList);
        Instructor actualMapToResult = instructorMapperImpl.mapTo(instructorGetDTO);
        assertNull(actualMapToResult.getBirthDate());
        assertNull(actualMapToResult.getUuid());
        assertNull(actualMapToResult.getEmail());
        assertNull(actualMapToResult.getSurname());
        List<Course> presentedCourses = actualMapToResult.getPresentedCourses();
        assertTrue(presentedCourses.isEmpty());
        assertNull(actualMapToResult.getName());
        assertEquals(presentedCourses, actualMapToResult.getWeeklySchedule().getCourses());
    }

    /**
     * Method under test:
     * Class:InstructorMapperImpl Method:mapTo(InstructorGetDTO)
     */
    @Test
    void testMapTo7() {
        InstructorMapperImpl instructorMapperImpl = new InstructorMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        UUID randomUUIDResult = UUID.randomUUID();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Instructor actualMapToResult = instructorMapperImpl.mapTo(
                new InstructorGetDTO(randomUUIDResult, "Name", "Doe", "jane.doe@example.org", fromResult, stringList, true));
        assertSame(fromResult, actualMapToResult.getBirthDate());
        assertSame(randomUUIDResult, actualMapToResult.getUuid());
        assertEquals("jane.doe@example.org", actualMapToResult.getEmail());
        List<Course> presentedCourses = actualMapToResult.getPresentedCourses();
        assertTrue(presentedCourses.isEmpty());
        assertEquals(presentedCourses, ((Advisor) actualMapToResult).getStudents());
        assertEquals("Name", actualMapToResult.getName());
        assertEquals("Doe", actualMapToResult.getSurname());
        assertEquals(presentedCourses, actualMapToResult.getWeeklySchedule().getCourses());
    }
}

