package edu.marmara.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@ToString(callSuper = true)
public class Instructor extends Person {
    private List<Course> presentedCourses;
    private Schedule weeklySchedule;

    @java.lang.Override
    public java.lang.String toString() {
        return "Instructor{" +
                "presentedCourses=" + presentedCourses +
                ", weeklySchedule=" + weeklySchedule +
                '}';
    }

    public Instructor() {
    }

    public Instructor(List<Course> presentedCourses, Schedule weeklySchedule) {
        this.presentedCourses = presentedCourses;
        this.weeklySchedule = weeklySchedule;
    }

    public List<Course> getPresentedCourses() {
        return presentedCourses;
    }

    public void setPresentedCourses(List<Course> presentedCourses) {
        this.presentedCourses = presentedCourses;
    }

    public Schedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(Schedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }
}
