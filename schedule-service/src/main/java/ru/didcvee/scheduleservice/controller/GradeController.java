package ru.didcvee.scheduleservice.controller;

import com.example.grpccommon.service.GradeListResponse;
import com.google.protobuf.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.Mark;
import ru.didcvee.scheduleservice.service.GRPCGradeService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GRPCGradeService gradeService;
    @GetMapping("/{studentUsername}")
    public ResponseEntity<?> getGradeById(
            @PathVariable("studentUsername") String studentUsername,
            @RequestParam(value = "dateFrom")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateFrom,
            @RequestParam(value = "dateTo")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTo
    ) {
        return getListGrade(gradeService.getGradeByStudentUsername(studentUsername,
                convertToTimestamp(dateFrom),
                convertToTimestamp(dateTo)));
    }

    @GetMapping("/teacher/{teacherUsername}")
    public ResponseEntity<?> getGradeByTeacherUsername(
            @PathVariable("teacherUsername") String teacherUsername,
            @RequestParam(value = "dateFrom")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateFrom,
            @RequestParam(value = "dateTo")
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTo,
            @RequestParam(value = "subjectName") String subjectName,
            @RequestParam(value = "groupName") String groupName
    ) {
        return getListGrade(gradeService.getGradeByTeacherUsername(teacherUsername, convertToTimestamp(dateFrom),
                convertToTimestamp(dateTo), subjectName, groupName));
    }

    public ResponseEntity<List<Grade>> getListGrade(GradeListResponse gradeListResponse) {
        return ResponseEntity.ok()
                .body(gradeListResponse.getGradesList()
                .stream()
                .map(grpcGrade -> {
            Grade grade = new Grade();
            grade.setMark(Mark.valueOf(grpcGrade.getMark()));
            grade.setStudentUsername(grpcGrade.getStudentUsername());
            grade.setTeacherUsername(grpcGrade.getTeacherUsername());
            grade.setDate(convert(grpcGrade.getDate()));
            grade.setSubject(grpcGrade.getSubjectName());
            grade.setObjectId(grpcGrade.getObjectId());
            grade.setTimeFrom(convert(grpcGrade.getTimeFrom()));
            grade.setWeekDay(grpcGrade.getWeekDay());
            grade.setGroupNumber(grpcGrade.getGroupNumber());
            return grade;
        }).collect(Collectors.toList()));
    }
    public static LocalDateTime convert(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        Instant instant = Instant.ofEpochSecond(seconds, nanos);
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
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
