package com.example.grpccommon;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: common.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GradeServerGrpc {

  private GradeServerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "service.GradeServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpccommon.GrpcGradeRequest,
      com.example.grpccommon.GRPCGrade> getGetGradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGrade",
      requestType = com.example.grpccommon.GrpcGradeRequest.class,
      responseType = com.example.grpccommon.GRPCGrade.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpccommon.GrpcGradeRequest,
      com.example.grpccommon.GRPCGrade> getGetGradeMethod() {
    io.grpc.MethodDescriptor<com.example.grpccommon.GrpcGradeRequest, com.example.grpccommon.GRPCGrade> getGetGradeMethod;
    if ((getGetGradeMethod = GradeServerGrpc.getGetGradeMethod) == null) {
      synchronized (GradeServerGrpc.class) {
        if ((getGetGradeMethod = GradeServerGrpc.getGetGradeMethod) == null) {
          GradeServerGrpc.getGetGradeMethod = getGetGradeMethod =
              io.grpc.MethodDescriptor.<com.example.grpccommon.GrpcGradeRequest, com.example.grpccommon.GRPCGrade>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGrade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpccommon.GrpcGradeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpccommon.GRPCGrade.getDefaultInstance()))
              .setSchemaDescriptor(new GradeServerMethodDescriptorSupplier("GetGrade"))
              .build();
        }
      }
    }
    return getGetGradeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GradeServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GradeServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GradeServerStub>() {
        @java.lang.Override
        public GradeServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GradeServerStub(channel, callOptions);
        }
      };
    return GradeServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GradeServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GradeServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GradeServerBlockingStub>() {
        @java.lang.Override
        public GradeServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GradeServerBlockingStub(channel, callOptions);
        }
      };
    return GradeServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GradeServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GradeServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GradeServerFutureStub>() {
        @java.lang.Override
        public GradeServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GradeServerFutureStub(channel, callOptions);
        }
      };
    return GradeServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getGrade(com.example.grpccommon.GrpcGradeRequest request,
        io.grpc.stub.StreamObserver<com.example.grpccommon.GRPCGrade> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGradeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GradeServer.
   */
  public static abstract class GradeServerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GradeServerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GradeServer.
   */
  public static final class GradeServerStub
      extends io.grpc.stub.AbstractAsyncStub<GradeServerStub> {
    private GradeServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GradeServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GradeServerStub(channel, callOptions);
    }

    /**
     */
    public void getGrade(com.example.grpccommon.GrpcGradeRequest request,
        io.grpc.stub.StreamObserver<com.example.grpccommon.GRPCGrade> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGradeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GradeServer.
   */
  public static final class GradeServerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GradeServerBlockingStub> {
    private GradeServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GradeServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GradeServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpccommon.GRPCGrade getGrade(com.example.grpccommon.GrpcGradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGradeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GradeServer.
   */
  public static final class GradeServerFutureStub
      extends io.grpc.stub.AbstractFutureStub<GradeServerFutureStub> {
    private GradeServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GradeServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GradeServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpccommon.GRPCGrade> getGrade(
        com.example.grpccommon.GrpcGradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGradeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GRADE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_GRADE:
          serviceImpl.getGrade((com.example.grpccommon.GrpcGradeRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpccommon.GRPCGrade>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetGradeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpccommon.GrpcGradeRequest,
              com.example.grpccommon.GRPCGrade>(
                service, METHODID_GET_GRADE)))
        .build();
  }

  private static abstract class GradeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GradeServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpccommon.GeneratorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GradeServer");
    }
  }

  private static final class GradeServerFileDescriptorSupplier
      extends GradeServerBaseDescriptorSupplier {
    GradeServerFileDescriptorSupplier() {}
  }

  private static final class GradeServerMethodDescriptorSupplier
      extends GradeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GradeServerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GradeServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GradeServerFileDescriptorSupplier())
              .addMethod(getGetGradeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
