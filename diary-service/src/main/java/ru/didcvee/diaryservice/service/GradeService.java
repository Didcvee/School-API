package ru.didcvee.diaryservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.entity.GradeTest;
import ru.didcvee.diaryservice.entity.Mark;
import ru.didcvee.diaryservice.repo.GradeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getGradeByStudentIdDateFromDateTo(String studentUsername,
                                                         LocalDateTime dateFrom,
                                                         LocalDateTime dateTo) {
        return gradeRepository.getGradeByStudentIdDateFromDateTo(studentUsername, dateFrom, dateTo);
    }

    public List<Grade> getGradeByTeacherHisGroupAndSubjectDateFromDateTo(String teacherUsername,
                                                                         String subject,
                                                                         int groupNumber,
                                                                         LocalDateTime dateFrom,
                                                                         LocalDateTime dateTo) {
        return gradeRepository.getGradeByTeacherHisGroupAndSubjectDateFromDateTo(teacherUsername, subject, groupNumber, dateFrom, dateTo);
    }
}
