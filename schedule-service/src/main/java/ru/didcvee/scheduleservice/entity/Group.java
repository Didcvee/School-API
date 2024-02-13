package ru.didcvee.scheduleservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "group_")
public class Group {
    @Id
    private int groupNumber;
    // Дополнительные поля и методы
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Lesson> lesson;
}
