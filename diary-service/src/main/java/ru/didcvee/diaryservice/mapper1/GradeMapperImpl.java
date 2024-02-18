package ru.didcvee.diaryservice.mapper1;

import org.springframework.stereotype.Component;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.entity.Grade;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public Grade toEntity(GradeDto dto) {
        Grade entity = new Grade();
        entity.setId(dto.getId());
        entity.setMark(dto.getMark());
        entity.setWeekDay(dto.getWeekDay());
        entity.setTeacherUsername(dto.getTeacherUsername());
        entity.setTimeFrom(dto.getTimeFrom());
        entity.setSubjectName(dto.getSubjectName());
        // map other properties as needed
        return entity;
    }

    @Override
    public List<Grade> toEntity(List<GradeDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public GradeDto toDto(Grade entity) {
        GradeDto dto = new GradeDto();
        dto.setId(entity.getId());
        dto.setMark(entity.getMark());
        dto.setWeekDay(entity.getWeekDay());
        dto.setTimeFrom(entity.getTimeFrom());
        dto.setSubjectName(dto.getSubjectName());
        dto.setTeacherUsername(dto.getTeacherUsername());
        // map other properties as needed
        return dto;
    }

    @Override
    public List<GradeDto> toDto(List<Grade> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

}
