package ru.didcvee.scheduleservice.service;

import com.example.grpccommon.service.GradeListResponse;
import com.google.protobuf.Timestamp;
import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.GradeRequest;

public interface GRPCGradeService {
    GradeListResponse get(String studentUsername, Timestamp dateFrom, Timestamp dateTo);
}
