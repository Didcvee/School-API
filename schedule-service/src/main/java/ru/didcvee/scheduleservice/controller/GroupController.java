package ru.didcvee.scheduleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.repo.GroupRepo;
import ru.didcvee.scheduleservice.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
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
}
