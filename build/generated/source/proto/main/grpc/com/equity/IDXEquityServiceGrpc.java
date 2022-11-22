package com.equity;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: equity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IDXEquityServiceGrpc {

  private IDXEquityServiceGrpc() {}

  public static final String SERVICE_NAME = "equity.IDXEquityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.equity.CreateNewOrder,
      com.equity.OrderResult> getSendNewOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendNewOrder",
      requestType = com.equity.CreateNewOrder.class,
      responseType = com.equity.OrderResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.equity.CreateNewOrder,
      com.equity.OrderResult> getSendNewOrderMethod() {
    io.grpc.MethodDescriptor<com.equity.CreateNewOrder, com.equity.OrderResult> getSendNewOrderMethod;
    if ((getSendNewOrderMethod = IDXEquityServiceGrpc.getSendNewOrderMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getSendNewOrderMethod = IDXEquityServiceGrpc.getSendNewOrderMethod) == null) {
          IDXEquityServiceGrpc.getSendNewOrderMethod = getSendNewOrderMethod =
              io.grpc.MethodDescriptor.<com.equity.CreateNewOrder, com.equity.OrderResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendNewOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.CreateNewOrder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.OrderResult.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("sendNewOrder"))
              .build();
        }
      }
    }
    return getSendNewOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.ReplaceOrder,
      com.equity.OrderResult> getSendReplaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendReplaceOrder",
      requestType = com.equity.ReplaceOrder.class,
      responseType = com.equity.OrderResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.ReplaceOrder,
      com.equity.OrderResult> getSendReplaceOrderMethod() {
    io.grpc.MethodDescriptor<com.equity.ReplaceOrder, com.equity.OrderResult> getSendReplaceOrderMethod;
    if ((getSendReplaceOrderMethod = IDXEquityServiceGrpc.getSendReplaceOrderMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getSendReplaceOrderMethod = IDXEquityServiceGrpc.getSendReplaceOrderMethod) == null) {
          IDXEquityServiceGrpc.getSendReplaceOrderMethod = getSendReplaceOrderMethod =
              io.grpc.MethodDescriptor.<com.equity.ReplaceOrder, com.equity.OrderResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendReplaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.ReplaceOrder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.OrderResult.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("sendReplaceOrder"))
              .build();
        }
      }
    }
    return getSendReplaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.CancelOrder,
      com.equity.OrderResult> getSendCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendCancelOrder",
      requestType = com.equity.CancelOrder.class,
      responseType = com.equity.OrderResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.CancelOrder,
      com.equity.OrderResult> getSendCancelOrderMethod() {
    io.grpc.MethodDescriptor<com.equity.CancelOrder, com.equity.OrderResult> getSendCancelOrderMethod;
    if ((getSendCancelOrderMethod = IDXEquityServiceGrpc.getSendCancelOrderMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getSendCancelOrderMethod = IDXEquityServiceGrpc.getSendCancelOrderMethod) == null) {
          IDXEquityServiceGrpc.getSendCancelOrderMethod = getSendCancelOrderMethod =
              io.grpc.MethodDescriptor.<com.equity.CancelOrder, com.equity.OrderResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendCancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.CancelOrder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.OrderResult.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("sendCancelOrder"))
              .build();
        }
      }
    }
    return getSendCancelOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.SubsOrderList,
      com.equity.OrderDetailItems> getSendSubsOrderListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendSubsOrderList",
      requestType = com.equity.SubsOrderList.class,
      responseType = com.equity.OrderDetailItems.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.SubsOrderList,
      com.equity.OrderDetailItems> getSendSubsOrderListMethod() {
    io.grpc.MethodDescriptor<com.equity.SubsOrderList, com.equity.OrderDetailItems> getSendSubsOrderListMethod;
    if ((getSendSubsOrderListMethod = IDXEquityServiceGrpc.getSendSubsOrderListMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getSendSubsOrderListMethod = IDXEquityServiceGrpc.getSendSubsOrderListMethod) == null) {
          IDXEquityServiceGrpc.getSendSubsOrderListMethod = getSendSubsOrderListMethod =
              io.grpc.MethodDescriptor.<com.equity.SubsOrderList, com.equity.OrderDetailItems>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendSubsOrderList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.SubsOrderList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.OrderDetailItems.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("sendSubsOrderList"))
              .build();
        }
      }
    }
    return getSendSubsOrderListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.SubsProbe,
      com.equity.ResponseProbe> getGetProbeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProbe",
      requestType = com.equity.SubsProbe.class,
      responseType = com.equity.ResponseProbe.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.equity.SubsProbe,
      com.equity.ResponseProbe> getGetProbeMethod() {
    io.grpc.MethodDescriptor<com.equity.SubsProbe, com.equity.ResponseProbe> getGetProbeMethod;
    if ((getGetProbeMethod = IDXEquityServiceGrpc.getGetProbeMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getGetProbeMethod = IDXEquityServiceGrpc.getGetProbeMethod) == null) {
          IDXEquityServiceGrpc.getGetProbeMethod = getGetProbeMethod =
              io.grpc.MethodDescriptor.<com.equity.SubsProbe, com.equity.ResponseProbe>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProbe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.SubsProbe.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.ResponseProbe.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("getProbe"))
              .build();
        }
      }
    }
    return getGetProbeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.equity.SubsProbeOL,
      com.equity.ResponseProbeOL> getGetProbeOLMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProbeOL",
      requestType = com.equity.SubsProbeOL.class,
      responseType = com.equity.ResponseProbeOL.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.equity.SubsProbeOL,
      com.equity.ResponseProbeOL> getGetProbeOLMethod() {
    io.grpc.MethodDescriptor<com.equity.SubsProbeOL, com.equity.ResponseProbeOL> getGetProbeOLMethod;
    if ((getGetProbeOLMethod = IDXEquityServiceGrpc.getGetProbeOLMethod) == null) {
      synchronized (IDXEquityServiceGrpc.class) {
        if ((getGetProbeOLMethod = IDXEquityServiceGrpc.getGetProbeOLMethod) == null) {
          IDXEquityServiceGrpc.getGetProbeOLMethod = getGetProbeOLMethod =
              io.grpc.MethodDescriptor.<com.equity.SubsProbeOL, com.equity.ResponseProbeOL>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProbeOL"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.SubsProbeOL.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.equity.ResponseProbeOL.getDefaultInstance()))
              .setSchemaDescriptor(new IDXEquityServiceMethodDescriptorSupplier("getProbeOL"))
              .build();
        }
      }
    }
    return getGetProbeOLMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IDXEquityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceStub>() {
        @java.lang.Override
        public IDXEquityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXEquityServiceStub(channel, callOptions);
        }
      };
    return IDXEquityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IDXEquityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceBlockingStub>() {
        @java.lang.Override
        public IDXEquityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXEquityServiceBlockingStub(channel, callOptions);
        }
      };
    return IDXEquityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IDXEquityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDXEquityServiceFutureStub>() {
        @java.lang.Override
        public IDXEquityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDXEquityServiceFutureStub(channel, callOptions);
        }
      };
    return IDXEquityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IDXEquityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendNewOrder(com.equity.CreateNewOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendNewOrderMethod(), responseObserver);
    }

    /**
     */
    public void sendReplaceOrder(com.equity.ReplaceOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendReplaceOrderMethod(), responseObserver);
    }

    /**
     */
    public void sendCancelOrder(com.equity.CancelOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendCancelOrderMethod(), responseObserver);
    }

    /**
     */
    public void sendSubsOrderList(com.equity.SubsOrderList request,
        io.grpc.stub.StreamObserver<com.equity.OrderDetailItems> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendSubsOrderListMethod(), responseObserver);
    }

    /**
     */
    public void getProbe(com.equity.SubsProbe request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbe> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProbeMethod(), responseObserver);
    }

    /**
     */
    public void getProbeOL(com.equity.SubsProbeOL request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbeOL> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProbeOLMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendNewOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.equity.CreateNewOrder,
                com.equity.OrderResult>(
                  this, METHODID_SEND_NEW_ORDER)))
          .addMethod(
            getSendReplaceOrderMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.ReplaceOrder,
                com.equity.OrderResult>(
                  this, METHODID_SEND_REPLACE_ORDER)))
          .addMethod(
            getSendCancelOrderMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.CancelOrder,
                com.equity.OrderResult>(
                  this, METHODID_SEND_CANCEL_ORDER)))
          .addMethod(
            getSendSubsOrderListMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.SubsOrderList,
                com.equity.OrderDetailItems>(
                  this, METHODID_SEND_SUBS_ORDER_LIST)))
          .addMethod(
            getGetProbeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.equity.SubsProbe,
                com.equity.ResponseProbe>(
                  this, METHODID_GET_PROBE)))
          .addMethod(
            getGetProbeOLMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.equity.SubsProbeOL,
                com.equity.ResponseProbeOL>(
                  this, METHODID_GET_PROBE_OL)))
          .build();
    }
  }

  /**
   */
  public static final class IDXEquityServiceStub extends io.grpc.stub.AbstractAsyncStub<IDXEquityServiceStub> {
    private IDXEquityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXEquityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXEquityServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendNewOrder(com.equity.CreateNewOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendNewOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendReplaceOrder(com.equity.ReplaceOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendReplaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendCancelOrder(com.equity.CancelOrder request,
        io.grpc.stub.StreamObserver<com.equity.OrderResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendCancelOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSubsOrderList(com.equity.SubsOrderList request,
        io.grpc.stub.StreamObserver<com.equity.OrderDetailItems> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendSubsOrderListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProbe(com.equity.SubsProbe request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbe> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetProbeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProbeOL(com.equity.SubsProbeOL request,
        io.grpc.stub.StreamObserver<com.equity.ResponseProbeOL> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProbeOLMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IDXEquityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IDXEquityServiceBlockingStub> {
    private IDXEquityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXEquityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXEquityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.equity.OrderResult sendNewOrder(com.equity.CreateNewOrder request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendNewOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.equity.OrderResult> sendReplaceOrder(
        com.equity.ReplaceOrder request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendReplaceOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.equity.OrderResult> sendCancelOrder(
        com.equity.CancelOrder request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendCancelOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.equity.OrderDetailItems> sendSubsOrderList(
        com.equity.SubsOrderList request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendSubsOrderListMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.equity.ResponseProbe> getProbe(
        com.equity.SubsProbe request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetProbeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.equity.ResponseProbeOL getProbeOL(com.equity.SubsProbeOL request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProbeOLMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IDXEquityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IDXEquityServiceFutureStub> {
    private IDXEquityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDXEquityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDXEquityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.equity.OrderResult> sendNewOrder(
        com.equity.CreateNewOrder request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendNewOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.equity.ResponseProbeOL> getProbeOL(
        com.equity.SubsProbeOL request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProbeOLMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_NEW_ORDER = 0;
  private static final int METHODID_SEND_REPLACE_ORDER = 1;
  private static final int METHODID_SEND_CANCEL_ORDER = 2;
  private static final int METHODID_SEND_SUBS_ORDER_LIST = 3;
  private static final int METHODID_GET_PROBE = 4;
  private static final int METHODID_GET_PROBE_OL = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IDXEquityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IDXEquityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_NEW_ORDER:
          serviceImpl.sendNewOrder((com.equity.CreateNewOrder) request,
              (io.grpc.stub.StreamObserver<com.equity.OrderResult>) responseObserver);
          break;
        case METHODID_SEND_REPLACE_ORDER:
          serviceImpl.sendReplaceOrder((com.equity.ReplaceOrder) request,
              (io.grpc.stub.StreamObserver<com.equity.OrderResult>) responseObserver);
          break;
        case METHODID_SEND_CANCEL_ORDER:
          serviceImpl.sendCancelOrder((com.equity.CancelOrder) request,
              (io.grpc.stub.StreamObserver<com.equity.OrderResult>) responseObserver);
          break;
        case METHODID_SEND_SUBS_ORDER_LIST:
          serviceImpl.sendSubsOrderList((com.equity.SubsOrderList) request,
              (io.grpc.stub.StreamObserver<com.equity.OrderDetailItems>) responseObserver);
          break;
        case METHODID_GET_PROBE:
          serviceImpl.getProbe((com.equity.SubsProbe) request,
              (io.grpc.stub.StreamObserver<com.equity.ResponseProbe>) responseObserver);
          break;
        case METHODID_GET_PROBE_OL:
          serviceImpl.getProbeOL((com.equity.SubsProbeOL) request,
              (io.grpc.stub.StreamObserver<com.equity.ResponseProbeOL>) responseObserver);
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

  private static abstract class IDXEquityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IDXEquityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.equity.Equity.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IDXEquityService");
    }
  }

  private static final class IDXEquityServiceFileDescriptorSupplier
      extends IDXEquityServiceBaseDescriptorSupplier {
    IDXEquityServiceFileDescriptorSupplier() {}
  }

  private static final class IDXEquityServiceMethodDescriptorSupplier
      extends IDXEquityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IDXEquityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IDXEquityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IDXEquityServiceFileDescriptorSupplier())
              .addMethod(getSendNewOrderMethod())
              .addMethod(getSendReplaceOrderMethod())
              .addMethod(getSendCancelOrderMethod())
              .addMethod(getSendSubsOrderListMethod())
              .addMethod(getGetProbeMethod())
              .addMethod(getGetProbeOLMethod())
              .build();
        }
      }
    }
    return result;
  }
}
