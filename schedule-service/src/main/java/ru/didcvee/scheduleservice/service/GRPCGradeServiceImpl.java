package ru.didcvee.scheduleservice.service;

import com.example.grpccommon.GRPCGrade;
import com.example.grpccommon.GradeServerGrpc;
import com.example.grpccommon.GrpcGradeRequest;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.didcvee.scheduleservice.entity.other.Grade;
import ru.didcvee.scheduleservice.entity.other.GradeRequest;

@Service
@RequiredArgsConstructor
public class GRPCGradeServiceImpl implements GRPCGradeService{

    @GrpcClient(value = "grade-blocking")
    private GradeServerGrpc.GradeServerBlockingStub stub;
    @GrpcClient(value = "grade-async")
    private GradeServerGrpc.GradeServerStub asyncStub;


    @Override
    public Grade get(GradeRequest gradeRequest) {
        GrpcGradeRequest request = GrpcGradeRequest.newBuilder()
                .setId(gradeRequest.getId())
                .build();
        GRPCGrade grade = stub.getGrade(request);
        Grade grade1 = new Grade(Integer.parseInt(String.valueOf(grade.getId())), grade.getMark());
        System.out.println(grade1);
        return grade1;
    }
}
