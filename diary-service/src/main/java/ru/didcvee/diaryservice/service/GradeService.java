package ru.didcvee.diaryservice.service;

import com.google.protobuf.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.repo.GradeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getGradeByStudentIdDateFromDateTo(String studentUsername,
                                                         Timestamp dateFrom,
                                                         Timestamp dateTo) {
        return gradeRepository.findGradeByStudentAndTimeRange(studentUsername, dateFrom, dateTo);
    }

    public List<Grade> getGradeByTeacherHisGroupAndSubjectDateFromDateTo(String teacherUsername,
                                                                         String subject,
                                                                         String groupNumber,
                                                                         Timestamp dateFrom,
                                                                         Timestamp dateTo) {
        return gradeRepository.getGradeByTeacherHisGroupAndSubjectDateFromDateTo(teacherUsername,
                subject,
                groupNumber,
                dateFrom,
                dateTo);
        }
}
