package ru.didcvee.diaryservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.didcvee.diaryservice.entity.Mark;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class GradeDto {
    private int id;
    private LocalDateTime timeFrom;
    private String weekDay;
    private Mark mark;
    private String teacherUsername;
    private String subjectName;
}
