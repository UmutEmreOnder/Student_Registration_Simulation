package edu.marmara.service.impl;

import edu.marmara.model.Course;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;
import edu.marmara.service.StudentService;

import java.util.ArrayList;
import java.util.Random;

public class StudentServiceImpl implements StudentService {
    @Override
    public void assignCourses(School school) {
        Random random = new Random();

        for (Student student : school.getStudents()) {
            if (student.getTranscript() == null) {
                student.setTranscript(new Transcript());
                Transcript transcript = student.getTranscript();
                transcript.setFailedCourses(new ArrayList<>());
                transcript.setPassedCourses(new ArrayList<>());
                transcript.setNotTakenCourses(new ArrayList<>());
                transcript.setPassedCredit(0);
                transcript.setFailedCredit(0);
            }

            for (Course course : school.getCourses()) {
                if (course.getGivenSemester() >= student.getSemester()) {
                    student.getTranscript().getNotTakenCourses().add(course);
                    continue;
                }

                if (random.nextInt(2) == 1) {
                    student.getTranscript().getPassedCourses().add(course);
                    student.getTranscript().setPassedCredit(student.getTranscript().getPassedCredit() + course.getCourseCredit());
                } else {
                    student.getTranscript().getFailedCourses().add(course);
                    student.getTranscript().setFailedCredit(student.getTranscript().getFailedCredit() + course.getCourseCredit());
                }
            }
        }
    }
}
