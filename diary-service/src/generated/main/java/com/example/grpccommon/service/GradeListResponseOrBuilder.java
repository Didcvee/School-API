// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package com.example.grpccommon.service;

public interface GradeListResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service.GradeListResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .service.GRPCGrade grades = 1;</code>
   */
  java.util.List<com.example.grpccommon.service.GRPCGrade> 
      getGradesList();
  /**
   * <code>repeated .service.GRPCGrade grades = 1;</code>
   */
  com.example.grpccommon.service.GRPCGrade getGrades(int index);
  /**
   * <code>repeated .service.GRPCGrade grades = 1;</code>
   */
  int getGradesCount();
  /**
   * <code>repeated .service.GRPCGrade grades = 1;</code>
   */
  java.util.List<? extends com.example.grpccommon.service.GRPCGradeOrBuilder> 
      getGradesOrBuilderList();
  /**
   * <code>repeated .service.GRPCGrade grades = 1;</code>
   */
  com.example.grpccommon.service.GRPCGradeOrBuilder getGradesOrBuilder(
      int index);
}
