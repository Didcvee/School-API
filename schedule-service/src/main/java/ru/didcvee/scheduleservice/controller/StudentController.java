package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.dto.StudentDto;
import ru.didcvee.scheduleservice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        List<StudentDto> students = studentService.getAllStudents(size, page);
        return ResponseEntity.ok().body(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(
            @PathVariable("id") int id
    ){
        StudentDto student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }
    @PostMapping
    public ResponseEntity<?> saveStudent(
            @RequestBody StudentDto studentDto
    ) {
        studentService.saveStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable("id") int id,
            @RequestBody StudentDto studentDto
    ) {
        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable("id") int id
    ) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
