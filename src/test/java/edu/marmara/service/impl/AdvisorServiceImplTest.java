package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class AdvisorServiceImplTest {
    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:getStudent(Long, Advisor)
     */
    @Test
    void testGetStudent() {
        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();
        assertNull(advisorServiceImpl.getStudent(1L, new Advisor()));
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    void testApproveSchedule() throws IOException {
        // TODO: Complete this test.

        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();
        advisorServiceImpl.approveSchedule(new Student());
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveSchedule2() throws IOException {
        // TODO: Complete this test.

        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();

        Student student = new Student();
        student.setWeeklySchedule(new Schedule());
        advisorServiceImpl.approveSchedule(student);
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveSchedule3() throws IOException {
        // TODO: Complete this test.

        (new AdvisorServiceImpl()).approveSchedule(null);
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveSchedule4() throws IOException {
        // TODO: Complete this test.


        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();

        Student student = new Student();
        student.setWeeklySchedule(new Schedule(new ArrayList<>()));
        advisorServiceImpl.approveSchedule(student);
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveSchedule5() throws IOException {
        // TODO: Complete this test.


        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();

        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        Schedule weeklySchedule = new Schedule(courseList);

        Student student = new Student();
        student.setWeeklySchedule(weeklySchedule);
        advisorServiceImpl.approveSchedule(student);
    }

    /**
     * Method under test:
     *
     * Class:AdvisorServiceImpl Method:approveSchedule(Student)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveSchedule6() throws IOException {
        // TODO: Complete this test.

        AdvisorServiceImpl advisorServiceImpl = new AdvisorServiceImpl();

        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(null);
        Schedule weeklySchedule = new Schedule(courseList);

        Student student = new Student();
        student.setWeeklySchedule(weeklySchedule);
        advisorServiceImpl.approveSchedule(student);
    }
}

