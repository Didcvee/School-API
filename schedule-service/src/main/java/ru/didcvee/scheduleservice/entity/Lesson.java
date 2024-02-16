package ru.didcvee.scheduleservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Lesson {

    private int id;

    private int lessonNumber;

    private String weekDay;

    private Subject subject;

    private Group group;

    private Teacher teacher;
}
