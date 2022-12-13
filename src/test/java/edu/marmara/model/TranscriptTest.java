package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TranscriptTest {
    /**
     * Methods under test:
     *
     *   Class:Transcript Method:Transcript()
     *   Class:Transcript Method:setFailedCourses(List)
     *   Class:Transcript Method:setFailedCredit(Integer)
     *   Class:Transcript Method:setGpa(Double)
     *   Class:Transcript Method:setNotTakenCourses(List)
     *   Class:Transcript Method:setPassedCourses(List)
     *   Class:Transcript Method:setPassedCredit(Integer)
     *   Class:Transcript Method:toString()
     *   Class:Transcript Method:getFailedCourses()
     *   Class:Transcript Method:getFailedCredit()
     *   Class:Transcript Method:getGpa()
     *   Class:Transcript Method:getNotTakenCourses()
     *   Class:Transcript Method:getPassedCourses()
     *   Class:Transcript Method:getPassedCredit()
     */
    @Test
    void testConstructor() {
        Transcript actualTranscript = new Transcript();
        ArrayList<Course> courseList = new ArrayList<>();
        actualTranscript.setFailedCourses(courseList);
        actualTranscript.setFailedCredit(1);
        actualTranscript.setGpa(10.0d);
        ArrayList<Course> courseList1 = new ArrayList<>();
        actualTranscript.setNotTakenCourses(courseList1);
        ArrayList<Course> courseList2 = new ArrayList<>();
        actualTranscript.setPassedCourses(courseList2);
        actualTranscript.setPassedCredit(1);
        String actualToStringResult = actualTranscript.toString();
        List<Course> failedCourses = actualTranscript.getFailedCourses();
        assertSame(courseList, failedCourses);
        assertEquals(courseList1, failedCourses);
        assertEquals(courseList2, failedCourses);
        assertEquals(1, actualTranscript.getFailedCredit().intValue());
        assertEquals(10.0d, actualTranscript.getGpa().doubleValue());
        List<Course> notTakenCourses = actualTranscript.getNotTakenCourses();
        assertSame(courseList1, notTakenCourses);
        assertEquals(failedCourses, notTakenCourses);
        List<Course> passedCourses = actualTranscript.getPassedCourses();
        assertEquals(passedCourses, notTakenCourses);
        assertSame(courseList2, passedCourses);
        assertEquals(courseList1, passedCourses);
        assertEquals(failedCourses, passedCourses);
        assertEquals(1, actualTranscript.getPassedCredit().intValue());
        assertEquals(
                "Transcript{gpa=10.0, passedCredit=1, failedCredit=1, passedCourses=[], failedCourses=[], notTakenCourses"
                        + "=[]}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Transcript Method:Transcript(Double, Integer, Integer, List, List, List)
     *   Class:Transcript Method:setFailedCourses(List)
     *   Class:Transcript Method:setFailedCredit(Integer)
     *   Class:Transcript Method:setGpa(Double)
     *   Class:Transcript Method:setNotTakenCourses(List)
     *   Class:Transcript Method:setPassedCourses(List)
     *   Class:Transcript Method:setPassedCredit(Integer)
     *   Class:Transcript Method:toString()
     *   Class:Transcript Method:getFailedCourses()
     *   Class:Transcript Method:getFailedCredit()
     *   Class:Transcript Method:getGpa()
     *   Class:Transcript Method:getNotTakenCourses()
     *   Class:Transcript Method:getPassedCourses()
     *   Class:Transcript Method:getPassedCredit()
     */
    @Test
    void testConstructor2() {
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Course> courseList1 = new ArrayList<>();
        ArrayList<Course> courseList2 = new ArrayList<>();
        Transcript actualTranscript = new Transcript(10.0d, 1, 1, courseList, courseList1, courseList2);
        ArrayList<Course> courseList3 = new ArrayList<>();
        actualTranscript.setFailedCourses(courseList3);
        actualTranscript.setFailedCredit(1);
        actualTranscript.setGpa(10.0d);
        ArrayList<Course> courseList4 = new ArrayList<>();
        actualTranscript.setNotTakenCourses(courseList4);
        ArrayList<Course> courseList5 = new ArrayList<>();
        actualTranscript.setPassedCourses(courseList5);
        actualTranscript.setPassedCredit(1);
        String actualToStringResult = actualTranscript.toString();
        List<Course> failedCourses = actualTranscript.getFailedCourses();
        assertSame(courseList3, failedCourses);
        assertEquals(courseList, failedCourses);
        assertEquals(courseList1, failedCourses);
        assertEquals(courseList2, failedCourses);
        assertEquals(courseList4, failedCourses);
        assertEquals(courseList5, failedCourses);
        assertEquals(1, actualTranscript.getFailedCredit().intValue());
        assertEquals(10.0d, actualTranscript.getGpa().doubleValue());
        List<Course> notTakenCourses = actualTranscript.getNotTakenCourses();
        assertSame(courseList4, notTakenCourses);
        assertEquals(courseList, notTakenCourses);
        assertEquals(courseList1, notTakenCourses);
        assertEquals(courseList2, notTakenCourses);
        assertEquals(failedCourses, notTakenCourses);
        List<Course> passedCourses = actualTranscript.getPassedCourses();
        assertEquals(passedCourses, notTakenCourses);
        assertSame(courseList5, passedCourses);
        assertEquals(courseList, passedCourses);
        assertEquals(courseList1, passedCourses);
        assertEquals(courseList2, passedCourses);
        assertEquals(courseList4, passedCourses);
        assertEquals(failedCourses, passedCourses);
        assertEquals(1, actualTranscript.getPassedCredit().intValue());
        assertEquals(
                "Transcript{gpa=10.0, passedCredit=1, failedCredit=1, passedCourses=[], failedCourses=[], notTakenCourses"
                        + "=[]}",
                actualToStringResult);
    }
}

