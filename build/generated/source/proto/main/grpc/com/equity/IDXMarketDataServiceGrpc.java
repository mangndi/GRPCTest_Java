package com.equity;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: marketdata.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IDXMarketDataServiceGrpc {

  private IDXMarketDataServiceGrpc() {}

  public static final String SERVICE_NAME = "equity.IDXMarketDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.equity.SubsProbeMD,
      com.equity.ResponseProbeMD> getGetProbeMDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProbeMD",
      requestType = com.equity.SubsProbeMD.class,
      responseType = com.equity.ResponseProbeMD.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.equity.SubsProbeMD,
      com.equity.ResponseProbeMD> getGetProbeMDMethod() {
    io.grpc.MethodDescriptor<com.equity.SubsProbeMD, com.equity.ResponseProbeMD> getGetProbeMDMethod;
    if ((getGetProbeMDMethod = IDXMarketDataServiceGrpc.getGetProbeMDMethod) == null) {
      synchronized (IDXMarketDataServiceGrpc.class) {
        if ((getGetProbeMDMethod = IDXMarketDataServiceGrpc.getGetProbeMDMethod) == null) {
          IDXMarketDataServiceGrpc.getGetProbeMDMethod = getGetProbeMDMethod =
              io.grpc.MethodDescriptor.<com.equity.SubsProbeMD, com.equity.ResponseProbeMD>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProbeMD"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.SubsProbeMD.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.ResponseProbeMD.getDefaultInstance()))
              .setSchemaDescriptor(new IDXMarketDataServiceMethodDescriptorSupplier("getProbeMD"))
              .build();
        }
      }
    }
    return getGetProbeMDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.SubsRunningTrades,
      com.equity.RunningTradesResponse> getSendSubsRunningTradesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendSubsRunningTrades",
      requestType = com.equity.SubsRunningTrades.class,
      responseType = com.equity.RunningTradesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.SubsRunningTrades,
      com.equity.RunningTradesResponse> getSendSubsRunningTradesMethod() {
    io.grpc.MethodDescriptor<com.equity.SubsRunningTrades, com.equity.RunningTradesResponse> getSendSubsRunningTradesMethod;
    if ((getSendSubsRunningTradesMethod = IDXMarketDataServiceGrpc.getSendSubsRunningTradesMethod) == null) {
      synchronized (IDXMarketDataServiceGrpc.class) {
        if ((getSendSubsRunningTradesMethod = IDXMarketDataServiceGrpc.getSendSubsRunningTradesMethod) == null) {
          IDXMarketDataServiceGrpc.getSendSubsRunningTradesMethod = getSendSubsRunningTradesMethod =
              io.grpc.MethodDescriptor.<com.equity.SubsRunningTrades, com.equity.RunningTradesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendSubsRunningTrades"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.SubsRunningTrades.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.RunningTradesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IDXMarketDataServiceMethodDescriptorSupplier("sendSubsRunningTrades"))
              .build();
        }
      }
    }
    return getSendSubsRunningTradesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IDXMarketDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceStub>() {
        @java.lang.Override
        public IDXMarketDataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXMarketDataServiceStub(channel, callOptions);
        }
      };
    return IDXMarketDataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IDXMarketDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceBlockingStub>() {
        @java.lang.Override
        public IDXMarketDataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXMarketDataServiceBlockingStub(channel, callOptions);
        }
      };
    return IDXMarketDataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IDXMarketDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXMarketDataServiceFutureStub>() {
        @java.lang.Override
        public IDXMarketDataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXMarketDataServiceFutureStub(channel, callOptions);
        }
      };
    return IDXMarketDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IDXMarketDataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProbeMD(com.equity.SubsProbeMD request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbeMD> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProbeMDMethod(), responseObserver);
    }

    /**
     */
    public void sendSubsRunningTrades(com.equity.SubsRunningTrades request,
        io.grpc.stub.StreamObserver<com.equity.RunningTradesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendSubsRunningTradesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProbeMDMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.equity.SubsProbeMD,
                com.equity.ResponseProbeMD>(
                  this, METHODID_GET_PROBE_MD)))
          .addMethod(
            getSendSubsRunningTradesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.SubsRunningTrades,
                com.equity.RunningTradesResponse>(
                  this, METHODID_SEND_SUBS_RUNNING_TRADES)))
          .build();
    }
  }

  /**
   */
  public static final class IDXMarketDataServiceStub extends io.grpc.stub.AbstractAsyncStub<IDXMarketDataServiceStub> {
    private IDXMarketDataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXMarketDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXMarketDataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getProbeMD(com.equity.SubsProbeMD request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbeMD> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProbeMDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSubsRunningTrades(com.equity.SubsRunningTrades request,
        io.grpc.stub.StreamObserver<com.equity.RunningTradesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendSubsRunningTradesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IDXMarketDataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IDXMarketDataServiceBlockingStub> {
    private IDXMarketDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXMarketDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXMarketDataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.equity.ResponseProbeMD getProbeMD(com.equity.SubsProbeMD request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProbeMDMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.equity.RunningTradesResponse> sendSubsRunningTrades(
        com.equity.SubsRunningTrades request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendSubsRunningTradesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IDXMarketDataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IDXMarketDataServiceFutureStub> {
    private IDXMarketDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXMarketDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXMarketDataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.equity.ResponseProbeMD> getProbeMD(
        com.equity.SubsProbeMD request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProbeMDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROBE_MD = 0;
  private static final int METHODID_SEND_SUBS_RUNNING_TRADES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IDXMarketDataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IDXMarketDataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROBE_MD:
          serviceImpl.getProbeMD((com.equity.SubsProbeMD) request,
              (io.grpc.stub.StreamObserver<com.equity.ResponseProbeMD>) responseObserver);
          break;
        case METHODID_SEND_SUBS_RUNNING_TRADES:
          serviceImpl.sendSubsRunningTrades((com.equity.SubsRunningTrades) request,
              (io.grpc.stub.StreamObserver<com.equity.RunningTradesResponse>) responseObserver);
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

  private static abstract class IDXMarketDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IDXMarketDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.equity.Marketdata.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IDXMarketDataService");
    }
  }

  private static final class IDXMarketDataServiceFileDescriptorSupplier
      extends IDXMarketDataServiceBaseDescriptorSupplier {
    IDXMarketDataServiceFileDescriptorSupplier() {}
  }

  private static final class IDXMarketDataServiceMethodDescriptorSupplier
      extends IDXMarketDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IDXMarketDataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IDXMarketDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IDXMarketDataServiceFileDescriptorSupplier())
              .addMethod(getGetProbeMDMethod())
              .addMethod(getSendSubsRunningTradesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
