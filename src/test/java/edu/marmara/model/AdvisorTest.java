package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AdvisorTest {
    /**
     * Methods under test:
     *
     *   Class:Advisor Method:Advisor()
     *   Class:Advisor Method:setStudents(List)
     *   Class:Advisor Method:toString()
     *   Class:Advisor Method:getStudents()
     */
    @Test
    void testConstructor() {
        Advisor actualAdvisor = new Advisor();
        ArrayList<Student> studentList = new ArrayList<>();
        actualAdvisor.setStudents(studentList);
        String actualToStringResult = actualAdvisor.toString();
        assertSame(studentList, actualAdvisor.getStudents());
        assertEquals("Advisor{students=[]}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:Advisor Method:Advisor(List)
     *   Class:Advisor Method:setStudents(List)
     *   Class:Advisor Method:toString()
     *   Class:Advisor Method:getStudents()
     */
    @Test
    void testConstructor2() {
        ArrayList<Student> studentList = new ArrayList<>();
        Advisor actualAdvisor = new Advisor(studentList);
        ArrayList<Student> studentList1 = new ArrayList<>();
        actualAdvisor.setStudents(studentList1);
        String actualToStringResult = actualAdvisor.toString();
        List<Student> students = actualAdvisor.getStudents();
        assertSame(studentList1, students);
        assertEquals(studentList, students);
        assertEquals("Advisor{students=[]}", actualToStringResult);
    }
}

