package ru.didcvee.scheduleservice.service;

import com.example.grpccommon.service.GradeListResponse;
import com.example.grpccommon.service.GradeServerGrpc;
import com.example.grpccommon.service.GrpcGradeRequestFromStudent;
import com.example.grpccommon.service.GrpcGradeRequestFromTeacher;
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
    public GradeListResponse getGradeByTeacherUsername(String teacherUsername,
                                                       Timestamp dateFrom,
                                                       Timestamp dateTo,
                                                       String subject,
                                                       String groupNumber) {
        GrpcGradeRequestFromTeacher request = GrpcGradeRequestFromTeacher.newBuilder()
                .setTeacherUsername(teacherUsername)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .setSubject(subject)
                .setGroup(groupNumber)
                .build();
        return stub.getGradeFromTeacherByGroupAndSubjectDateFromDateTo(request);
    }

    @Override
    public GradeListResponse getGradeByStudentUsername(String studentUsername,
                                 Timestamp dateFrom,
                                 Timestamp dateTo) {
        GrpcGradeRequestFromStudent request = GrpcGradeRequestFromStudent.newBuilder()
                .setStudentUsername(studentUsername)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .build();
        return stub.getGradeFromStudentByDateFromDateTo(request);
    }
}
