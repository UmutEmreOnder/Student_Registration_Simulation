package edu.marmara.dto;

import java.util.List;

public class CourseGetDTO {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private Integer courseCredit;
    private List<String> prerequisites;
    private List<String> weeklyDate;
    private Integer maxSeats;
    private Integer takenSeats;
    private Integer minCreditReq;

    public CourseGetDTO() {
    }

    public CourseGetDTO(String courseCode, String courseTitle, Integer givenSemester, Integer courseCredit, List<String> prerequisites, List<String> weeklyDate, Integer maxSeats, Integer takenSeats, Integer minCreditReq) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.givenSemester = givenSemester;
        this.courseCredit = courseCredit;
        this.prerequisites = prerequisites;
        this.weeklyDate = weeklyDate;
        this.maxSeats = maxSeats;
        this.takenSeats = takenSeats;
        this.minCreditReq = minCreditReq;
    }

    @Override
    public String toString() {
        return "CourseGetDTO{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", givenSemester=" + givenSemester +
                ", courseCredit=" + courseCredit +
                ", prerequisites=" + prerequisites +
                ", weeklyDate=" + weeklyDate +
                '}';
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

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<String> getWeeklyDate() {
        return weeklyDate;
    }

    public void setWeeklyDate(List<String> weeklyDate) {
        this.weeklyDate = weeklyDate;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Integer getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(Integer takenSeats) {
        this.takenSeats = takenSeats;
    }

    public Integer getMinCreditReq() {
        return minCreditReq;
    }

    public void setMinCreditReq(Integer minCreditReq) {
        this.minCreditReq = minCreditReq;
    }
}
