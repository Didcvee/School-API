package ru.didcvee.diaryservice.mapper1;

import org.mapstruct.Mapper;
import ru.didcvee.diaryservice.dto.GradeTestOptionsDto;
import ru.didcvee.diaryservice.entity.test.GradeTestOptions;

@Mapper(componentModel = "spring")
public interface GradeTestOptionsMapper extends Mappable<GradeTestOptions, GradeTestOptionsDto> {

}
