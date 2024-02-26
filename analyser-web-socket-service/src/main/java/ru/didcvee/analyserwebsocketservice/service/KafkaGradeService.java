package ru.didcvee.analyserwebsocketservice.service;


import ru.didcvee.analyserwebsocketservice.entity.Grade;

public interface KafkaGradeService {
    void handle(Grade grade);
}
