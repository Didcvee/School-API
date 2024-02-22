package ru.didcvee.diaryservice.service;

import com.example.grpccommon.service.*;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.didcvee.diaryservice.entity.Grade;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
@RequiredArgsConstructor
public class GRPCGradeService extends GradeServerGrpc.GradeServerImplBase {
    private final GradeService gradeService;

    @Override
    public void getGradeFromStudentByDateFromDateTo(GrpcGradeRequestFromStudent request,
                                                    StreamObserver<GradeListResponse> responseObserver) {

        GradeListResponse gradeListResponse = GradeListResponse.newBuilder()
                .addAllGrades(getGrpcGradeList(
                        gradeService.getGradeByStudentIdDateFromDateTo(
                                request.getStudentUsername(),
                                request.getDateFrom(),
                                request.getDateTo())
                ))
                .build();

        responseObserver.onNext(gradeListResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getGradeFromTeacherByGroupAndSubjectDateFromDateTo(GrpcGradeRequestFromTeacher request,
                                                                   StreamObserver<GradeListResponse> responseObserver) {
        GradeListResponse gradeListResponse = GradeListResponse.newBuilder()
                .addAllGrades(getGrpcGradeList(
                        gradeService.getGradeByTeacherHisGroupAndSubjectDateFromDateTo(
                                request.getTeacherUsername(),
                                request.getSubject(),
                                request.getGroup(),
                                request.getDateFrom(),
                                request.getDateTo())
                ))
                .build();

        responseObserver.onNext(gradeListResponse);
        responseObserver.onCompleted();
    }

    public static List<GRPCGrade> getGrpcGradeList(List<Grade> gradeList) {
        return gradeList.stream().map(grade -> GRPCGrade.newBuilder()
                        .setMark(grade.getMark().name())
                        .setDate(convert(grade.getDate()))
                        .setStudentUsername(grade.getStudentUsername())
                        .setSubjectName(grade.getSubject())
                        .setTeacherUsername(grade.getTeacherUsername())
                        .setTimeFrom(convert(grade.getTimeFrom()))
                        .setWeekDay(grade.getWeekDay())
                        .setObjectId(grade.get_id().toString())
                        .setGroupNumber(grade.getGroupNumber())
                        .build())
                .collect(Collectors.toList());
    }

    public static Timestamp convert(LocalDateTime localDateTime) {
        long seconds = localDateTime.toEpochSecond(ZoneOffset.UTC);
        int nanos = localDateTime.getNano();
        return Timestamp.newBuilder()
                .setSeconds(seconds)
                .setNanos(nanos)
                .build();
    }

}
