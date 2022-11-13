package edu.marmara.service;

import edu.marmara.model.Advisor;
import edu.marmara.model.Student;

public interface AdvisorService {
    Student getStudent(Long studentID, Advisor advisor);
}
