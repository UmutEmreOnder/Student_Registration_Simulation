package edu.marmara.Models;

public class Course {
    private String course_name;
    private String lecture_code;
    private int credit;
    private int required_credits;
    //prerequisite lectures, lecture sessions, lecture semester and lecture type like (FTE,NTE...) will be used

    public Course(String course_name, String lecture_code, int credit, int required_credits){
        this.course_name = course_name;
        this.lecture_code = lecture_code;
        this.credit = credit;
        this.required_credits = required_credits;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getLecture_code() {
        return lecture_code;
    }

    public int getCredit() {
        return credit;
    }

    public int getRequired_credits() {
        return required_credits;
    }
    @Override
    public String toString(){
        return "Course Name: " + course_name + "....Lecture code: " + lecture_code + "....Credit: " + credit;
    }
}
