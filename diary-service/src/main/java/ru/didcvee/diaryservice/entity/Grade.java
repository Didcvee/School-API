package ru.didcvee.diaryservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Grade {
    private ObjectId _id;

    @Override
    public String toString() {
        return "Grade{" +
                "objectId=" + _id +
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
