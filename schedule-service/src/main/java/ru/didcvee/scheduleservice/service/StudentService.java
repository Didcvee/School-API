package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.dto.StudentDto;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<StudentDto> groupRowMapper = ((rs, rowNum) -> {
        StudentDto student = new StudentDto();
        student.setId(rs.getInt("id"));
        student.setFirstname(rs.getString("firstname"));
        student.setLastname(rs.getString("lastname"));
        student.setPatronymic(rs.getString("patronymic"));
        student.setAge(rs.getInt("age"));
        student.setGroupNumber(rs.getInt("group_number"));
        return student;
    });

    public List<StudentDto> getAllStudents(int pageSize, int pageNumber) {
        try {
            int offset = pageNumber * pageSize;
            return jdbcTemplate.query("SELECT * FROM student LIMIT ? OFFSET ?", new Object[]{pageSize, offset}, groupRowMapper);
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }

    // Получение студента по идентификатору
    public StudentDto getStudentById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", new Object[]{id},
                    groupRowMapper);
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }

    // Сохранение студента
    @Transactional
    public void saveStudent(StudentDto student) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO student (firstname, lastname, patronymic, age, group_number) VALUES (?, ?, ?, ?, ?)",
                        new String[]{"id"});
                ps.setString(1, student.getFirstname());
                ps.setString(2, student.getLastname());
                ps.setString(3, student.getPatronymic());
                ps.setInt(4, student.getAge());
                ps.setInt(5, student.getGroupNumber());
                return ps;
            }, keyHolder);
            student.setId(keyHolder.getKey().intValue());
        } catch (DataAccessException e) {
            // Обработка ошибок при сохранении
            e.printStackTrace();
        }
    }

    // Удаление студента по идентификатору
    @Transactional
    public void deleteStudent(int id) {
        try {
            jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
        } catch (DataAccessException e) {
            // Обработка ошибок при удалении
            e.printStackTrace();
        }
    }

    // Обновление информации о студенте
    @Transactional
    public void updateStudent(StudentDto student) {
        try {
            jdbcTemplate.update(
                    "UPDATE student SET firstname = ?, lastname = ?, patronymic = ?, age = ?, group_number = ? WHERE id = ?",
                    student.getFirstname(), student.getLastname(), student.getPatronymic(), student.getAge(),
                    student.getGroupNumber(), student.getId());
        } catch (DataAccessException e) {
            // Обработка ошибок при обновлении
            e.printStackTrace();
        }
    }
}

