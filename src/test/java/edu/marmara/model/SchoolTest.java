package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import edu.marmara.config.Config;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SchoolTest {
    /**
     * Methods under test:
     *
     *   Class:School Method:getInstance()
     *   Class:School Method:setConfig(Config)
     *   Class:School Method:setCourses(List)
     *   Class:School Method:setInstructors(List)
     *   Class:School Method:setStudents(List)
     *   Class:School Method:getConfig()
     *   Class:School Method:getCourses()
     *   Class:School Method:getStudents()
     *   Class:School Method:getInstructors()
     */
    @Test
    void testGetInstance() {
        School actualInstance = School.getInstance();
        Config config = new Config();
        actualInstance.setConfig(config);
        ArrayList<Course> courseList = new ArrayList<>();
        actualInstance.setCourses(courseList);
        ArrayList<Instructor> instructorList = new ArrayList<>();
        actualInstance.setInstructors(instructorList);
        ArrayList<Student> studentList = new ArrayList<>();
        actualInstance.setStudents(studentList);
        assertSame(config, actualInstance.getConfig());
        List<Course> courses = actualInstance.getCourses();
        assertSame(courseList, courses);
        assertEquals(instructorList, courses);
        List<Student> students = actualInstance.getStudents();
        assertEquals(students, courses);
        List<Instructor> instructors = actualInstance.getInstructors();
        assertSame(instructorList, instructors);
        assertEquals(courses, instructors);
        assertEquals(students, instructors);
        assertSame(studentList, students);
        assertEquals(courseList, students);
        assertEquals(instructorList, students);
    }

}

