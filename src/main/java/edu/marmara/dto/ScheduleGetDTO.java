package edu.marmara.dto;

import java.util.List;

public class ScheduleGetDTO {
    private List<String> courses;
    private Boolean approved;
    private Boolean sendToReview;

    public ScheduleGetDTO(List<String> courses, Boolean approved, Boolean sendToReview) {
        this.courses = courses;
        this.approved = approved;
        this.sendToReview = sendToReview;
    }

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

    public ScheduleGetDTO() {
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "ScheduleGetDTO{" +
                "courses=" + courses +
                '}';
    }
}