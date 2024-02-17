package ru.didcvee.diaryservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.didcvee.diaryservice.entity.Mark;

@NoArgsConstructor
@Getter
@Setter
public class GradeTestOptionsDto {
    private int delayInSeconds;
    private Mark[] mark;
}
