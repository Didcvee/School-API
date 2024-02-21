package ru.didcvee.diaryserviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.didcvee.diaryserviceconsumer.entity.Grade;
import ru.didcvee.diaryserviceconsumer.repo.GradeRepository;

@Service
public class KafkaGradeServiceImpl implements KafkaGradeService {
    private final GradeRepository gradeRepository;
    @Autowired
    public KafkaGradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void handle(Grade grade) {
        gradeRepository.saveGrade(grade);
    }
}
