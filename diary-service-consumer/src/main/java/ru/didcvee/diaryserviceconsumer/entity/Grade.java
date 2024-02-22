package ru.didcvee.diaryserviceconsumer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Grade {

    private String weekDay;
    private int lessonId;
    private LocalDateTime timeFrom;
    private LocalDateTime date;
    private Mark mark;
    private String teacherUsername;
    private String subject;
    private String studentUsername;
    private String groupNumber;

    @Override
    public String toString() {
        return "Grade{" +
                "weekDay='" + weekDay + '\'' +
                ", lessonId=" + lessonId +
                ", timeFrom=" + timeFrom +
                ", date=" + date +
                ", mark=" + mark +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", subject='" + subject + '\'' +
                ", studentUsername='" + studentUsername + '\'' +
                '}';
    }
}
