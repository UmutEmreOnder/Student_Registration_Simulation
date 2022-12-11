package edu.marmara.mapper.impl;

import edu.marmara.dto.CourseGetDTO;
import edu.marmara.mapper.CourseMapper;
import edu.marmara.model.Course;
import edu.marmara.model.DayName;
import edu.marmara.model.WeeklyDate;

import java.util.ArrayList;

public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course mapTo(CourseGetDTO courseGetDTO) {
        Course course = new Course();

        course.setCourseCode(courseGetDTO.getCourseCode());
        course.setCourseTitle(courseGetDTO.getCourseTitle());
        course.setGivenSemester(courseGetDTO.getGivenSemester());
        course.setCourseCredit(courseGetDTO.getCourseCredit());

        course.setDates(new ArrayList<>());

        for (String date : courseGetDTO.getWeeklyDate()) {
            String[] dayAndHour = date.split(" ");

            DayName dayName = DayName.valueOf(dayAndHour[0]);
            WeeklyDate weeklyDate = new WeeklyDate();
            weeklyDate.setDayName(dayName);
            weeklyDate.setHours(Integer.valueOf(dayAndHour[1]));

            course.getDates().add(weeklyDate);
        }

        course.setMaxSeats(courseGetDTO.getAvailableSeats());
        course.setTakenSeats(0);

        return course;
    }
}