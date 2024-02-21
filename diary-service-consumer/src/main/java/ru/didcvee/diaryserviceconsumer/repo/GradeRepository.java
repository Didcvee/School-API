package ru.didcvee.diaryserviceconsumer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.didcvee.diaryserviceconsumer.entity.Grade;

@Repository
public class GradeRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public GradeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveGrade(Grade grade) {
        Grade save = mongoTemplate.save(grade, "grade");
        if(save == null) throw new RuntimeException();
    }

}
