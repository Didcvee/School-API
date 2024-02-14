package ru.didcvee.scheduleservice.dto;

import jakarta.persistence.*;
import lombok.Data;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.entity.Teacher;

@Data
public class LessonDto {

    private int id;
    private int lessonNumber;
    private String weekDay;


    private String subject;

    private int groupNumber;
    private int teacherId;
    // Дополнительные поля и методы
}