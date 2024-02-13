package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.entity.Teacher;
import ru.didcvee.scheduleservice.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getByName(@PathVariable("id") String name) {
        return ResponseEntity.ok().body(subjectService.findById(name));
    }
    @GetMapping
    public ResponseEntity<Page<Subject>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Subject> subjects = subjectService.findAll(page, size);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

}
