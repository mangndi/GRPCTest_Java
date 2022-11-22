package com.equity;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * service yang dipakai server gateway ke backend (DB Service)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: clientservice.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DBServiceGrpc {

  private DBServiceGrpc() {}

  public static final String SERVICE_NAME = "equity.DBService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.equity.RequestPE,
      com.equity.ResponsePE> getGetPortfolioEquityDBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPortfolioEquityDB",
      requestType = com.equity.RequestPE.class,
      responseType = com.equity.ResponsePE.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.RequestPE,
      com.equity.ResponsePE> getGetPortfolioEquityDBMethod() {
    io.grpc.MethodDescriptor<com.equity.RequestPE, com.equity.ResponsePE> getGetPortfolioEquityDBMethod;
    if ((getGetPortfolioEquityDBMethod = DBServiceGrpc.getGetPortfolioEquityDBMethod) == null) {
      synchronized (DBServiceGrpc.class) {
        if ((getGetPortfolioEquityDBMethod = DBServiceGrpc.getGetPortfolioEquityDBMethod) == null) {
          DBServiceGrpc.getGetPortfolioEquityDBMethod = getGetPortfolioEquityDBMethod =
              io.grpc.MethodDescriptor.<com.equity.RequestPE, com.equity.ResponsePE>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPortfolioEquityDB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.RequestPE.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.ResponsePE.getDefaultInstance()))
              .setSchemaDescriptor(new DBServiceMethodDescriptorSupplier("getPortfolioEquityDB"))
              .build();
        }
      }
    }
    return getGetPortfolioEquityDBMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DBServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DBServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DBServiceStub>() {
        @java.lang.Override
        public DBServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DBServiceStub(channel, callOptions);
        }
      };
    return DBServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DBServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DBServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DBServiceBlockingStub>() {
        @java.lang.Override
        public DBServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DBServiceBlockingStub(channel, callOptions);
        }
      };
    return DBServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DBServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DBServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DBServiceFutureStub>() {
        @java.lang.Override
        public DBServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DBServiceFutureStub(channel, callOptions);
        }
      };
    return DBServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * service yang dipakai server gateway ke backend (DB Service)
   * </pre>
   */
  public static abstract class DBServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPortfolioEquityDB(com.equity.RequestPE request,
        io.grpc.stub.StreamObserver<com.equity.ResponsePE> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPortfolioEquityDBMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPortfolioEquityDBMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.RequestPE,
                com.equity.ResponsePE>(
                  this, METHODID_GET_PORTFOLIO_EQUITY_DB)))
          .build();
    }
  }

  /**
   * <pre>
   * service yang dipakai server gateway ke backend (DB Service)
   * </pre>
   */
  public static final class DBServiceStub extends io.grpc.stub.AbstractAsyncStub<DBServiceStub> {
    private DBServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DBServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DBServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPortfolioEquityDB(com.equity.RequestPE request,
        io.grpc.stub.StreamObserver<com.equity.ResponsePE> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetPortfolioEquityDBMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * service yang dipakai server gateway ke backend (DB Service)
   * </pre>
   */
  public static final class DBServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DBServiceBlockingStub> {
    private DBServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DBServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DBServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.equity.ResponsePE> getPortfolioEquityDB(
        com.equity.RequestPE request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetPortfolioEquityDBMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * service yang dipakai server gateway ke backend (DB Service)
   * </pre>
   */
  public static final class DBServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DBServiceFutureStub> {
    private DBServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DBServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DBServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_PORTFOLIO_EQUITY_DB = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DBServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DBServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PORTFOLIO_EQUITY_DB:
          serviceImpl.getPortfolioEquityDB((com.equity.RequestPE) request,
              (io.grpc.stub.StreamObserver<com.equity.ResponsePE>) responseObserver);
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

  private static abstract class DBServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DBServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.equity.Clientservice.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DBService");
    }
  }

  private static final class DBServiceFileDescriptorSupplier
      extends DBServiceBaseDescriptorSupplier {
    DBServiceFileDescriptorSupplier() {}
  }

  private static final class DBServiceMethodDescriptorSupplier
      extends DBServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DBServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DBServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DBServiceFileDescriptorSupplier())
              .addMethod(getGetPortfolioEquityDBMethod())
              .build();
        }
      }
    }
    return result;
  }
}
