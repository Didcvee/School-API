package ru.didcvee.scheduleservice.controller;

import com.example.grpccommon.service.GradeListResponse;
import com.google.protobuf.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.GradeRequest;
import ru.didcvee.scheduleservice.service.GRPCGradeService;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GRPCGradeService gradeService;
    @GetMapping("/{studentUsername}")
    @ResponseBody
    public ResponseEntity<?> getGradeById(
            @PathVariable("studentUsername") String studentUsername,
            @RequestParam(value = "dateFrom")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") String dateFrom1,
            @RequestParam(value = "dateTo")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") String dateTo1
    ) {
        Timestamp dateFrom = convertToTimestamp(LocalDateTime.parse(dateFrom1));
        Timestamp dateTo = convertToTimestamp(LocalDateTime.parse(dateTo1));
        GradeListResponse gradeListResponse = gradeService.get(studentUsername, dateFrom, dateTo);
        System.out.println(gradeListResponse);
        return ResponseEntity.ok().body(gradeListResponse);
    }

    private Timestamp convertToTimestamp(LocalDateTime dateTime) {
        long seconds = dateTime.toEpochSecond(ZoneOffset.UTC);
        int nanos = dateTime.getNano();
        return Timestamp.newBuilder()
                .setSeconds(seconds)
                .setNanos(nanos)
                .build();
    }
}
