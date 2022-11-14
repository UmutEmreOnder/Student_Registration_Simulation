package edu.marmara.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import edu.marmara.dto.ScheduleGetDTO;
import edu.marmara.mapper.ScheduleMapper;
import edu.marmara.mapper.impl.ScheduleMapperImpl;
import edu.marmara.model.Advisor;
import edu.marmara.model.Schedule;
import edu.marmara.model.Student;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.StudentRepositoryImpl;
import edu.marmara.service.AdvisorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdvisorServiceImpl implements AdvisorService {
    private final ScheduleMapper scheduleMapper = new ScheduleMapperImpl();
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
    public void approveSchedule(Student student) throws IOException {
        String path = "json/schedule/" + student.getStudentId() + ".json";

        Schedule schedule = student.getWeeklySchedule();
        ScheduleGetDTO scheduleGetDTO = scheduleMapper.mapTo(schedule);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        if (schedule != null) {
            String json = ow.writeValueAsString(scheduleGetDTO);

            Files.write(Path.of(path), json.getBytes());
        }
    }
}


