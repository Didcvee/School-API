package ru.didcvee.diaryservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.entity.Mark;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper gradeDtoRowMapper = (rs, rowNum) -> {
        GradeDto gradeDto = new GradeDto();
        gradeDto.setTeacherUsername(rs.getString("teacherusername"));
        gradeDto.setStudentUsername("studentusername");
        gradeDto.setSubjectName(rs.getString("subject"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        gradeDto.setTimeFrom(LocalDateTime.parse(rs.getString("dateFrom"), formatter));
        gradeDto.setTimeTo(LocalDateTime.parse(rs.getString("dateto"), formatter));
        gradeDto.setWeekDay(rs.getString("weekday"));
        gradeDto.setMark(Mark.valueOf(rs.getString("mark")));
        return gradeDto;
    };
    public List<GradeDto> getStudentGradeFromTo(LocalDateTime dateFrom, LocalDateTime dateTo, String studentUsername) {
        String sql = "select * from grade where datefrom>? and datefrom<? and studentusername=?";
        try {
            return jdbcTemplate.query(sql, gradeDtoRowMapper);
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }
    //GRPC
    public List<GradeDto> getTeacherGradeByGroupAndSubject() {
        String sql = "select * from grade where subject datefrom dateto teacherusername group";
        try {
            return jdbcTemplate.query(sql, gradeDtoRowMapper);
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }
    }

}
