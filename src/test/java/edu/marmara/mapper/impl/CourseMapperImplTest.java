package edu.marmara.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import edu.marmara.dto.CourseGetDTO;
import edu.marmara.model.Course;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CourseMapperImplTest {

    /**
     * Method under test:
     *
     * Course:CourseMapperImpl Method:mapTo(CourseGetDTO)}
     */
    @Test
    void testMapTo2() {
        CourseMapperImpl courseMapperImpl = new CourseMapperImpl();

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        ArrayList<String> stringList = new ArrayList<>();
        courseGetDTO.setWeeklyDate(stringList);
        Course actualMapToResult = courseMapperImpl.mapTo(courseGetDTO);
        assertNull(actualMapToResult.getCourseCode());
        assertNull(actualMapToResult.getGivenSemester());
        assertEquals(stringList, actualMapToResult.getDates());
        assertNull(actualMapToResult.getCourseTitle());
        assertNull(actualMapToResult.getCourseCredit());
    }

    /**
     * Method under test:
     * Class:CourseMapperImpl Course:mapTo(CourseGetDTO)}
     */
    @Test
    @Disabled
    void testMapTo3() {
        // TODO: Complete this test.

        (new CourseMapperImpl()).mapTo(null);
    }

    /**
     * Method under test:
     *
     * Class:CourseMapperImpl Method:mapTo(CourseGetDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapTo4() {
        // TODO: Complete this test.

        CourseMapperImpl courseMapperImpl = new CourseMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        courseGetDTO.setWeeklyDate(stringList);
        courseMapperImpl.mapTo(courseGetDTO);
    }

    /**
     * Method under test: {@link CourseMapperImpl#mapTo(CourseGetDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapTo5() {
        // TODO: Complete this test.

        CourseMapperImpl courseMapperImpl = new CourseMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(" ");
        stringList.add("foo");

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        courseGetDTO.setWeeklyDate(stringList);
        courseMapperImpl.mapTo(courseGetDTO);
    }

    /**
     * Method under test:
     *
     * Class:CourseMapperImpl Method:mapTo(CourseGetDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapTo6() {
        // TODO: Complete this test.


        CourseMapperImpl courseMapperImpl = new CourseMapperImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        courseGetDTO.setWeeklyDate(stringList);
        courseMapperImpl.mapTo(courseGetDTO);
    }

    /**
     * Method under test:
     *
     * Class:CourseMapperImpl Method:mapTo(CourseGetDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapTo() {
        // TODO: Complete this test.

        CourseMapperImpl courseMapperImpl = new CourseMapperImpl();
        courseMapperImpl.mapTo(new CourseGetDTO());
    }
}

