package ru.didcvee.diaryserviceconsumer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.didcvee.diaryserviceconsumer.entity.Grade;

import java.time.LocalDateTime;

@Repository
public class GradeRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public GradeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveGrade(Grade grade) {
        grade.setTimeFrom(LocalDateTime.now());
        mongoTemplate.save(grade, "grade");
    }

}
