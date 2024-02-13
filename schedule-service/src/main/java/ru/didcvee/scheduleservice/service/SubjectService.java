package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.repo.SubjectRepo;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SubjectService {
    private final SubjectRepo subjectRepo;
    @Autowired
    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public Subject findById(String subject){
        Optional<Subject> subjectFromDb = subjectRepo.findBySubjectName(subject);
        if (subjectFromDb.isEmpty()) {
            throw new RuntimeException(subjectFromDb + "not found");
        }
        return subjectFromDb.get();
    }

    public Page<Subject> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return subjectRepo.findAll(pageable);
    }
}
