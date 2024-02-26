package ru.didcvee.analyserwebsocketservice.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ru.didcvee.analyserwebsocketservice.config.LocalDateTimeDeserializer;
import ru.didcvee.analyserwebsocketservice.entity.Grade;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class KafkaGradeReceiverImpl implements KafkaGradeReceiver {
    private final KafkaReceiver<String, Object> receiver;
    private final KafkaGradeService kafkaGradeService;
    @PostConstruct
    private void init() {
        fetch();
    }
    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        new LocalDateTimeDeserializer())
                .create();
        receiver.receive()
                .subscribe(r -> {
                    Grade grade = gson.fromJson(r.value().toString(), Grade.class);
                    System.out.println(Thread.currentThread().getName());
                    kafkaGradeService.handle(grade);
                    r.receiverOffset().acknowledge();
                });
    }
}
