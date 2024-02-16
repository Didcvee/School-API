package ru.didcvee.scheduleservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private int age;


    private Group group;
    // Дополнительные поля и методы
}
