package ru.didcvee.scheduleservice.dto;

import jakarta.persistence.*;
import lombok.Data;
import ru.didcvee.scheduleservice.entity.Group;

@Data
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private int age;
    private int groupNumber;
    // Дополнительные поля и методы
}
