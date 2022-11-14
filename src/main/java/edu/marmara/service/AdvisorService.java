package edu.marmara.service;

import edu.marmara.model.Advisor;
import edu.marmara.model.Student;

import java.io.IOException;

public interface AdvisorService {
    Student getStudent(Long studentID, Advisor advisor);

    void approveSchedule(Student student) throws IOException;
}