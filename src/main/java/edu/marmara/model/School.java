package edu.marmara.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class School {
    private static School schoolInstance = null;

    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;

    private School() {
    }

    public static School getInstance() {
        if (schoolInstance == null) {
            schoolInstance = new School();
            schoolInstance.setInstructors(new ArrayList<>());
            schoolInstance.setStudents(new ArrayList<>());
            schoolInstance.setCourses(new ArrayList<>());
        }

        return schoolInstance;
    }

    public static edu.marmara.model.School getSchoolInstance() {
        return schoolInstance;
    }

    public static void setSchoolInstance(edu.marmara.model.School schoolInstance) {
        School.schoolInstance = schoolInstance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
