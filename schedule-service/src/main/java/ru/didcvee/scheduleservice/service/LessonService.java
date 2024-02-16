package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.dto.LessonDto;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.entity.Lesson;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LessonService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LessonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional
    public void saveLesson(List<LessonDto> lessons) {
        String sql = "INSERT INTO lesson (lesson_number, week_day, subject_name, group_number, teacher_id) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.batchUpdate(sql, getBatchToSave(lessons));
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }
    @Transactional
    public void updateLessons(List<LessonDto> lessons) {
        String sql = "UPDATE lesson SET lesson_number = ?, week_day = ?, subject_name = ?, group_number = ?, teacher_id = ? WHERE id = ?";
        try {
            jdbcTemplate.batchUpdate(sql,
                    getBatchToUpdate(lessons));
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }

    public BatchPreparedStatementSetter getBatchToUpdate(List<LessonDto> lessons) {
        return new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                LessonDto lesson = lessons.get(i);
                ps.setInt(1, lesson.getLessonNumber());
                ps.setString(2, lesson.getWeekDay());
                ps.setString(3, lesson.getSubject());
                ps.setInt(4, lesson.getGroupNumber());
                ps.setInt(5, lesson.getTeacherId());
                ps.setInt(6, lesson.getId());
            }

            @Override
            public int getBatchSize() {
                return lessons.size();
            }
        };

    }
    public BatchPreparedStatementSetter getBatchToSave(List<LessonDto> lessons) {
        return new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                LessonDto lesson = lessons.get(i);
                ps.setInt(1, lesson.getLessonNumber());
                ps.setString(2, lesson.getWeekDay());
                ps.setString(3, lesson.getSubject());
                ps.setInt(4, lesson.getGroupNumber());
                ps.setInt(5, lesson.getTeacherId());
            }

            @Override
            public int getBatchSize() {
                return lessons.size();
            }
        };

    }
}
