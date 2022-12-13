package edu.marmara.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ScheduleGetDTOTest {
    /**
     * Methods under test:
     *
     *   Class:ScheduleGetDTO Method:ScheduleGetDTO()
     *   Class:ScheduleGetDTO Method:setCourses(List)
     *   Class:ScheduleGetDTO Method:toString()
     *   Class:ScheduleGetDTO Method:getCourses()
     */
    @Test
    void testConstructor() {
        ScheduleGetDTO actualScheduleGetDTO = new ScheduleGetDTO();
        ArrayList<String> stringList = new ArrayList<>();
        actualScheduleGetDTO.setCourses(stringList);
        String actualToStringResult = actualScheduleGetDTO.toString();
        assertSame(stringList, actualScheduleGetDTO.getCourses());
        assertEquals("ScheduleGetDTO{courses=[]}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:ScheduleGetDTO Method:ScheduleGetDTO(List)
     *   Class:ScheduleGetDTO Method:setCourses(List)
     *   Class:ScheduleGetDTO Method:toString()
     *   Class:ScheduleGetDTO Method:getCourses()
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        ScheduleGetDTO actualScheduleGetDTO = new ScheduleGetDTO(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualScheduleGetDTO.setCourses(stringList1);
        String actualToStringResult = actualScheduleGetDTO.toString();
        List<String> courses = actualScheduleGetDTO.getCourses();
        assertSame(stringList1, courses);
        assertEquals(stringList, courses);
        assertEquals("ScheduleGetDTO{courses=[]}", actualToStringResult);
    }
}

