package edu.marmara.dto;

import java.util.List;

public class TranscriptGetDTO {
    private Double gpa;
    private Integer passedCredit;
    private Integer failedCredit;
    private List<String> passedCourses;
    private List<String> failedCourses;
    private List<String> notTakenCourses;
    private List<String> currentlyTakenCourses;

    public TranscriptGetDTO() {
    }

    public TranscriptGetDTO(Double gpa, Integer passedCredit, Integer failedCredit, List<String> passedCourses, List<String> failedCourses, List<String> notTakenCourses, List<String> currentlyTakenCourses) {
        this.gpa = gpa;
        this.passedCredit = passedCredit;
        this.failedCredit = failedCredit;
        this.passedCourses = passedCourses;
        this.failedCourses = failedCourses;
        this.notTakenCourses = notTakenCourses;
        this.currentlyTakenCourses = currentlyTakenCourses;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getPassedCredit() {
        return passedCredit;
    }

    public void setPassedCredit(Integer passedCredit) {
        this.passedCredit = passedCredit;
    }

    public Integer getFailedCredit() {
        return failedCredit;
    }

    public void setFailedCredit(Integer failedCredit) {
        this.failedCredit = failedCredit;
    }

    public List<String> getPassedCourses() {
        return passedCourses;
    }

    public void setPassedCourses(List<String> passedCourses) {
        this.passedCourses = passedCourses;
    }

    public List<String> getFailedCourses() {
        return failedCourses;
    }

    public void setFailedCourses(List<String> failedCourses) {
        this.failedCourses = failedCourses;
    }

    public List<String> getNotTakenCourses() {
        return notTakenCourses;
    }

    public void setNotTakenCourses(List<String> notTakenCourses) {
        this.notTakenCourses = notTakenCourses;
    }

    public List<String> getCurrentlyTakenCourses() {
        return currentlyTakenCourses;
    }

    public void setCurrentlyTakenCourses(List<String> currentlyTakenCourses) {
        this.currentlyTakenCourses = currentlyTakenCourses;
    }
}
