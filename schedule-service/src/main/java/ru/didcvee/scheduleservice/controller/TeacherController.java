package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.Teacher;
import ru.didcvee.scheduleservice.service.SubjectService;
import ru.didcvee.scheduleservice.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    @Autowired
    public TeacherController(TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(
            @PathVariable("id") int id
    ) {
        return ResponseEntity.ok().body(teacherService.getTeacherById(id));
    }
    @GetMapping
    public ResponseEntity<List<Teacher>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(teacherService.getAllTeachersWithSubjects(page, size));
    }
    @PatchMapping("/id")
    public ResponseEntity<?> updateTeacherWithSubject(
            @PathVariable("id") int id,
            @RequestBody Teacher teacher
    ){
        teacher.setId(id);
        if (!teacher.getSubjects().isEmpty()) {
            teacherService.updateTeacherWithSubjects(teacher);
        } else {
            teacherService.updateTeacher(teacher);
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<?> createTeacherWithSubject(
            @RequestBody Teacher teacher
    ) {
        if (!teacher.getSubjects().isEmpty()) {
            teacherService.insertTeacherWithSubjects(teacher);
        } else {
            teacherService.createTeacher(teacher);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
        @PathVariable("id") int id
    ) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }




}
