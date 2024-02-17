package ru.didcvee.diaryservice.entity.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.didcvee.diaryservice.entity.Mark;

@NoArgsConstructor
@Getter
@Setter
public class GradeTestOptions {
    private int delayInSeconds;
    private Mark[] mark;
}
