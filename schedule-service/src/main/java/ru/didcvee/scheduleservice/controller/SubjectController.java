package ru.didcvee.scheduleservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
//    private final SubjectService subjectService;
//    @Autowired
//    public SubjectController(SubjectService subjectService) {
//        this.subjectService = subjectService;
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Subject> getByName(@PathVariable("id") String name) {
//        return ResponseEntity.ok().body(subjectService.findById(name));
//    }
//    @GetMapping
//    public ResponseEntity<Page<Subject>> findAll(@RequestParam(defaultValue = "0") int page,
//                                                 @RequestParam(defaultValue = "10") int size) {
//        Page<Subject> subjects = subjectService.findAll(page, size);
//        return new ResponseEntity<>(subjects, HttpStatus.OK);
//    }
//    @PostMapping
//    public ResponseEntity addSubject(
//            @RequestBody Subject subject
//    ){
//        subjectService
//    }

}
