package ru.didcvee.scheduleservice.entity.other;

import lombok.*;


import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Grade {
    private String objectId;

    @Override
    public String toString() {
        return "Grade{" +
                "objectId='" + objectId + '\'' +
                ", lessonId=" + lessonId +
                ", weekDay='" + weekDay + '\'' +
                ", timeFrom=" + timeFrom +
                ", date=" + date +
                ", mark=" + mark +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", subject='" + subject + '\'' +
                ", studentUsername='" + studentUsername + '\'' +
                '}';
    }

    private int lessonId;
    private String weekDay;
    private LocalDateTime timeFrom;
    private LocalDateTime date;
    private Mark mark;
    private String teacherUsername;
    private String subject;
    private String studentUsername;
    private String groupNumber;

    public Grade(Mark mark, String teacherUsername) {
        this.mark = mark;
        this.teacherUsername = teacherUsername;
    }

    public Grade(String weekDay) {
        this.weekDay = weekDay;
    }

}