package ru.didcvee.diaryserviceconsumer.service;

import org.springframework.stereotype.Service;
import ru.didcvee.diaryserviceconsumer.entity.Grade;

@Service
public class KafkaDataServiceImpl implements KafkaGradeService {
    @Override
    public void handle(Grade grade) {
        System.out.println("Grade is: " + grade.toString());
    }
}
