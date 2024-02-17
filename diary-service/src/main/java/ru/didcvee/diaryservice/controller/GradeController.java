package ru.didcvee.diaryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.dto.GradeTestOptionsDto;
import ru.didcvee.diaryservice.entity.test.GradeTestOptions;
import ru.didcvee.diaryservice.mapper1.GradeTestOptionsMapper;
import ru.didcvee.diaryservice.service.KafkaGradeService;
import ru.didcvee.diaryservice.service.TestDataService;
import ru.didcvee.diaryservice.mapper1.GradeMapper;


@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
    private final KafkaGradeService kafkaGradeService;
    private final TestDataService testDataService;
    private final GradeMapper gradeMapper;
    private final GradeTestOptionsMapper testOptionsMapper;



    @PostMapping("/send")
    public void send(
            @RequestBody GradeDto gradeDto
    ) {
        Grade grade = gradeMapper.toEntity(gradeDto);
        kafkaGradeService.send(grade);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody GradeTestOptionsDto testOptionsDto) {
        GradeTestOptions testOptions = testOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
