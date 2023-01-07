package edu.marmara.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.marmara.config.Config;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.Schedule;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.Transcript;
import edu.marmara.service.JsonService;
import edu.marmara.service.SchoolService;
import edu.marmara.service.StudentService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    private static JsonService jsonService = new JsonServiceImpl();
    private static School school = School.getInstance();

    private static StudentService studentService = new StudentServiceImpl();

    @Override
    public void uploadJsons() {
        try {
            String configInfo = Files.readString(Path.of("json/config/config.json"));
            Config config = jsonService.readConfigFromJson(configInfo);
            school.setConfig(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            String courseInfo = Files.readString(Path.of("json/course/course.json"));
            List<Course> courses = jsonService.readCoursesFromJson(courseInfo);

            school.setCourses(courses);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            String instructorInfo = Files.readString(Path.of("json/instructor/instructor.json"));
            List<Instructor> instructors = jsonService.readInstructorsFromJson(instructorInfo);

            school.setInstructors(instructors);

            File folder = new File("json/student/");
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles == null) {
                return;
            }

            Integer count = 0;
            for (File file : listOfFiles) {
                if (count.equals(school.getConfig().getNumberOfStudents())) {
                    break;
                }

                if (file.isFile() && file.getName().endsWith(".json")) {
                    String content = Files.readString(Path.of(file.getPath()));
                    Student student = jsonService.readStudentFromJson(content);

                    File scheduleFile = new File("json/schedule/" + student.getStudentId() + ".json");
                    File transcriptFile = new File("json/transcript/" + student.getStudentId() + ".json");

                    if (scheduleFile.exists()) {
                        Schedule schedule = jsonService.readScheduleFromJson(Files.readString(Path.of(scheduleFile.getPath())));
                        student.setWeeklySchedule(schedule);
                    }

                    if (transcriptFile.exists()) {
                        Transcript transcript = jsonService.readTranscriptFromJson(Files.readString(Path.of(transcriptFile.getPath())));
                        transcript.calculateGPA();
                        student.setTranscript(transcript);
                    } else {
                        studentService.assignRandomCourses(student);
                    }

                    school.addStudent(student);
                    count++;
                }
            }
        } catch (RuntimeException | IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        studentService.enrollRandomCourses();
    }
}
