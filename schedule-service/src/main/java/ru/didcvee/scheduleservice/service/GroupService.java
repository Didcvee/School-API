package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.entity.Group;
import ru.didcvee.scheduleservice.entity.Lesson;
import ru.didcvee.scheduleservice.entity.Subject;
import ru.didcvee.scheduleservice.entity.Teacher;
import ru.didcvee.scheduleservice.repo.GroupRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupService {
    private final GroupRepo groupRepo;
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Group> groupRowMapper = ((rs, rowNum) -> {
        Group group = new Group();
        group.setGroupNumber(rs.getInt("group_number"));
        return group;
    });
    @Autowired
    public GroupService(GroupRepo groupRepo, JdbcTemplate jdbcTemplate) {
        this.groupRepo = groupRepo;
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional(readOnly = true)
    public List<Group> findAll(int page, int size){
        int offset = page * size;
        String sql = "SELECT * FROM schedule.public.group_ OFFSET ? LIMIT ?";

        List<Group> groups = jdbcTemplate.query(sql, new Object[]{offset, size}, groupRowMapper);

        return groups;
    }
    @Transactional(readOnly = true)
    public Group findLessonsByGroupNumber(int groupNumber) {
        String sql = "SELECT l.id, l.lesson_number, l.week_day, l.subject_name, l.group_number, l.teacher_id, " +
                "t.firstname, t.lastname, t.patronymic, t.age, t.item_name " +
                "FROM lesson l " +
                "JOIN group_ g ON l.group_number = g.group_number " +
                "JOIN teacher t ON l.teacher_id = t.id " +
                "WHERE g.group_number = ?";

        List<Lesson> lessons = jdbcTemplate.query(sql, new Object[]{groupNumber}, (rs, rowNum) -> {
            Lesson lesson = new Lesson();
            Subject subject = new Subject();
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt("teacher_id"));
            Group group = new Group();
            group.setGroupNumber(rs.getInt("group_number"));
            subject.setSubjectName(rs.getString("subject_name"));
            lesson.setId(rs.getInt("id"));
            lesson.setLessonNumber(rs.getInt("lesson_number"));
            lesson.setWeekDay(rs.getString("week_day"));
            lesson.setSubject(subject);
            lesson.setGroup(group);
            lesson.setTeacher(teacher);

            Teacher teacher1 = new Teacher();
            teacher1.setFirstname(rs.getString("firstname"));
            teacher1.setLastname(rs.getString("lastname"));
            teacher1.setPatronymic(rs.getString("patronymic"));
            teacher1.setAge(rs.getInt("age"));
            teacher1.setSubject(subject);

            lesson.setTeacher(teacher1);
            return lesson;
        });

        if (lessons.isEmpty()) throw new RuntimeException();


        Group group = new Group();
        group.setLesson(lessons);
        group.setGroupNumber(lessons.get(0).getGroup().getGroupNumber());

        return group;
    }
}
