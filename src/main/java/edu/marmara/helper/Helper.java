package edu.marmara.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import edu.marmara.dto.StudentGetDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Helper {
    public static void main(String[] args) {
        //Read the JSON file containing student array
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            String studentsJson = Files.readString(Path.of("json/mock/students.json"));
            StudentGetDTO[] students = mapper.readValue(studentsJson, StudentGetDTO[].class);

            //create a separate JSON file for each student
            ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
            for (StudentGetDTO student : students) {
                String path = "json/student/" + student.getStudentId() + ".json";
                String json = writer.writeValueAsString(student);
                Files.write(Path.of(path), json.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
