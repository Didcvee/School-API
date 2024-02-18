package ru.didcvee.diaryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.dto.GradeTestOptionsDto;
import ru.didcvee.diaryservice.entity.test.GradeTestOptions;
import ru.didcvee.diaryservice.mapper1.GradeTestOptionsMapper;
import ru.didcvee.diaryservice.service.GradeService;
import ru.didcvee.diaryservice.service.KafkaGradeService;
import ru.didcvee.diaryservice.service.TestDataService;
import ru.didcvee.diaryservice.mapper1.GradeMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
    private final KafkaGradeService kafkaGradeService;
    private final TestDataService testDataService;
    private final GradeMapper gradeMapper;
    private final GradeTestOptionsMapper testOptionsMapper;

    private final GradeService gradeService;



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
    @GetMapping("/{studentUsername}")
    public ResponseEntity<List<Grade>> getStudentGradeFromToDate(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr,
            @PathVariable("studentUsername") String studentUserName
    ) {
        // Преобразование строки в LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);


        // Ваша логика обработки дат
    }
}
