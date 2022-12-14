package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class StudentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   Class:Student Method:Student()
     *   Class:Student Method:setAdvisor(Advisor)
     *   Class:Student Method:setSemester(Integer)
     *   Class:Student Method:setStudentId(Long)
     *   Class:Student Method:setTranscript(Transcript)
     *   Class:Student Method:setWeeklySchedule(Schedule)
     *   Class:Student Method:setYearEnrolled(Integer)
     *   Class:Student Method:toString()
     *   Class:Student Method:getAdvisor()
     *   Class:Student Method:getSemester()
     *   Class:Student Method:getStudentId()
     *   Class:Student Method:getTranscript()
     *   Class:Student Method:getWeeklySchedule()
     *   Class:Student Method:getYearEnrolled()
     */
    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        Advisor advisor = new Advisor();
        actualStudent.setAdvisor(advisor);
        actualStudent.setSemester(1);
        actualStudent.setStudentId(123L);
        Transcript transcript = new Transcript();
        actualStudent.setTranscript(transcript);
        Schedule schedule = new Schedule();
        actualStudent.setWeeklySchedule(schedule);
        actualStudent.setYearEnrolled(1);
        String actualToStringResult = actualStudent.toString();
        assertSame(advisor, actualStudent.getAdvisor());
        assertEquals(1, actualStudent.getSemester().intValue());
        assertEquals(123L, actualStudent.getStudentId().longValue());
        assertSame(transcript, actualStudent.getTranscript());
        assertSame(schedule, actualStudent.getWeeklySchedule());
        assertEquals(1, actualStudent.getYearEnrolled().intValue());
        assertEquals(
                "Student{studentId=123, yearEnrolled=1, weeklySchedule=Schedule{courses=null}, transcript=Transcript{gpa=null,"
                        + " passedCredit=null, failedCredit=null, passedCourses=null, failedCourses=null, notTakenCourses=null},"
                        + " advisor=Advisor{students=null}, semester=1}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Student Method:Student(Long, Integer, Schedule, Transcript, Advisor, Integer)
     *   Class:Student Method:setAdvisor(Advisor)
     *   Class:Student Method:setSemester(Integer)
     *   Class:Student Method:setStudentId(Long)
     *   Class:Student Method:setTranscript(Transcript)
     *   Class:Student Method:setWeeklySchedule(Schedule)
     *   Class:Student Method:setYearEnrolled(Integer)
     *   Class:Student Method:toString()
     *   Class:Student Method:getAdvisor()
     *   Class:Student Method:getSemester()
     *   Class:Student Method:getStudentId()
     *   Class:Student Method:getTranscript()
     *   Class:Student Method:getWeeklySchedule()
     *   Class:Student Method:getYearEnrolled()
     */
    @Test
    void testConstructor2() {
        Schedule weeklySchedule = new Schedule();
        Transcript transcript = new Transcript();
        Student actualStudent = new Student(123L, 1, weeklySchedule, transcript, new Advisor(), 1);
        Advisor advisor = new Advisor();
        actualStudent.setAdvisor(advisor);
        actualStudent.setSemester(1);
        actualStudent.setStudentId(123L);
        Transcript transcript1 = new Transcript();
        actualStudent.setTranscript(transcript1);
        Schedule schedule = new Schedule();
        actualStudent.setWeeklySchedule(schedule);
        actualStudent.setYearEnrolled(1);
        String actualToStringResult = actualStudent.toString();
        assertSame(advisor, actualStudent.getAdvisor());
        assertEquals(1, actualStudent.getSemester().intValue());
        assertEquals(123L, actualStudent.getStudentId().longValue());
        assertSame(transcript1, actualStudent.getTranscript());
        assertSame(schedule, actualStudent.getWeeklySchedule());
        assertEquals(1, actualStudent.getYearEnrolled().intValue());
        assertEquals(
                "Student{studentId=123, yearEnrolled=1, weeklySchedule=Schedule{courses=null}, transcript=Transcript{gpa=null,"
                        + " passedCredit=null, failedCredit=null, passedCourses=null, failedCourses=null, notTakenCourses=null},"
                        + " advisor=Advisor{students=null}, semester=1}",
                actualToStringResult);
    }
}

