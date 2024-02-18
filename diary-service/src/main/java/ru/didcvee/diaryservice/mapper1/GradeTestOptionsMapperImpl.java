package ru.didcvee.diaryservice.mapper1;

import org.springframework.stereotype.Component;
import ru.didcvee.diaryservice.dto.GradeTestOptionsDto;
import ru.didcvee.diaryservice.entity.test.GradeTestOptions;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class GradeTestOptionsMapperImpl implements GradeTestOptionsMapper{
    @Override
    public GradeTestOptions toEntity(GradeTestOptionsDto dto) {
        GradeTestOptions entity = new GradeTestOptions();
        entity.setDelayInSeconds(dto.getDelayInSeconds());
        entity.setMark(dto.getMark());
        // map other properties as needed
        return entity;
    }

    @Override
    public List<GradeTestOptions> toEntity(List<GradeTestOptionsDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public GradeTestOptionsDto toDto(GradeTestOptions entity) {
        GradeTestOptionsDto dto = new GradeTestOptionsDto();
        dto.setDelayInSeconds(entity.getDelayInSeconds());
        dto.setMark(entity.getMark());
        // map other properties as needed
        return dto;
    }

    @Override
    public List<GradeTestOptionsDto> toDto(List<GradeTestOptions> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
