package edu.marmara.model;

import java.util.HashMap;
import java.util.List;


public class Transcript {
    private Double gpa;
    private Integer passedCredit;
    private Integer failedCredit;
    private HashMap<Course, Double> passedCourses;
    private List<Course> failedCourses;
    private List<Course> notTakenCourses;
    private List<Course> currentlyTakenCourses;

    public Transcript() {
    }

    public Transcript(Double gpa, Integer passedCredit, Integer failedCredit, HashMap<Course, Double> passedCourses, List<Course> failedCourses, List<Course> notTakenCourses, List<Course> currentlyTakenCourses) {
        this.gpa = gpa;
        this.passedCredit = passedCredit;
        this.failedCredit = failedCredit;
        this.passedCourses = passedCourses;
        this.failedCourses = failedCourses;
        this.notTakenCourses = notTakenCourses;
        this.currentlyTakenCourses = currentlyTakenCourses;
    }
    public void addCurrentlyTakenCourse(Course course){
        this.currentlyTakenCourses.add(course);
    }
    public void addFailedCourse(Course course){
        this.failedCourses.add(course);
    }
    public void addNotTakenCourse(Course course){
        this.notTakenCourses.add(course);
    }
    public void removeFailedCourse(Course course){

        this.failedCourses.remove(course);
    }
    public void removeNotTakenCourse(Course course){

        this.notTakenCourses.remove(course);
    }
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

    public HashMap<Course, Double> getPassedCourses() {
        return passedCourses;
    }

    public void setPassedCourses(HashMap<Course, Double> passedCourses) {
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

    public List<Course> getCurrentlyTakenCourses() {
        return currentlyTakenCourses;
    }

    public void setCurrentlyTakenCourses(List<Course> currentlyTakenCourses) {
        this.currentlyTakenCourses = currentlyTakenCourses;
    }
}
