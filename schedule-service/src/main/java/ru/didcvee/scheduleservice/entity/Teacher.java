package ru.didcvee.scheduleservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class Teacher {


    private int id;

    private String firstname;

    private String lastname;

    private String patronymic;

    private int age;

    private List<Subject> subjects;

}
