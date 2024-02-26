package ru.didcvee.analyserwebsocketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.didcvee.analyserwebsocketservice.entity.Summary;
import ru.didcvee.analyserwebsocketservice.entity.SummaryType;
import ru.didcvee.analyserwebsocketservice.exc.GroupNotFoundException;
import ru.didcvee.analyserwebsocketservice.repo.SummaryRepositoryImpl;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepositoryImpl summaryRepository;
    @Override
    public Summary get(String groupName,
                       Set<SummaryType> summaryTypes) {
        return summaryRepository.findByGroupName(groupName,
                        summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes)
                .orElseThrow(GroupNotFoundException::new);
    }
}
