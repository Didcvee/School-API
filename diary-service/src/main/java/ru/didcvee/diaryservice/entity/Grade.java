package ru.didcvee.diaryservice.entity;

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
    private ObjectId id;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentUsername='" + studentUsername + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    //    private int ids;
//    private String weekDay;
//    private LocalDateTime timeFrom;
//    private Mark mark;
//    private String teacherUsername;
    private String studentUsername;
    private String subjectName;
}
