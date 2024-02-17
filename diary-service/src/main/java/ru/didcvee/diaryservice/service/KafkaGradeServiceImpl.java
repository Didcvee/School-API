package ru.didcvee.diaryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import ru.didcvee.diaryservice.entity.Grade;

@Service
@RequiredArgsConstructor
public class KafkaGradeServiceImpl implements KafkaGradeService {
    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Grade grade) {
        String topic = "grade-topic";
        sender.send(
                        Mono.just(
                                SenderRecord.create(
                                        topic,
                                        0,
                                        System.currentTimeMillis(),
                                        String.valueOf(grade.hashCode()),
                                        grade,
                                        null
                                )
                        )
                )
                .subscribe();
    }
}
