package edu.marmara.dto;

import java.util.List;

public class ScheduleGetDTO {
    private List<String> courses;

    public ScheduleGetDTO(List<String> courses) {
        this.courses = courses;
    }

    public ScheduleGetDTO() {
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "ScheduleGetDTO{" +
                "courses=" + courses +
                '}';
    }
}