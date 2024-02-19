package ru.didcvee.scheduleservice.service;

import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.GradeRequest;

public interface GRPCGradeService {
    Grade get(GradeRequest gradeRequest);
}
