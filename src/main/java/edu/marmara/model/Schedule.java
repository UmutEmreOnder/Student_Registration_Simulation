package edu.marmara.model;

import java.util.List;


public class Schedule {
    private List<Course> courses;
    private Boolean approved;
    private Boolean sendToReview;

    public Schedule() {
    }

    public Schedule(List<Course> courses, Boolean approved, Boolean sendToReview) {
        this.courses = courses;
        this.approved = approved;
        this.sendToReview = sendToReview;
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

    public void removeCourse(Course course) {this.courses.remove(course);}

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getSendToReview() {
        return sendToReview;
    }

    public void setSendToReview(Boolean sendToReview) {
        this.sendToReview = sendToReview;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

