package ru.didcvee.scheduleservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupDto {
    public int groupNumber;
    public List<LessonDto> lessons;
}
