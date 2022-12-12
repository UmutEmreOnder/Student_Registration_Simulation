package edu.marmara.model;

import java.util.List;


public class Instructor extends Person {
    private List<Course> presentedCourses;
    private Schedule weeklySchedule;

    public Instructor() {
    }

    public Instructor(List<Course> presentedCourses, Schedule weeklySchedule) {
        this.presentedCourses = presentedCourses;
        this.weeklySchedule = weeklySchedule;
    }
    public void addPresentedCourse(Course course){
        this.presentedCourses.add(course);

    }
    public void addCourseToSchedule(Course course) {
        this.weeklySchedule.addCourse(course);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "presentedCourses=" + presentedCourses +
                ", weeklySchedule=" + weeklySchedule +
                '}';
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
