package ru.didcvee.analyserwebsocketservice.repo;

import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.entity.Summary;
import ru.didcvee.analyserwebsocketservice.entity.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {
    Optional<Summary> findByGroupName(String groupName,
                                      Set<SummaryType> summaryTypes);
}
