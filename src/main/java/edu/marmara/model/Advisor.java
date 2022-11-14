package edu.marmara.model;

import java.util.List;

public class Advisor extends Instructor {
    private List<Student> students;

    @Override
    public String toString() {
        return "Advisor{" +
                "students=" + students +
                '}';
    }

    public Advisor() {
    }

    public Advisor(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
