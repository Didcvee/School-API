package ru.didcvee.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.GradeRequest;
import ru.didcvee.scheduleservice.service.GRPCGradeService;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GRPCGradeService gradeService;
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getGradeById(
            @PathVariable("id") long id
    ) {
        Grade grade = gradeService.get(new GradeRequest(id));
        return ResponseEntity.ok().body(grade);
    }
}
