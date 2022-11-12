package edu.marmara.dto;

import lombok.Data;

public class CourseDTO {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private Integer courseCredit;
    private String instructorName;

    public String toString() {
        return "CourseDTO{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", givenSemester=" + givenSemester +
                ", courseCredit=" + courseCredit +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }

    public CourseDTO() {
    }

    public CourseDTO(String courseCode, String courseTitle, Integer givenSemester, Integer courseCredit, String instructorName) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.givenSemester = givenSemester;
        this.courseCredit = courseCredit;
        this.instructorName = instructorName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getGivenSemester() {
        return givenSemester;
    }

    public void setGivenSemester(Integer givenSemester) {
        this.givenSemester = givenSemester;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}