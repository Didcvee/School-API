package ru.didcvee.diaryserviceconsumer.service;

import ru.didcvee.diaryserviceconsumer.entity.Grade;

public interface KafkaGradeService {
    void handle(Grade grade);
}
