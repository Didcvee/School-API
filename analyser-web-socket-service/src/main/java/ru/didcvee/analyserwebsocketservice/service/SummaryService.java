package ru.didcvee.analyserwebsocketservice.service;

import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.entity.Summary;
import ru.didcvee.analyserwebsocketservice.entity.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryService {
    Summary get(String groupName, Set<SummaryType> summaryTypes);

    void handle(
            Grade grade
    );

}
