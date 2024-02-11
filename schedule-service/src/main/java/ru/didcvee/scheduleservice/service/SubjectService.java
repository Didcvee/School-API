package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.repo.SubjectRepo;

@Service
public class SubjectService {
    private final SubjectRepo subjectRepo;
    @Autowired
    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
    private Subject findById(){
        subjectRepo.findById()
    }
}
