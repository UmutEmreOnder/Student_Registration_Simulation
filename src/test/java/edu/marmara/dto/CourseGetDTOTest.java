package edu.marmara.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CourseGetDTOTest {
    /**
     * Methods under test:
     *
     *   Class:CourseGetDTO  Method:CourseGetDTO()
     *   Class:CourseGetDTO  Method:setCourseCode(String)
     *   Class:CourseGetDTO  Method:setCourseCredit(Integer)
     *   Class:CourseGetDTO  Method:setCourseTitle(String)
     *   Class:CourseGetDTO  Method:setGivenSemester(Integer)
     *   Class:CourseGetDTO  Method:setPrerequisites(List)
     *   Class:CourseGetDTO  Method:setWeeklyDate(List)
     *   Class:CourseGetDTO  Method:toString()
     *   Class:CourseGetDTO  Method:getCourseCode()
     *   Class:CourseGetDTO  Method:getCourseCredit()
     *   Class:CourseGetDTO  Method:getCourseTitle()
     *   Class:CourseGetDTO  Method:getGivenSemester()
     *   Class:CourseGetDTO  Method:getPrerequisites()
     *   Class:CourseGetDTO  Method:getWeeklyDate()
     */
    @Test
    void testConstructor() {
        CourseGetDTO actualCourseGetDTO = new CourseGetDTO();
        actualCourseGetDTO.setCourseCode("Course Code");
        actualCourseGetDTO.setCourseCredit(1);
        actualCourseGetDTO.setCourseTitle("Dr");
        actualCourseGetDTO.setGivenSemester(1);
        ArrayList<String> stringList = new ArrayList<>();
        actualCourseGetDTO.setPrerequisites(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualCourseGetDTO.setWeeklyDate(stringList1);
        String actualToStringResult = actualCourseGetDTO.toString();
        assertEquals("Course Code", actualCourseGetDTO.getCourseCode());
        assertEquals(1, actualCourseGetDTO.getCourseCredit().intValue());
        assertEquals("Dr", actualCourseGetDTO.getCourseTitle());
        assertEquals(1, actualCourseGetDTO.getGivenSemester().intValue());
        List<String> prerequisites = actualCourseGetDTO.getPrerequisites();
        assertSame(stringList, prerequisites);
        List<String> weeklyDate = actualCourseGetDTO.getWeeklyDate();
        assertEquals(weeklyDate, prerequisites);
        assertSame(stringList1, weeklyDate);
        assertEquals(stringList, weeklyDate);
        assertEquals(
                "CourseGetDTO{courseCode='Course Code', courseTitle='Dr', givenSemester=1, courseCredit=1, prerequisites=[],"
                        + " weeklyDate=[]}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *
     *   Class:CourseGetDTO Method:CourseGetDTO(String, String, Integer, Integer, List, List)
     *   Class:CourseGetDTO Method:setCourseCode(String)
     *   Class:CourseGetDTO Method:setCourseCredit(Integer)
     *   Class:CourseGetDTO Method:setCourseTitle(String)
     *   Class:CourseGetDTO Method:setGivenSemester(Integer)
     *   Class:CourseGetDTO Method:setPrerequisites(List)
     *   Class:CourseGetDTO Method:setWeeklyDate(List)
     *   Class:CourseGetDTO Method:toString()
     *   Class:CourseGetDTO Method:getCourseCode()
     *   Class:CourseGetDTO Method:getCourseCredit()
     *   Class:CourseGetDTO Method:getCourseTitle()
     *   Class:CourseGetDTO Method:getGivenSemester()
     *   Class:CourseGetDTO Method:getPrerequisites()
     *   Class:CourseGetDTO Method:getWeeklyDate()
     *
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> stringList1 = new ArrayList<>();
        CourseGetDTO actualCourseGetDTO = new CourseGetDTO("Course Code", "Dr", 1, 1, stringList, stringList1);
        actualCourseGetDTO.setCourseCode("Course Code");
        actualCourseGetDTO.setCourseCredit(1);
        actualCourseGetDTO.setCourseTitle("Dr");
        actualCourseGetDTO.setGivenSemester(1);
        ArrayList<String> stringList2 = new ArrayList<>();
        actualCourseGetDTO.setPrerequisites(stringList2);
        ArrayList<String> stringList3 = new ArrayList<>();
        actualCourseGetDTO.setWeeklyDate(stringList3);
        String actualToStringResult = actualCourseGetDTO.toString();
        assertEquals("Course Code", actualCourseGetDTO.getCourseCode());
        assertEquals(1, actualCourseGetDTO.getCourseCredit().intValue());
        assertEquals("Dr", actualCourseGetDTO.getCourseTitle());
        assertEquals(1, actualCourseGetDTO.getGivenSemester().intValue());
        List<String> prerequisites = actualCourseGetDTO.getPrerequisites();
        assertSame(stringList2, prerequisites);
        assertEquals(stringList, prerequisites);
        assertEquals(stringList1, prerequisites);
        List<String> weeklyDate = actualCourseGetDTO.getWeeklyDate();
        assertEquals(weeklyDate, prerequisites);
        assertSame(stringList3, weeklyDate);
        assertEquals(stringList, weeklyDate);
        assertEquals(stringList1, weeklyDate);
        assertEquals(stringList2, weeklyDate);
        assertEquals(
                "CourseGetDTO{courseCode='Course Code', courseTitle='Dr', givenSemester=1, courseCredit=1, prerequisites=[],"
                        + " weeklyDate=[]}",
                actualToStringResult);
    }
}

