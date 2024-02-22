package ru.didcvee.diaryservice.repo;

import com.google.protobuf.Timestamp;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.didcvee.diaryservice.entity.Grade;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
    public List<Grade> findGradeByStudentAndTimeRange(String studentUsername, Timestamp startTime, Timestamp endTime) {
        Query query = new Query()
                .addCriteria(Criteria
                        .where("studentUsername").is(studentUsername)
                .and("date")
                        .gte(convert(startTime))
                        .lt(convert(endTime)));

        return mongoTemplate.find(query, Grade.class);
    }


    public List<Grade> getGradeByTeacherHisGroupAndSubjectDateFromDateTo(String teacherUsername,
                                                                         String subject,
                                                                         String groupNumber,
                                                                         Timestamp startTime,
                                                                         Timestamp endTime) {
        Query query = new Query(Criteria.where("teacherUsername").is(teacherUsername)
                .and("subject").is(subject)
                .and("groupNumber").is(groupNumber)
                .and("date").gte(convert(startTime)).lte(convert(endTime)));

        return mongoTemplate.find(query, Grade.class);
    }
    public static Date convert(Timestamp timestamp) {
        long milliseconds = (timestamp.getSeconds() * 1000) + (timestamp.getNanos() / 1000000);
        return new Date(milliseconds);
    }

}
