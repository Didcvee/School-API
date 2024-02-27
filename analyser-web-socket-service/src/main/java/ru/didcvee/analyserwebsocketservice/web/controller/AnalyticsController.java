package ru.didcvee.analyserwebsocketservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.entity.Summary;
import ru.didcvee.analyserwebsocketservice.entity.SummaryType;
import ru.didcvee.analyserwebsocketservice.service.SummaryService;

import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnalyticsController {
    private final SummaryService summaryService;
    @GetMapping("/summary/{groupName}")
    public Summary getSummaryGroup(
            @PathVariable String groupName,
            @RequestParam(value = "st", required = false)
                    Set<SummaryType> summaryTypes
    ) {
        Summary summary = summaryService.get(
                groupName,
                summaryTypes
        );
        return summary;
    }
    @PostMapping
    public void saveGradeInRedis(
            @RequestBody Grade grade
    ) {
        summaryService.handle(grade);
    }
}
