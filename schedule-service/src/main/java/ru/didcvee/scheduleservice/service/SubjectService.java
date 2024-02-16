package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SubjectService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createSubject(String subjectName) {
        String sql = "INSERT INTO subject (subject_name) VALUES (?)";

        try {
            jdbcTemplate.update(sql, subjectName);
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }

    @Transactional(readOnly = true)
    public String getSubjectByName(String subjectName) {
        String sql = "SELECT subject_name FROM subject WHERE subject_name = ?";

        try {
            return jdbcTemplate.queryForObject(sql, String.class, subjectName);
        } catch (EmptyResultDataAccessException e) {
            return null; // Если запись не найдена
        } catch (DataAccessException e) {
            // Обработка ошибок, например, логирование или выброс исключения
            return null;
        }
    }
    public void updateSubject(String oldSubjectName, String newSubjectName) {
        String sql = "UPDATE subject SET subject_name = ? WHERE subject_name = ?";
        try {
            jdbcTemplate.update(sql, newSubjectName, oldSubjectName);
        } catch (DataAccessException e) {
            // Обработка ошибок, например, логирование или выброс исключения
        }
    }

    public void deleteSubject(String subjectName) {
        String sql = "DELETE FROM subject WHERE subject_name = ?";

        try {
            jdbcTemplate.update(sql, subjectName);
        } catch (DataAccessException e) {
            // Обработка ошибок, например, логирование или выброс исключения
        }
    }



}
