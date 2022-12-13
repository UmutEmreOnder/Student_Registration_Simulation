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
    void testMapTo1() {
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
}

