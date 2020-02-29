package pl.sda.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Jan",
                "Kowalski",
                32);

        // serializacja - przekształcenie obiektu na formę tekstową

        Student student1 = new Student("Piotr", "Nowak", 23);
        Student student2 = new Student("Krzysztof", "Piechota", 54);
        Student student3 = new Student("Jan", "Pietrucha", 78);
        Student student4 = new Student("Kamil", "Bulimia", 14);
        Student student5 = new Student("Tomasz", "Kwiatkowski", 26);


        ObjectMapper objectMapper = new ObjectMapper();

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        JSONUtils jsonUtils = new JSONUtils();
        jsonUtils.writeList("lista.json", studentList);

        jsonUtils.readList("lista.json");
        System.out.println(" ");



        try {
            objectMapper.writeValue(new File("student.json"), student);
            objectMapper.writeValue(new File("student1.json"), student1);
            objectMapper.writeValue(new File("student2.json"), student2);
            objectMapper.writeValue(new File("student3.json"), student3);
            objectMapper.writeValue(new File("student4.json"), student4);
            objectMapper.writeValue(new File("student5.json"), student5);
            objectMapper.writeValue(new File("studentLista.json"), studentList);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}