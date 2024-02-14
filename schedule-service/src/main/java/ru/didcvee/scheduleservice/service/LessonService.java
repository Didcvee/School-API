package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.dto.LessonDto;
import ru.didcvee.scheduleservice.entity.Lesson;

@Service
@Transactional(readOnly = true)
public class LessonService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public LessonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional
    public void saveLesson(LessonDto lesson) {
        String sql = "INSERT INTO lesson (lesson_number, week_day, subject_name, group_number, teacher_id) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, lesson.getWeekDay(), lesson.getSubject(), lesson.getGroupNumber(), lesson.getTeacherId());
        } catch (DataAccessException e) {
            // Обработка ошибки при сохранении занятия
            System.err.println("Ошибка при сохранении занятия: " + e.getMessage());
        }
    }
}
