package edu.marmara.mapper.impl;

import edu.marmara.dto.InstructorDTO;
import edu.marmara.dto.InstructorGetDTO;
import edu.marmara.mapper.InstructorMapper;
import edu.marmara.model.Advisor;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.Schedule;
import edu.marmara.repository.CourseRepository;
import edu.marmara.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;

public class InstructorMapperImpl implements InstructorMapper {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public Instructor mapTo(InstructorGetDTO instructorGetDTO) {
        if (instructorGetDTO.getIsAdvisor() == Boolean.TRUE) {
            return mapToAdvisor(instructorGetDTO);
        }

        Instructor instructor = new Instructor();

        instructor.setUuid(instructorGetDTO.getUuid());
        instructor.setName(instructorGetDTO.getName());
        instructor.setSurname(instructorGetDTO.getSurname());
        instructor.setEmail(instructorGetDTO.getEmail());
        instructor.setBirthDate(instructorGetDTO.getBirthDate());
        instructor.setPresentedCourses(new ArrayList<>());
        instructor.setWeeklySchedule(new Schedule());
        instructor.getWeeklySchedule().setCourses(new ArrayList<>());


        for (String courseCode : instructorGetDTO.getPresentedCourses()) {
            Course course = courseRepository.findByCourseCode(courseCode);

            if (course != null) {
                instructor.getPresentedCourses().add(course);
                course.setInstructor(instructor);
                instructor.getWeeklySchedule().getCourses().add(course);
            }
        }

        return instructor;
    }

    private Advisor mapToAdvisor(InstructorGetDTO instructorGetDTO) {
        Advisor advisor = new Advisor();

        advisor.setUuid(instructorGetDTO.getUuid());
        advisor.setName(instructorGetDTO.getName());
        advisor.setSurname(instructorGetDTO.getSurname());
        advisor.setEmail(instructorGetDTO.getEmail());
        advisor.setBirthDate(instructorGetDTO.getBirthDate());
        advisor.setPresentedCourses(new ArrayList<>());
        advisor.setStudents(new ArrayList<>());
        advisor.setWeeklySchedule(new Schedule());
        advisor.getWeeklySchedule().setCourses(new ArrayList<>());


        for (String courseCode : instructorGetDTO.getPresentedCourses()) {
            Course course = courseRepository.findByCourseCode(courseCode);

            if (course != null) {
                advisor.getPresentedCourses().add(course);
                course.setInstructor(advisor);
                advisor.getWeeklySchedule().getCourses().add(course);
            }
        }

        return advisor;
    }

    @Override
    public InstructorDTO mapTo(Instructor instructor) {
        InstructorDTO instructorDTO = new InstructorDTO();

        instructorDTO.setUuid(instructor.getUuid());
        instructorDTO.setName(instructor.getName());
        instructorDTO.setSurname(instructor.getSurname());
        instructorDTO.setEmail(instructor.getEmail());
        instructorDTO.setBirthDate(instructor.getBirthDate());

        return instructorDTO;
    }
}
