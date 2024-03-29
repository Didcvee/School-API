// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package com.example.grpccommon.service;

public interface GRPCGradeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service.GRPCGrade)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 lessonId = 6;</code>
   * @return The lessonId.
   */
  long getLessonId();

  /**
   * <code>string objectId = 1;</code>
   * @return The objectId.
   */
  java.lang.String getObjectId();
  /**
   * <code>string objectId = 1;</code>
   * @return The bytes for objectId.
   */
  com.google.protobuf.ByteString
      getObjectIdBytes();

  /**
   * <code>string teacherUsername = 2;</code>
   * @return The teacherUsername.
   */
  java.lang.String getTeacherUsername();
  /**
   * <code>string teacherUsername = 2;</code>
   * @return The bytes for teacherUsername.
   */
  com.google.protobuf.ByteString
      getTeacherUsernameBytes();

  /**
   * <code>string mark = 3;</code>
   * @return The mark.
   */
  java.lang.String getMark();
  /**
   * <code>string mark = 3;</code>
   * @return The bytes for mark.
   */
  com.google.protobuf.ByteString
      getMarkBytes();

  /**
   * <code>string studentUsername = 4;</code>
   * @return The studentUsername.
   */
  java.lang.String getStudentUsername();
  /**
   * <code>string studentUsername = 4;</code>
   * @return The bytes for studentUsername.
   */
  com.google.protobuf.ByteString
      getStudentUsernameBytes();

  /**
   * <code>.google.protobuf.Timestamp timeFrom = 9;</code>
   * @return Whether the timeFrom field is set.
   */
  boolean hasTimeFrom();
  /**
   * <code>.google.protobuf.Timestamp timeFrom = 9;</code>
   * @return The timeFrom.
   */
  com.google.protobuf.Timestamp getTimeFrom();
  /**
   * <code>.google.protobuf.Timestamp timeFrom = 9;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimeFromOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   * @return Whether the date field is set.
   */
  boolean hasDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   * @return The date.
   */
  com.google.protobuf.Timestamp getDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDateOrBuilder();

  /**
   * <code>string groupNumber = 10;</code>
   * @return The groupNumber.
   */
  java.lang.String getGroupNumber();
  /**
   * <code>string groupNumber = 10;</code>
   * @return The bytes for groupNumber.
   */
  com.google.protobuf.ByteString
      getGroupNumberBytes();

  /**
   * <code>string subjectName = 7;</code>
   * @return The subjectName.
   */
  java.lang.String getSubjectName();
  /**
   * <code>string subjectName = 7;</code>
   * @return The bytes for subjectName.
   */
  com.google.protobuf.ByteString
      getSubjectNameBytes();

  /**
   * <code>string weekDay = 8;</code>
   * @return The weekDay.
   */
  java.lang.String getWeekDay();
  /**
   * <code>string weekDay = 8;</code>
   * @return The bytes for weekDay.
   */
  com.google.protobuf.ByteString
      getWeekDayBytes();
}
