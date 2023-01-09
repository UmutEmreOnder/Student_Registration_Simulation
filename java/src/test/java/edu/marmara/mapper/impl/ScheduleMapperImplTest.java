package edu.marmara.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.dto.ScheduleGetDTO;
import edu.marmara.model.Course;
import edu.marmara.model.Schedule;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ScheduleMapperImplTest {

    /**
     * Method under test:
     *
     * Class:ScheduleMapperImpl Method:mapTo(ScheduleGetDTO)
     */
    @Test
    void testMapTo2() {
        ScheduleMapperImpl scheduleMapperImpl = new ScheduleMapperImpl();

        ScheduleGetDTO scheduleGetDTO = new ScheduleGetDTO();
        ArrayList<String> stringList = new ArrayList<>();
        scheduleGetDTO.setCourses(stringList);
        assertEquals(stringList, scheduleMapperImpl.mapTo(scheduleGetDTO).getCourses());
    }


    /**
     * Method under test:
     *
     * Class:ScheduleMapperImpl Method:mapTo(ScheduleGetDTO)
     */
    @Test
    void testMapTo4() {
        ScheduleMapperImpl scheduleMapperImpl = new ScheduleMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        ScheduleGetDTO scheduleGetDTO = new ScheduleGetDTO();
        scheduleGetDTO.setCourses(stringList);
        assertEquals(1, scheduleMapperImpl.mapTo(scheduleGetDTO).getCourses().size());
    }

    /**
     * Method under test:
     *
     * Class:ScheduleMapperImpl Method:mapTo(Schedule)
     */
    @Test
    void testMapTo5() {
        ScheduleMapperImpl scheduleMapperImpl = new ScheduleMapperImpl();
        assertNull(scheduleMapperImpl.mapTo(new Schedule()));
    }

    /**
     * Method under test:
     *
     * Class:ScheduleMapperImpl Method:mapTo(Schedule)
     */
    @Test
    void testMapTo6() {
        assertNull((new ScheduleMapperImpl()).mapTo((Schedule) null));
    }

    /**
     * Method under test:
     * Class:ScheduleMapperImpl Method:mapTo(Schedule)
     */
    @Test
    void testMapTo7() {
        ScheduleMapperImpl scheduleMapperImpl = new ScheduleMapperImpl();
        ArrayList<Course> courseList = new ArrayList<>();
        assertEquals(courseList, scheduleMapperImpl.mapTo(new Schedule(courseList, false, false)).getCourses());
    }

    /**
     * Method under test:
     *
     * Class:ScheduleMapperImpl Method:mapTo(Schedule)
     */
    @Test
    void testMapTo8() {
        ScheduleMapperImpl scheduleMapperImpl = new ScheduleMapperImpl();

        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        List<String> courses = scheduleMapperImpl.mapTo(new Schedule(courseList, false, false)).getCourses();
        assertEquals(1, courses.size());
        assertNull(courses.get(0));
    }
}

