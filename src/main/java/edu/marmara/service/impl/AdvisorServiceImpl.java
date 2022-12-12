package edu.marmara.service.impl;

import edu.marmara.mapper.impl.ScheduleMapperImpl;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Student;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.StudentRepositoryImpl;
import edu.marmara.service.AdvisorService;

public class AdvisorServiceImpl implements AdvisorService {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public Student getStudent(Long studentID, Advisor advisor) {
        Student student = studentRepository.findByStudentId(studentID);

        if (student == null) {
            return null;
        }

        if (advisor.getStudents().contains(student)) {
            return student;
        }

        return null;
    }

    @Override
    public void approveSchedule(Student student) {
        for (Course course : student.getWeeklySchedule().getCourses()) {
            student.removeFromTranscriptNotTakenCourse(course);
            student.removeFromTranscriptFailedCourse(course);
            student.addCurrentlyTakenCourseToTranscript(course);
        }
    }
}


