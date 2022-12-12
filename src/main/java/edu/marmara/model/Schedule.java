package edu.marmara.model;

import java.util.List;


public class Schedule {
    private List<Course> courses;

    public Schedule() {
    }

    public Schedule(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "courses=" + courses +
                '}';
    }
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

