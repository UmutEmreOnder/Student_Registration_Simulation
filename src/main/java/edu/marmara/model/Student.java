package edu.marmara.model;

import lombok.Data;
import lombok.ToString;


@ToString(callSuper = true)
public class Student extends Person {
    private Long studentId;
    private Integer yearEnrolled;
    private Schedule weeklySchedule;
    private Transcript transcript;
    private Advisor advisor;
    private Integer semester;


    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", yearEnrolled=" + yearEnrolled +
                ", weeklySchedule=" + weeklySchedule +
                ", transcript=" + transcript +
                ", advisor=" + advisor +
                ", semester=" + semester +
                '}';
    }

    public Student() {
    }

    public Student(Long studentId, Integer yearEnrolled, Schedule weeklySchedule, Transcript transcript, Advisor advisor, Integer semester) {
        this.studentId = studentId;
        this.yearEnrolled = yearEnrolled;
        this.weeklySchedule = weeklySchedule;
        this.transcript = transcript;
        this.advisor = advisor;
        this.semester = semester;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getYearEnrolled() {
        return yearEnrolled;
    }

    public void setYearEnrolled(Integer yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }

    public Schedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(Schedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
