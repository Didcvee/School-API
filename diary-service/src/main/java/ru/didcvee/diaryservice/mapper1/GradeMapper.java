package ru.didcvee.diaryservice.mapper1;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.didcvee.diaryservice.dto.GradeDto;
import ru.didcvee.diaryservice.entity.Grade;

@Mapper(componentModel = "spring")
public interface GradeMapper extends Mappable<Grade, GradeDto> {

}
