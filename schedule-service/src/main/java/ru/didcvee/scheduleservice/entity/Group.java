package ru.didcvee.scheduleservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class Group {

    private int groupNumber;
    private List<Lesson> lesson;
}
