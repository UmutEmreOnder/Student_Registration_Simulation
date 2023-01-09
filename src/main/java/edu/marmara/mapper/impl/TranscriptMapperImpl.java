package edu.marmara.mapper.impl;

import edu.marmara.dto.TranscriptGetDTO;
import edu.marmara.mapper.TranscriptMapper;
import edu.marmara.model.Course;
import edu.marmara.model.Transcript;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class TranscriptMapperImpl implements TranscriptMapper {
    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public Transcript mapTo(TranscriptGetDTO transcriptGetDTO) {
        Transcript transcript = new Transcript();

        transcript.setGpa(transcriptGetDTO.getGpa());
        transcript.setPassedCredit(transcriptGetDTO.getPassedCredit());
        transcript.setFailedCredit(transcriptGetDTO.getFailedCredit());

        transcript.setCurrentlyTakenCourses(new ArrayList<>());
        for (String courseCode : transcriptGetDTO.getCurrentlyTakenCourses()) {
            transcript.addCurrentlyTakenCourse(courseRepository.findByCourseCode(courseCode));
        }

        transcript.setFailedCourses(new ArrayList<>());
        for (String courseCode : transcriptGetDTO.getFailedCourses()) {
            transcript.addFailedCourse(courseRepository.findByCourseCode(courseCode));
        }

        transcript.setNotTakenCourses(new ArrayList<>());
        for (String courseCode : transcriptGetDTO.getNotTakenCourses()) {
            transcript.addNotTakenCourse(courseRepository.findByCourseCode(courseCode));
        }

        transcript.setPassedCourses(new HashMap<>());
        for (String courseAndGrade : transcriptGetDTO.getPassedCourses()) {
            String courseCode = courseAndGrade.split(" ")[0];
            Double grade = Double.valueOf(courseAndGrade.split(" ")[1]);
            transcript.getPassedCourses().put(courseRepository.findByCourseCode(courseCode), grade);
        }

        return transcript;
    }

    @Override
    public TranscriptGetDTO mapTo(Transcript transcript) {
        TranscriptGetDTO transcriptGetDTO = new TranscriptGetDTO();

        transcriptGetDTO.setGpa(transcript.getGpa());
        transcriptGetDTO.setPassedCredit(transcript.getPassedCredit());
        transcriptGetDTO.setFailedCredit(transcript.getFailedCredit());

        transcriptGetDTO.setFailedCourses(new ArrayList<>());
        for (Course course : transcript.getFailedCourses()) {
            transcriptGetDTO.addFailedCourse(course.getCourseCode());
        }

        transcriptGetDTO.setNotTakenCourses(new ArrayList<>());
        for (Course course : transcript.getNotTakenCourses()) {
            transcriptGetDTO.addNotTakenCourse(course.getCourseCode());
        }

        transcriptGetDTO.setCurrentlyTakenCourses(new ArrayList<>());
        for (Course course : transcript.getCurrentlyTakenCourses()) {
            transcriptGetDTO.addCurrentlyTakenCourse(course.getCourseCode());
        }

        transcriptGetDTO.setPassedCourses(new ArrayList<>());
        for (Course course : transcript.getPassedCourses().keySet()) {
            transcriptGetDTO.addPassesCourse(course.getCourseCode() + " " + transcript.getPassedCourses().get(course));
        }

        return transcriptGetDTO;
    }
}
