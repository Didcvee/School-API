package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    public ResponseEntity<List<Subject>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok().body(subjectService.getSubjects(page, size));
    }
    @GetMapping("/{subjectName}")
    public ResponseEntity<Subject> findById(
            @PathVariable("subjectName") String subjectName
    ) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectService.getSubjectByName(subjectName));
        return ResponseEntity.ok().body(subject);
    }
    @PostMapping
    public ResponseEntity<?> createSubject(
        @RequestBody Subject subject) {
        subjectService.createSubject(subject.getSubjectName());
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{subjectName}")
    public ResponseEntity<Subject> updateById(
            @PathVariable("subjectName") String oldSubjectName,
            @RequestBody Subject subject
    ) {
        subjectService.updateSubject(oldSubjectName, subject.getSubjectName());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{subjectName}")
    public ResponseEntity<?> deleteSubject(
            @PathVariable("subjectName") String subjectName) {
        subjectService.deleteSubject(subjectName);
        return ResponseEntity.ok().build();
    }
}
