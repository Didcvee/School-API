package ru.didcvee.scheduleservice.entity.other;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.error.Mark;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Grade {

    private String weekDay;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private Mark mark;
    private String teacherUsername;
    private String subject;
    private String studentUsername;

    @Override
    public String toString() {
        return "Grade{" +
                "weekDay='" + weekDay + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", mark=" + mark +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", subject='" + subject + '\'' +
                ", studentUsername='" + studentUsername + '\'' +
                '}';
    }
}