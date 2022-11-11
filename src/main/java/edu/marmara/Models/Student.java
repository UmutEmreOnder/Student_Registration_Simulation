package edu.marmara.Models;

public class Student extends Person{

    private String studentID;
    private String semester;
    private Teacher teacher;
    private String[][] transcript;
    private String[] chosen_courses;

    public Student(String name, String studentID, String semester, Teacher teacher) {
        super(name);
        this.semester = semester;
        this.studentID = studentID;
        this.teacher = teacher;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getSemester() {
        return semester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String[] getChosen_courses() {
        return chosen_courses;
    }

    public String[][] getTranscript() {
        return transcript;
    }
    @Override
    public String getName() {
        return super.getName();
    }
}
