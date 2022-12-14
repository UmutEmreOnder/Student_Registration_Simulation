package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ScheduleTest {
    /**
     * Methods under test:
     *
     *   Class:Schedule Method:Schedule()
     *   Class:Schedule Method:setCourses(List)
     *   Class:Schedule Method:toString()
     *   Class:Schedule Method:getCourses()
     */
    @Test
    void testConstructor() {
        Schedule actualSchedule = new Schedule();
        ArrayList<Course> courseList = new ArrayList<>();
        actualSchedule.setCourses(courseList);
        String actualToStringResult = actualSchedule.toString();
        assertSame(courseList, actualSchedule.getCourses());
        assertEquals("Schedule{courses=[]}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Schedule Method:Schedule(List)
     *   Class:Schedule Method:setCourses(List)
     *   Class:Schedule Method:toString()
     *   Class:Schedule Method:getCourses()
     */
    @Test
    void testConstructor2() {
        ArrayList<Course> courseList = new ArrayList<>();
        Schedule actualSchedule = new Schedule(courseList, false, false);
        ArrayList<Course> courseList1 = new ArrayList<>();
        actualSchedule.setCourses(courseList1);
        String actualToStringResult = actualSchedule.toString();
        List<Course> courses = actualSchedule.getCourses();
        assertSame(courseList1, courses);
        assertEquals(courseList, courses);
        assertEquals("Schedule{courses=[]}", actualToStringResult);
    }
}

