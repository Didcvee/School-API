package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.entity.Subject;

import java.util.ArrayList;
import java.util.List;

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
    private final RowMapper<Integer> mapper = ((rs, rowNum) -> rs.getInt("teacher_id"));
    private final RowMapper<Subject> subjectRowMapper = ((rs, rowNum) -> {
        Subject subject = new Subject();
        subject.setSubjectName(rs.getString("subject_name"));
        return subject;
    });

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
        String sql = "insert into subject(subject_name) values (?)";
        jdbcTemplate.update(sql, newSubjectName);

        String sql1 = "select t.teacher_id from teacher_subject t where subject_name = ?";
        List<Integer> teachersId = jdbcTemplate.query(sql1, mapper);

        String sql2= "delete from teacher_subject where subject_name = ?";
        jdbcTemplate.update(sql2, oldSubjectName);

        String insertWithTeacherAndSubject = "insert into teacher_subject(teacher_id, subject_name) values (?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for (Integer teacherId: teachersId) {
            Object[] args = new Object[]{teacherId, newSubjectName};
            batchArgs.add(args);
        }
        jdbcTemplate.batchUpdate(insertWithTeacherAndSubject, batchArgs);
    }

    public void deleteSubject(String subjectName) {
        String sql = "DELETE FROM subject WHERE subject_name = ?";

        try {
            jdbcTemplate.update(sql, subjectName);
        } catch (DataAccessException e) {
            // Обработка ошибок, например, логирование или выброс исключения
        }
    }
    @Transactional(readOnly = true)
    public List<Subject> getSubjects(int pageSize, int pageNumber) {
        String query = "SELECT subject_name FROM subject ORDER BY subject_name LIMIT ? OFFSET ?";

        int offset = pageNumber * pageSize;

        return jdbcTemplate.query(query, new Object[]{pageSize, offset}, subjectRowMapper);
    }
    @Transactional(readOnly = true)
    public List<Subject> getFilteredSubjects(int pageSize, int pageNumber, String search) {
        String query = "SELECT subject_name FROM subject WHERE subject_name LIKE ? ORDER BY subject_name LIMIT ? OFFSET ?";

        int offset = pageNumber * pageSize;

        String searchParam = "%" + search + "%";

        return jdbcTemplate.query(query, new Object[]{searchParam, pageSize, offset}, subjectRowMapper);
    }





}
