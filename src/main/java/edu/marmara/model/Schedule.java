package edu.marmara.model;

import lombok.Data;

import java.util.List;


public class Schedule {
    private List<Course> courses;

    @java.lang.Override
    public java.lang.String toString() {
        return "Schedule{" +
                "courses=" + courses +
                '}';
    }

    public Schedule() {
    }

    public Schedule(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

