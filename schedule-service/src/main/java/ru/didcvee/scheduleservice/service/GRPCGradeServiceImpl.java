package ru.didcvee.scheduleservice.service;

import com.example.grpccommon.service.GradeListResponse;
import com.example.grpccommon.service.GradeServerGrpc;
import com.example.grpccommon.service.GrpcGradeRequestFromStudent;
import com.google.protobuf.Timestamp;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GRPCGradeServiceImpl implements GRPCGradeService{

    @GrpcClient(value = "grade-blocking")
    private GradeServerGrpc.GradeServerBlockingStub stub;
    @GrpcClient(value = "grade-async")
    private GradeServerGrpc.GradeServerStub asyncStub;


    @Override
    public GradeListResponse get(String studentUsername, Timestamp dateFrom, Timestamp dateTo) {
        GrpcGradeRequestFromStudent request1 = GrpcGradeRequestFromStudent.newBuilder()
                .setStudentUsername("Artem")
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .build();
        return stub.getGradeFromStudentByDateFromDateTo(request1);
    }
}
