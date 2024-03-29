package edu.marmara.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.marmara.config.Config;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface JsonService {
    Student readStudentFromJson(String jsonFormattedStudent) throws ParseException, JsonProcessingException;

    List<Instructor> readInstructorsFromJson(String jsonFormattedInstructor) throws ParseException, JsonProcessingException;

    List<Course> readCoursesFromJson(String jsonFormattedCourse) throws ParseException, JsonProcessingException;

    Schedule readScheduleFromJson(String jsonFormattedSchedule) throws JsonProcessingException;

    Config readConfigFromJson(String jsonFormattedConfig) throws JsonProcessingException;

    void end() throws IOException;

    Transcript readTranscriptFromJson(String jsonFormattedTranscript) throws JsonProcessingException;
}
