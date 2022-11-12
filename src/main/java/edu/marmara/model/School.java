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
}
