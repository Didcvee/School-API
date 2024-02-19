package ru.didcvee.diaryservice.service;

import com.example.grpccommon.GRPCGrade;
import com.example.grpccommon.GradeServerGrpc;
import com.example.grpccommon.GrpcGradeRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.didcvee.diaryservice.entity.GradeTest;

@GrpcService
@RequiredArgsConstructor
public class GRPCGradeService extends GradeServerGrpc.GradeServerImplBase {
    private final GradeService gradeService;

    @Override
    public void getGrade(GrpcGradeRequest request, StreamObserver<GRPCGrade> responseObserver) {
        GradeTest grade = gradeService.getGradeById(request.getId());
        GRPCGrade response = GRPCGrade.newBuilder()
                .setId(grade.getId())
                .setMark(grade.getMark())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
