package edu.marmara.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
public class Advisor extends Instructor {
    private List<Student> students;

    @java.lang.Override
    public java.lang.String toString() {
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
