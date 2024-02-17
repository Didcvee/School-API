package ru.didcvee.diaryservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Grade {
    private int id;
    private String weekDay;
    private LocalDateTime timeFrom;
    private Mark mark;
    private String teacherUsername;
    private String subjectName;
}
