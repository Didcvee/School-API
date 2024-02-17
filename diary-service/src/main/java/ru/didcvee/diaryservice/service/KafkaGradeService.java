package ru.didcvee.diaryservice.service;

import ru.didcvee.diaryservice.entity.Grade;

public interface KafkaGradeService {
    void send(Grade grade);
}
