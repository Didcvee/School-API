package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public TeacherService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (firstname, lastname, patronymic, age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, teacher.getFirstname(), teacher.getLastname(), teacher.getPatronymic(), teacher.getAge());
    }

    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE teacher SET firstname = ?, lastname = ?, patronymic = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, teacher.getFirstname(), teacher.getLastname(), teacher.getPatronymic(), teacher.getAge(), teacher.getId());
    }

    public void deleteTeacher(int teacherId) {
        String sql = "DELETE FROM teacher WHERE id = ?";
        jdbcTemplate.update(sql, teacherId);
    }

    public Teacher getTeacherById(int teacherId) {
        String sql = "SELECT t.id, t.firstname, t.lastname, t.patronymic, t.age, s.subject_name " +
                "FROM teacher t " +
                "LEFT JOIN teacher_subject ts ON t.id = ts.teacher_id " +
                "LEFT JOIN subject s ON ts.subject_name = s.subject_name " +
                "WHERE t.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{teacherId}, teacherRowMapper);
    }

    public List<Teacher> getAllTeachersWithSubjects(int pageNumber, int pageSize) {
        String sql = "SELECT t.id, t.firstname, t.lastname, t.patronymic, t.age, s.subject_name " +
                "FROM teacher t " +
                "LEFT JOIN teacher_subject ts ON t.id = ts.teacher_id " +
                "LEFT JOIN subject s ON ts.subject_name = s.subject_name " +
                "ORDER BY t.id LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[]{pageSize, (pageNumber - 1) * pageSize}, teacherRowMapper);
    }

    private final RowMapper<Teacher> teacherRowMapper = (rs, rowNum) -> {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id"));
        teacher.setFirstname(rs.getString("firstname"));
        teacher.setLastname(rs.getString("lastname"));
        teacher.setPatronymic(rs.getString("patronymic"));
        teacher.setAge(rs.getInt("age"));

        // Создание списка предметов для учителя
        List<Subject> subjects = new ArrayList<>();
        do {
            String subjectName = rs.getString("subject_name");
            if (subjectName != null) {
                Subject subject = new Subject();
                subject.setSubjectName(subjectName);
                subjects.add(subject);
            }
        } while (rs.next());

        teacher.setSubjects(subjects);

        return teacher;
    };

}
