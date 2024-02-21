package ru.didcvee.diaryservice.service;

import com.example.grpccommon.service.*;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.didcvee.diaryservice.entity.Grade;
import ru.didcvee.diaryservice.entity.GradeTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class GRPCGradeService extends GradeServerGrpc.GradeServerImplBase {
    private final GradeService gradeService;

    @Override
    public void getGradeFromStudentByDateFromDateTo(GrpcGradeRequestFromStudent request,
                                                    StreamObserver<GradeListResponse> responseObserver) {
        Timestamp timestamp = request.getDateFrom();
        Timestamp timestamp1 = request.getDateTo();
        LocalDateTime dateFrom = LocalDateTime.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos(), ZoneOffset.UTC);
        LocalDateTime dateTo = LocalDateTime.ofEpochSecond(timestamp1.getSeconds(), timestamp1.getNanos(), ZoneOffset.UTC);
        List<Grade> gradeList = gradeService.getGradeByStudentIdDateFromDateTo(request.getStudentUsername(),
                dateFrom,
                dateTo);
        GradeListResponse gradeListResponse = GradeListResponse.newBuilder()
                        .addGrades()
                build();
        responseObserver.onNext();
    }

    @Override
    public void getGradeFromTeacherByGroupAndSubjectDateFromDateTo(GrpcGradeRequestFromTeacher request,
                                                                   StreamObserver<GradeListResponse> responseObserver) {
        super.getGradeFromTeacherByGroupAndSubjectDateFromDateTo(request, responseObserver);
    }


//    public void getGrade(GrpcGradeRequest request, StreamObserver<GRPCGrade> responseObserver) {
////        GradeTest grade = gradeService.getGradeByStudentIdDateFromDateTo()
////        GRPCGrade response = GRPCGrade.newBuilder()
////                .setId(grade.getId())
////                .setMark(grade.getMark())
////                .build();
////        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
}
