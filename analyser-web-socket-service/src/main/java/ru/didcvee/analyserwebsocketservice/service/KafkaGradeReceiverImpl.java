package ru.didcvee.analyserwebsocketservice.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ru.didcvee.analyserwebsocketservice.config.LocalDateTimeDeserializer;
import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.entity.Mark;

import java.time.Instant;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class KafkaGradeReceiverImpl implements KafkaGradeReceiver {
    private final KafkaReceiver<String, Object> receiver;
    private final SummaryService summaryService;
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
                    JsonObject payload = JsonParser.parseString(String.valueOf(r))
                            .getAsJsonObject()
                            .get("payload")
                            .getAsJsonObject();
                    System.out.println(r);
                    Grade grade = new Grade();

                    grade.setWeekDay(
                            payload.get("weekday")
                                    .getAsString()
                    );
                    grade.setMark(
                            Mark.valueOf(payload.get("mark")
                                    .getAsString()
                            )
                    );
                    grade.setSubject(
                            payload.get("subject")
                                    .getAsString()
                    );
                    grade.setTeacherUsername(
                            payload.get("teacherusername")
                                    .getAsString()
                    );
                    grade.setStudentUsername(
                            payload.get("studentusername")
                                    .getAsString()
                    );



//                    Grade grade = gson.fromJson(r.value().toString(), Grade.class);
//                    System.out.println(Thread.currentThread().getName());
                    summaryService.handle(grade);
                    r.receiverOffset().acknowledge();
                });
    }
}
