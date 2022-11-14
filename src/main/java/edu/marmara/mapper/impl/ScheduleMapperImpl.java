package edu.marmara.mapper.impl;

import edu.marmara.dto.ScheduleGetDTO;
import edu.marmara.mapper.ScheduleMapper;
import edu.marmara.model.Course;
import edu.marmara.model.Schedule;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;

public class ScheduleMapperImpl implements ScheduleMapper {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public Schedule mapTo(ScheduleGetDTO scheduleGetDTO) {
        Schedule schedule = new Schedule();
        schedule.setCourses(new ArrayList<>());

        for (String courseCode : scheduleGetDTO.getCourses()) {
            schedule.getCourses().add(courseRepository.findByCourseCode(courseCode));
        }

        return schedule;
    }

    @Override
    public ScheduleGetDTO mapTo(Schedule schedule) {
        ScheduleGetDTO scheduleGetDTO = new ScheduleGetDTO();
        scheduleGetDTO.setCourses(new ArrayList<>());

        if (schedule == null || schedule.getCourses() == null) {
            return null;
        }

        for (Course course : schedule.getCourses()) {
            scheduleGetDTO.getCourses().add(course.getCourseCode());
        }

        return scheduleGetDTO;
    }
}