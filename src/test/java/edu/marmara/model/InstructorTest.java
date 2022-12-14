package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class InstructorTest {
    /**
     * Methods under test:
     *
     *   Class:Instructor Method:Instructor()
     *   Class:Instructor Method:setPresentedCourses(List)
     *   Class:Instructor Method:setWeeklySchedule(Schedule)
     *   Class:Instructor Method:toString()
     *   Class:Instructor Method:getPresentedCourses()
     *   Class:Instructor Method:getWeeklySchedule()
     */
    @Test
    void testConstructor() {
        Instructor actualInstructor = new Instructor();
        ArrayList<Course> courseList = new ArrayList<>();
        actualInstructor.setPresentedCourses(courseList);
        Schedule schedule = new Schedule();
        actualInstructor.setWeeklySchedule(schedule);
        String actualToStringResult = actualInstructor.toString();
        assertSame(courseList, actualInstructor.getPresentedCourses());
        assertSame(schedule, actualInstructor.getWeeklySchedule());
        assertEquals("Instructor{presentedCourses=[], weeklySchedule=Schedule{courses=null}}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Instructor Method:Instructor(List, Schedule)
     *   Class:Instructor Method:setPresentedCourses(List)
     *   Class:Instructor Method:setWeeklySchedule(Schedule)
     *   Class:Instructor Method:toString()
     *   Class:Instructor Method:getPresentedCourses()
     *   Class:Instructor Method:getWeeklySchedule()
     */
    @Test
    void testConstructor2() {
        ArrayList<Course> courseList = new ArrayList<>();
        Instructor actualInstructor = new Instructor(courseList, new Schedule());
        ArrayList<Course> courseList1 = new ArrayList<>();
        actualInstructor.setPresentedCourses(courseList1);
        Schedule schedule = new Schedule();
        actualInstructor.setWeeklySchedule(schedule);
        String actualToStringResult = actualInstructor.toString();
        List<Course> presentedCourses = actualInstructor.getPresentedCourses();
        assertSame(courseList1, presentedCourses);
        assertEquals(courseList, presentedCourses);
        assertSame(schedule, actualInstructor.getWeeklySchedule());
        assertEquals("Instructor{presentedCourses=[], weeklySchedule=Schedule{courses=null}}", actualToStringResult);
    }
}

