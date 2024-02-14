package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.dto.LessonDto;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.service.GroupService;
import ru.didcvee.scheduleservice.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final LessonService lessonService;
    @Autowired
    public GroupController(GroupService groupService, LessonService lessonService) {
        this.groupService = groupService;
        this.lessonService = lessonService;
    }
    @GetMapping
    public ResponseEntity<List<Group>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok().body(groupService.findAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Group> findById(
            @PathVariable("id") int name
    ){
        return ResponseEntity.ok().body(groupService.findLessonsByGroupNumber(name));
    }
    @PostMapping
    public ResponseEntity<?> addGroup(
            @RequestBody Group group,
            @RequestBody LessonDto lessonDto
    ){
        groupService.addGroup(group);

        if (lessonDto != null) lessonService.saveLesson(lessonDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
