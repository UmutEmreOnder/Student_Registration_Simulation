package edu.marmara;

import edu.marmara.model.Instructor;
import edu.marmara.model.School;
import edu.marmara.model.Student;
import edu.marmara.service.JsonService;
import edu.marmara.service.impl.JsonServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JsonService jsonService = new JsonServiceImpl();

        String studentInfo = Files.readString(Path.of("student.json"));
        List<Student> students = jsonService.readStudentsFromJson(studentInfo);

/*        String instructorInfo = Files.readString(Path.of("instructor.json"));
        List<Instructor> instructors = jsonService.readInstructorsFromJson(instructorInfo);*/

        School school = new School();

        school.setStudents(students);
 //       school.setInstructors(instructors);

        System.out.println(school.getStudents());
    }
}
