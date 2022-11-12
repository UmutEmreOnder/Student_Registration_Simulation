package edu.marmara.service.impl;

import edu.marmara.dto.CourseGetDTO;
import edu.marmara.model.Course;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;
import edu.marmara.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public void addPrerequisites(List<CourseGetDTO> courseGetDTOS) {
        for (CourseGetDTO courseGetDTO : courseGetDTOS) {

            if (!courseGetDTO.getPrerequisites().isEmpty()) {

                Course mainCourse = courseRepository.findByCourseCode(courseGetDTO.getCourseCode());

                for (String courseCode : courseGetDTO.getPrerequisites()) {
                    Course prerequisiteCourse = courseRepository.findByCourseCode(courseCode);

                    if (prerequisiteCourse != null) {
                        if (mainCourse.getPrerequisites() == null) {
                            mainCourse.setPrerequisites(new ArrayList<>());
                        }

                        mainCourse.getPrerequisites().add(prerequisiteCourse);
                    }
                }
            }
        }
    }
}
