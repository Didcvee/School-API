package ru.didcvee.diaryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.entity.Mark;
import ru.didcvee.diaryservice.entity.test.GradeTestOptions;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {
    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaGradeService kafkaGradeService;

    @Override
    public void sendMessages(GradeTestOptions gradeTestOptions) {
        if (gradeTestOptions.getMark().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Grade grade = new Grade();
//                        grade.setTeacherUsername("mmm");
//                        grade.setMark(Mark.FIVE);
//                        grade.setTimeFrom(LocalDateTime.now());
                        kafkaGradeService.send(grade);
                    },
                    0,
                    gradeTestOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS);
        }
    }
}
