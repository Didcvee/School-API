// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package com.example.grpccommon.service;

public final class GeneratorProto {
  private GeneratorProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service_GRPCGrade_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service_GRPCGrade_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service_GrpcGradeRequestFromStudent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service_GrpcGradeRequestFromStudent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service_GradeListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service_GradeListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service_GrpcGradeRequestFromTeacher_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service_GrpcGradeRequestFromTeacher_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014common.proto\022\007service\032\037google/protobuf" +
      "/timestamp.proto\"\202\002\n\tGRPCGrade\022\020\n\010lesson" +
      "Id\030\006 \001(\003\022\020\n\010objectId\030\001 \001(\t\022\027\n\017teacherUse" +
      "rname\030\002 \001(\t\022\014\n\004mark\030\003 \001(\t\022\027\n\017studentUser" +
      "name\030\004 \001(\t\022,\n\010timeFrom\030\t \001(\0132\032.google.pr" +
      "otobuf.Timestamp\022(\n\004date\030\005 \001(\0132\032.google." +
      "protobuf.Timestamp\022\023\n\013groupNumber\030\n \001(\t\022" +
      "\023\n\013subjectName\030\007 \001(\t\022\017\n\007weekDay\030\010 \001(\t\"\220\001" +
      "\n\033GrpcGradeRequestFromStudent\022\027\n\017student" +
      "Username\030\001 \001(\t\022,\n\010dateFrom\030\002 \001(\0132\032.googl" +
      "e.protobuf.Timestamp\022*\n\006dateTo\030\003 \001(\0132\032.g" +
      "oogle.protobuf.Timestamp\"7\n\021GradeListRes" +
      "ponse\022\"\n\006grades\030\001 \003(\0132\022.service.GRPCGrad" +
      "e\"\260\001\n\033GrpcGradeRequestFromTeacher\022\027\n\017tea" +
      "cherUsername\030\001 \001(\t\022,\n\010dateFrom\030\002 \001(\0132\032.g" +
      "oogle.protobuf.Timestamp\022*\n\006dateTo\030\003 \001(\013" +
      "2\032.google.protobuf.Timestamp\022\017\n\007subject\030" +
      "\004 \001(\t\022\r\n\005group\030\005 \001(\t2\356\001\n\013GradeServer\022g\n#" +
      "GetGradeFromStudentByDateFromDateTo\022$.se" +
      "rvice.GrpcGradeRequestFromStudent\032\032.serv" +
      "ice.GradeListResponse\022v\n2GetGradeFromTea" +
      "cherByGroupAndSubjectDateFromDateTo\022$.se" +
      "rvice.GrpcGradeRequestFromTeacher\032\032.serv" +
      "ice.GradeListResponseB8\n\036com.example.grp" +
      "ccommon.serviceB\016GeneratorProtoP\001\242\002\003RTGb" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_service_GRPCGrade_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service_GRPCGrade_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service_GRPCGrade_descriptor,
        new java.lang.String[] { "LessonId", "ObjectId", "TeacherUsername", "Mark", "StudentUsername", "TimeFrom", "Date", "GroupNumber", "SubjectName", "WeekDay", });
    internal_static_service_GrpcGradeRequestFromStudent_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service_GrpcGradeRequestFromStudent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service_GrpcGradeRequestFromStudent_descriptor,
        new java.lang.String[] { "StudentUsername", "DateFrom", "DateTo", });
    internal_static_service_GradeListResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service_GradeListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service_GradeListResponse_descriptor,
        new java.lang.String[] { "Grades", });
    internal_static_service_GrpcGradeRequestFromTeacher_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service_GrpcGradeRequestFromTeacher_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service_GrpcGradeRequestFromTeacher_descriptor,
        new java.lang.String[] { "TeacherUsername", "DateFrom", "DateTo", "Subject", "Group", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
