package edu.marmara.model;

import java.util.List;


public class Course {
    private String courseCode;
    private String courseTitle;
    private Integer givenSemester;
    private List<Student> enrolledStudents;
    private Integer courseCredit;
    private List<Course> prerequisites;
    private Instructor instructor;
    private List<WeeklyDate> dates;
    private Integer maxSeats;
    private Integer takenSeats;
    private Integer minCreditReq;


    public Course() {
    }

    public Course(String courseCode, String courseTitle, Integer givenSemester, List<Student> enrolledStudents, Integer courseCredit, List<Course> prerequisites, Instructor instructor, List<WeeklyDate> dates, Integer maxSeats, Integer minCreditReq) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.givenSemester = givenSemester;
        this.enrolledStudents = enrolledStudents;
        this.courseCredit = courseCredit;
        this.prerequisites = prerequisites;
        this.instructor = instructor;
        this.dates = dates;
        this.maxSeats = maxSeats;
        this.takenSeats = maxSeats;
        this.minCreditReq = minCreditReq;
    }

    public void addWeeklyDate(WeeklyDate weeklyDate){
        this.dates.add(weeklyDate);
    }
    public void addPrerequisite(Course course){
        this.prerequisites.add(course);
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", givenSemester=" + givenSemester +
                ", enrolledStudents=" + enrolledStudents +
                ", courseCredit=" + courseCredit +
                ", prerequisites=" + prerequisites +
                ", instructor=" + instructor +
                ", dates=" + dates +
                '}';
    }

    public void increaseTakenSeat(){ this.takenSeats++; }
    public void decreaseTakenSeat(){ this.takenSeats--; }

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

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<WeeklyDate> getDates() {
        return dates;
    }

    public void setDates(List<WeeklyDate> dates) {
        this.dates = dates;
    }

    public Integer getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(Integer availableSeats) {
        this.takenSeats = availableSeats;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Integer getMinCreditReq() {
        return minCreditReq;
    }

    public void setMinCreditReq(Integer minCreditReq) {
        this.minCreditReq = minCreditReq;
    }
}
