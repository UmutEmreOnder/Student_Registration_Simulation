package edu.marmara.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.marmara.dto.CourseGetDTO;
import edu.marmara.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class CourseServiceImplTest {
    /**
     * Method under test:
     *
     * Class:CourseServiceImpl Method:addPrerequisites(List)
     */
    @Test
    void testAddPrerequisites() {
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
        courseServiceImpl.addPrerequisites(new ArrayList<>());
        assertTrue(courseServiceImpl.courseRepository instanceof CourseRepositoryImpl);
    }



    /**
     * Method under test:
     *
     * Class:CourseServiceImpl Method:addPrerequisites(List)
     */
    @Test
    void testAddPrerequisites3() {
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        courseGetDTO.setPrerequisites(new ArrayList<>());

        ArrayList<CourseGetDTO> courseGetDTOList = new ArrayList<>();
        courseGetDTOList.add(courseGetDTO);
        courseServiceImpl.addPrerequisites(courseGetDTOList);
        assertTrue(courseServiceImpl.courseRepository instanceof CourseRepositoryImpl);
    }

    /**
     * Method under test:
     *
     * Class:CourseServiceImpl Method:addPrerequisites(List)
     */
    @Test
    void testAddPrerequisites5() {
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        CourseGetDTO courseGetDTO = new CourseGetDTO();
        courseGetDTO.setPrerequisites(stringList);

        ArrayList<CourseGetDTO> courseGetDTOList = new ArrayList<>();
        courseGetDTOList.add(courseGetDTO);
        courseServiceImpl.addPrerequisites(courseGetDTOList);
        assertTrue(courseServiceImpl.courseRepository instanceof CourseRepositoryImpl);
    }

    /**
     * Method under test:
     *
     * Class:CourseServiceImpl Method:addPrerequisites(List)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddPrerequisites4() {
        // TODO: Complete this test.


        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

        ArrayList<CourseGetDTO> courseGetDTOList = new ArrayList<>();
        courseGetDTOList.add(null);
        courseServiceImpl.addPrerequisites(courseGetDTOList);
    }

    /**
     * Method under test:
     *
     * Class:CourseServiceImpl Method:addPrerequisites(List)
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddPrerequisites2() {
        // TODO: Complete this test.


        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

        ArrayList<CourseGetDTO> courseGetDTOList = new ArrayList<>();
        courseGetDTOList.add(new CourseGetDTO());
        courseServiceImpl.addPrerequisites(courseGetDTOList);
    }


}

