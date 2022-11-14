package edu.marmara.model;

import java.util.List;


public class Transcript {
    private Double gpa;
    private Integer passedCredit;
    private Integer failedCredit;
    private List<Course> passedCourses;
    private List<Course> failedCourses;
    private List<Course> notTakenCourses;

    @Override
    public String toString() {
        return "Transcript{" +
                "gpa=" + gpa +
                ", passedCredit=" + passedCredit +
                ", failedCredit=" + failedCredit +
                ", passedCourses=" + passedCourses +
                ", failedCourses=" + failedCourses +
                ", notTakenCourses=" + notTakenCourses +
                '}';
    }

    public Transcript() {
    }

    public Transcript(Double gpa, Integer passedCredit, Integer failedCredit, List<Course> passedCourses, List<Course> failedCourses, List<Course> notTakenCourses) {
        this.gpa = gpa;
        this.passedCredit = passedCredit;
        this.failedCredit = failedCredit;
        this.passedCourses = passedCourses;
        this.failedCourses = failedCourses;
        this.notTakenCourses = notTakenCourses;
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

    public List<Course> getPassedCourses() {
        return passedCourses;
    }

    public void setPassedCourses(List<Course> passedCourses) {
        this.passedCourses = passedCourses;
    }

    public List<Course> getFailedCourses() {
        return failedCourses;
    }

    public void setFailedCourses(List<Course> failedCourses) {
        this.failedCourses = failedCourses;
    }

    public List<Course> getNotTakenCourses() {
        return notTakenCourses;
    }

    public void setNotTakenCourses(List<Course> notTakenCourses) {
        this.notTakenCourses = notTakenCourses;
    }
}
