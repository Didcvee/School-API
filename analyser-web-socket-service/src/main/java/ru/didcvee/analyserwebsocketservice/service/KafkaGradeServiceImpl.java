package ru.didcvee.analyserwebsocketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.repo.SummaryRepositoryImpl;

@Service
@RequiredArgsConstructor
public class KafkaGradeServiceImpl implements KafkaGradeService {
    private final SummaryRepositoryImpl summaryRepository;
    @Override
    public void handle(Grade grade) {

    }
}
