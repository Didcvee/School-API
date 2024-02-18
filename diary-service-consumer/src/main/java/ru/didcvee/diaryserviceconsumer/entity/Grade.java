package ru.didcvee.diaryserviceconsumer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", weekDay='" + weekDay + '\'' +
                ", timeFrom=" + timeFrom +
                ", mark=" + mark +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
