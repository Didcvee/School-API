package ru.didcvee.diaryservice.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.didcvee.diaryservice.entity.Grade;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class GradeRepository {
    private final MongoTemplate mongoTemplate;
    @Autowired
    public GradeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public List<Grade> getGradeByStudentIdDateFromDateTo(String studentUsername,
                                                         LocalDateTime dateFrom,
                                                         LocalDateTime dateTo) {

        Query query = new Query(Criteria.where("studentUsername").is(studentUsername)
                .and("timeFrom").gte(dateFrom).lte(dateTo));

        return mongoTemplate.find(query, Grade.class);
    }


    public List<Grade> getGradeByTeacherHisGroupAndSubjectDateFromDateTo(String teacherUsername,
                                                                         String subject,
                                                                         int groupNumber,
                                                                         LocalDateTime dateFrom,
                                                                         LocalDateTime dateTo) {

        Query query = new Query(Criteria.where("teacherUsername").is(teacherUsername)
                .and("subjectName").is(subject)
                .and("groupNumber").is(groupNumber)
                .and("timeFrom").gte(dateFrom).lte(dateTo));

        return mongoTemplate.find(query, Grade.class);
    }

}
