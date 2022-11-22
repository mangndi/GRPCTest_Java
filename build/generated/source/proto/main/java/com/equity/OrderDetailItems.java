// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: equity.proto

package com.equity;

/**
 * Protobuf type {@code equity.OrderDetailItems}
 */
public final class OrderDetailItems extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:equity.OrderDetailItems)
    OrderDetailItemsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrderDetailItems.newBuilder() to construct.
  private OrderDetailItems(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  public OrderDetailItems() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OrderDetailItems();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OrderDetailItems(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.equity.OrderDetailStruc.Builder subBuilder = null;
            if (orderItem_ != null) {
              subBuilder = orderItem_.toBuilder();
            }
            orderItem_ = input.readMessage(com.equity.OrderDetailStruc.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(orderItem_);
              orderItem_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.equity.Equity.internal_static_equity_OrderDetailItems_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.equity.Equity.internal_static_equity_OrderDetailItems_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.equity.OrderDetailItems.class, com.equity.OrderDetailItems.Builder.class);
  }

  public static final int ORDERITEM_FIELD_NUMBER = 1;
  public com.equity.OrderDetailStruc orderItem_;
  /**
   * <code>.equity.OrderDetailStruc orderItem = 1;</code>
   * @return Whether the orderItem field is set.
   */
  @java.lang.Override
  public boolean hasOrderItem() {
    return orderItem_ != null;
  }
  /**
   * <code>.equity.OrderDetailStruc orderItem = 1;</code>
   * @return The orderItem.
   */
  @java.lang.Override
  public com.equity.OrderDetailStruc getOrderItem() {
    return orderItem_ == null ? com.equity.OrderDetailStruc.getDefaultInstance() : orderItem_;
  }
  /**
   * <code>.equity.OrderDetailStruc orderItem = 1;</code>
   */
  @java.lang.Override
  public com.equity.OrderDetailStrucOrBuilder getOrderItemOrBuilder() {
    return getOrderItem();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (orderItem_ != null) {
      output.writeMessage(1, getOrderItem());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (orderItem_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOrderItem());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.equity.OrderDetailItems)) {
      return super.equals(obj);
    }
    com.equity.OrderDetailItems other = (com.equity.OrderDetailItems) obj;

    if (hasOrderItem() != other.hasOrderItem()) return false;
    if (hasOrderItem()) {
      if (!getOrderItem()
          .equals(other.getOrderItem())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasOrderItem()) {
      hash = (37 * hash) + ORDERITEM_FIELD_NUMBER;
      hash = (53 * hash) + getOrderItem().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.equity.OrderDetailItems parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.equity.OrderDetailItems parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.equity.OrderDetailItems parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.equity.OrderDetailItems parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.equity.OrderDetailItems parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.equity.OrderDetailItems parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.equity.OrderDetailItems parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.equity.OrderDetailItems parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.equity.OrderDetailItems parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.equity.OrderDetailItems parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.equity.OrderDetailItems parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.equity.OrderDetailItems parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.equity.OrderDetailItems prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code equity.OrderDetailItems}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:equity.OrderDetailItems)
      com.equity.OrderDetailItemsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.equity.Equity.internal_static_equity_OrderDetailItems_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.equity.Equity.internal_static_equity_OrderDetailItems_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.equity.OrderDetailItems.class, com.equity.OrderDetailItems.Builder.class);
    }

    // Construct using com.equity.OrderDetailItems.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (orderItemBuilder_ == null) {
        orderItem_ = null;
      } else {
        orderItem_ = null;
        orderItemBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.equity.Equity.internal_static_equity_OrderDetailItems_descriptor;
    }

    @java.lang.Override
    public com.equity.OrderDetailItems getDefaultInstanceForType() {
      return com.equity.OrderDetailItems.getDefaultInstance();
    }

    @java.lang.Override
    public com.equity.OrderDetailItems build() {
      com.equity.OrderDetailItems result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.equity.OrderDetailItems buildPartial() {
      com.equity.OrderDetailItems result = new com.equity.OrderDetailItems(this);
      if (orderItemBuilder_ == null) {
        result.orderItem_ = orderItem_;
      } else {
        result.orderItem_ = orderItemBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.equity.OrderDetailItems) {
        return mergeFrom((com.equity.OrderDetailItems)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.equity.OrderDetailItems other) {
      if (other == com.equity.OrderDetailItems.getDefaultInstance()) return this;
      if (other.hasOrderItem()) {
        mergeOrderItem(other.getOrderItem());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.equity.OrderDetailItems parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.equity.OrderDetailItems) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.equity.OrderDetailStruc orderItem_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.equity.OrderDetailStruc, com.equity.OrderDetailStruc.Builder, com.equity.OrderDetailStrucOrBuilder> orderItemBuilder_;
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     * @return Whether the orderItem field is set.
     */
    public boolean hasOrderItem() {
      return orderItemBuilder_ != null || orderItem_ != null;
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     * @return The orderItem.
     */
    public com.equity.OrderDetailStruc getOrderItem() {
      if (orderItemBuilder_ == null) {
        return orderItem_ == null ? com.equity.OrderDetailStruc.getDefaultInstance() : orderItem_;
      } else {
        return orderItemBuilder_.getMessage();
      }
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public Builder setOrderItem(com.equity.OrderDetailStruc value) {
      if (orderItemBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        orderItem_ = value;
        onChanged();
      } else {
        orderItemBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public Builder setOrderItem(
        com.equity.OrderDetailStruc.Builder builderForValue) {
      if (orderItemBuilder_ == null) {
        orderItem_ = builderForValue.build();
        onChanged();
      } else {
        orderItemBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public Builder mergeOrderItem(com.equity.OrderDetailStruc value) {
      if (orderItemBuilder_ == null) {
        if (orderItem_ != null) {
          orderItem_ =
            com.equity.OrderDetailStruc.newBuilder(orderItem_).mergeFrom(value).buildPartial();
        } else {
          orderItem_ = value;
        }
        onChanged();
      } else {
        orderItemBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public Builder clearOrderItem() {
      if (orderItemBuilder_ == null) {
        orderItem_ = null;
        onChanged();
      } else {
        orderItem_ = null;
        orderItemBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public com.equity.OrderDetailStruc.Builder getOrderItemBuilder() {
      
      onChanged();
      return getOrderItemFieldBuilder().getBuilder();
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    public com.equity.OrderDetailStrucOrBuilder getOrderItemOrBuilder() {
      if (orderItemBuilder_ != null) {
        return orderItemBuilder_.getMessageOrBuilder();
      } else {
        return orderItem_ == null ?
            com.equity.OrderDetailStruc.getDefaultInstance() : orderItem_;
      }
    }
    /**
     * <code>.equity.OrderDetailStruc orderItem = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.equity.OrderDetailStruc, com.equity.OrderDetailStruc.Builder, com.equity.OrderDetailStrucOrBuilder> 
        getOrderItemFieldBuilder() {
      if (orderItemBuilder_ == null) {
        orderItemBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.equity.OrderDetailStruc, com.equity.OrderDetailStruc.Builder, com.equity.OrderDetailStrucOrBuilder>(
                getOrderItem(),
                getParentForChildren(),
                isClean());
        orderItem_ = null;
      }
      return orderItemBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:equity.OrderDetailItems)
  }

  // @@protoc_insertion_point(class_scope:equity.OrderDetailItems)
  private static final com.equity.OrderDetailItems DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.equity.OrderDetailItems();
  }

  public static com.equity.OrderDetailItems getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrderDetailItems>
      PARSER = new com.google.protobuf.AbstractParser<OrderDetailItems>() {
    @java.lang.Override
    public OrderDetailItems parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OrderDetailItems(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OrderDetailItems> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrderDetailItems> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.equity.OrderDetailItems getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
