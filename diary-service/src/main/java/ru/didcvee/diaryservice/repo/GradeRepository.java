package ru.didcvee.diaryservice.repo;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.didcvee.diaryservice.entity.Grade;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
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

        Date fromDate = Date.from(dateFrom.atZone(ZoneOffset.UTC).toInstant());
        Date toDate = Date.from(dateTo.atZone(ZoneOffset.UTC).toInstant());

        System.out.println(fromDate);

        Query query = new Query(Criteria.where("studentUsername").is(studentUsername)
                .andOperator(
                        Criteria.where("timeFrom.seconds").gte(fromDate.getTime() / 1000),
                        Criteria.where("timeFrom.seconds").lte(toDate.getTime() / 1000)
                ));

        System.out.println(query);

        List<Grade> documents = mongoTemplate.find(query, Grade.class);
        System.out.println(documents);
        return null;

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
