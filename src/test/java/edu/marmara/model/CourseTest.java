package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CourseTest {
    /**
     * Methods under test:
     *
     *   Class:Course Method:Course()}
     *   Class:Course Method:setCourseCode(String)}
     *   Class:Course Method:setCourseCredit(Integer)}
     *   Class:Course Method:setCourseTitle(String)}
     *   Class:Course Method:setDates(List)}
     *   Class:Course Method:setEnrolledStudents(List)}
     *   Class:Course Method:setGivenSemester(Integer)}
     *   Class:Course Method:setInstructor(Instructor)}
     *   Class:Course Method:setPrerequisites(List)}
     *   Class:Course Method:toString()}
     *   Class:Course Method:getCourseCode()}
     *   Class:Course Method:getCourseCredit()}
     *   Class:Course Method:getCourseTitle()}
     *   Class:Course Method:getDates()}
     *   Class:Course Method:getPrerequisites()}
     *   Class:Course Method:getEnrolledStudents()}
     *   Class:Course Method:getGivenSemester()}
     *   Class:Course Method:getInstructor()}
     */
    @Test
    void testConstructor() {
        Course actualCourse = new Course();
        actualCourse.setCourseCode("Course Code");
        actualCourse.setCourseCredit(1);
        actualCourse.setCourseTitle("Dr");
        ArrayList<WeeklyDate> weeklyDateList = new ArrayList<>();
        actualCourse.setDates(weeklyDateList);
        ArrayList<Student> studentList = new ArrayList<>();
        actualCourse.setEnrolledStudents(studentList);
        actualCourse.setGivenSemester(1);
        Instructor instructor = new Instructor();
        actualCourse.setInstructor(instructor);
        ArrayList<Course> courseList = new ArrayList<>();
        actualCourse.setPrerequisites(courseList);
        String actualToStringResult = actualCourse.toString();
        assertEquals("Course Code", actualCourse.getCourseCode());
        assertEquals(1, actualCourse.getCourseCredit().intValue());
        assertEquals("Dr", actualCourse.getCourseTitle());
        List<WeeklyDate> dates = actualCourse.getDates();
        assertSame(weeklyDateList, dates);
        assertEquals(studentList, dates);
        List<Course> prerequisites = actualCourse.getPrerequisites();
        assertEquals(prerequisites, dates);
        List<Student> enrolledStudents = actualCourse.getEnrolledStudents();
        assertSame(studentList, enrolledStudents);
        assertEquals(dates, enrolledStudents);
        assertEquals(prerequisites, enrolledStudents);
        assertEquals(1, actualCourse.getGivenSemester().intValue());
        assertSame(instructor, actualCourse.getInstructor());
        assertSame(courseList, prerequisites);
        assertEquals(weeklyDateList, prerequisites);
        assertEquals(studentList, prerequisites);
        assertEquals(
                "Course{courseCode='Course Code', courseTitle='Dr', givenSemester=1, enrolledStudents=[], courseCredit=1,"
                        + " prerequisites=[], instructor=Instructor{presentedCourses=null, weeklySchedule=null}, dates=[]}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Course Method:Course(String, String, Integer, List, Integer, List, Instructor, List)}
     *   Class:Course Method:setCourseCode(String)}
     *   Class:Course Method:setCourseCredit(Integer)}
     *   Class:Course Method:setCourseTitle(String)}
     *   Class:Course Method:setDates(List)}
     *   Class:Course Method:setEnrolledStudents(List)}
     *   Class:Course Method:setGivenSemester(Integer)}
     *   Class:Course Method:setInstructor(Instructor)}
     *   Class:Course Method:setPrerequisites(List)}
     *   Class:Course Method:toString()}
     *   Class:Course Method:getCourseCode()}
     *   Class:Course Method:getCourseCredit()}
     *   Class:Course Method:getCourseTitle()}
     *   Class:Course Method:getDates()}
     *   Class:Course Method:getPrerequisites()}
     *   Class:Course Method:getEnrolledStudents()}
     *   Class:Course Method:getGivenSemester()}
     *   Class:Course Method:getInstructor()}
     */
    @Test
    void testConstructor2() {
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();
        Instructor instructor = new Instructor();
        ArrayList<WeeklyDate> weeklyDateList = new ArrayList<>();
        Course actualCourse = new Course("Course Code", "Dr", 1, studentList, 1, courseList, instructor, weeklyDateList, 60, 0);
        actualCourse.setCourseCode("Course Code");
        actualCourse.setCourseCredit(1);
        actualCourse.setCourseTitle("Dr");
        ArrayList<WeeklyDate> weeklyDateList1 = new ArrayList<>();
        actualCourse.setDates(weeklyDateList1);
        ArrayList<Student> studentList1 = new ArrayList<>();
        actualCourse.setEnrolledStudents(studentList1);
        actualCourse.setGivenSemester(1);
        Instructor instructor1 = new Instructor();
        actualCourse.setInstructor(instructor1);
        ArrayList<Course> courseList1 = new ArrayList<>();
        actualCourse.setPrerequisites(courseList1);
        String actualToStringResult = actualCourse.toString();
        assertEquals("Course Code", actualCourse.getCourseCode());
        assertEquals(1, actualCourse.getCourseCredit().intValue());
        assertEquals("Dr", actualCourse.getCourseTitle());
        List<WeeklyDate> dates = actualCourse.getDates();
        assertSame(weeklyDateList1, dates);
        assertEquals(studentList, dates);
        assertEquals(courseList, dates);
        assertEquals(weeklyDateList, dates);
        assertEquals(studentList1, dates);
        List<Course> prerequisites = actualCourse.getPrerequisites();
        assertEquals(prerequisites, dates);
        List<Student> enrolledStudents = actualCourse.getEnrolledStudents();
        assertSame(studentList1, enrolledStudents);
        assertEquals(studentList, enrolledStudents);
        assertEquals(courseList, enrolledStudents);
        assertEquals(weeklyDateList, enrolledStudents);
        assertEquals(dates, enrolledStudents);
        assertEquals(prerequisites, enrolledStudents);
        assertEquals(1, actualCourse.getGivenSemester().intValue());
        assertSame(instructor1, actualCourse.getInstructor());
        assertSame(courseList1, prerequisites);
        assertEquals(studentList, prerequisites);
        assertEquals(courseList, prerequisites);
        assertEquals(weeklyDateList, prerequisites);
        assertEquals(weeklyDateList1, prerequisites);
        assertEquals(studentList1, prerequisites);
        assertEquals(
                "Course{courseCode='Course Code', courseTitle='Dr', givenSemester=1, enrolledStudents=[], courseCredit=1,"
                        + " prerequisites=[], instructor=Instructor{presentedCourses=null, weeklySchedule=null}, dates=[]}",
                actualToStringResult);
    }
}

