package ru.didcvee.scheduleservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    private String subjectName;
    // Дополнительные поля и методы
}
