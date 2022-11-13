package edu.marmara;

import edu.marmara.mapper.CourseMapper;
import edu.marmara.mapper.InstructorMapper;
import edu.marmara.mapper.StudentMapper;
import edu.marmara.mapper.impl.CourseMapperImpl;
import edu.marmara.mapper.impl.InstructorMapperImpl;
import edu.marmara.mapper.impl.StudentMapperImpl;
import edu.marmara.model.Course;
import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.model.WeeklyDate;
import edu.marmara.repository.InstructorRepository;
import edu.marmara.repository.StudentRepository;
import edu.marmara.repository.impl.InstructorRepositoryImpl;
import edu.marmara.repository.impl.StudentRepositoryImpl;
import edu.marmara.service.CourseService;
import edu.marmara.service.JsonService;
import edu.marmara.service.SchoolService;
import edu.marmara.service.StudentService;
import edu.marmara.service.impl.CourseServiceImpl;
import edu.marmara.service.impl.JsonServiceImpl;
import edu.marmara.service.impl.SchoolServiceImpl;
import edu.marmara.service.impl.StudentServiceImpl;
import edu.marmara.view.View;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        View.start();
    }
}