package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.Teacher;
import ru.didcvee.scheduleservice.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //TODO: можно добавить поиск и сортировку по имени, фамилии, возрасту

    @GetMapping
    public ResponseEntity<Page<Teacher>> getTeachers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Teacher> teachers = teacherService.findAll(page, size);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(
            @PathVariable("id") int id
    ){
        Teacher teacher = teacherService.getOne(id);
        return ResponseEntity.ok().body(teacher);
    }
    @PostMapping
    public ResponseEntity<?> saveTeacherWithSubject(
            @RequestBody Teacher teacher
    ){
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok().body(savedTeacher);
    }
}
