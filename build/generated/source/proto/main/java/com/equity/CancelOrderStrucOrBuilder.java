// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: equity.proto

package com.equity;

public interface CancelOrderStrucOrBuilder extends
    // @@protoc_insertion_point(interface_extends:equity.CancelOrderStruc)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required
   * </pre>
   *
   * <code>string OrderID = 1;</code>
   * @return The orderID.
   */
  java.lang.String getOrderID();
  /**
   * <pre>
   * Required
   * </pre>
   *
   * <code>string OrderID = 1;</code>
   * @return The bytes for orderID.
   */
  com.google.protobuf.ByteString
      getOrderIDBytes();

  /**
   * <pre>
   * Required
   * </pre>
   *
   * <code>string ClientID = 2;</code>
   * @return The clientID.
   */
  java.lang.String getClientID();
  /**
   * <pre>
   * Required
   * </pre>
   *
   * <code>string ClientID = 2;</code>
   * @return The bytes for clientID.
   */
  com.google.protobuf.ByteString
      getClientIDBytes();

  /**
   * <pre>
   * Optional
   * </pre>
   *
   * <code>string Remark = 3;</code>
   * @return The remark.
   */
  java.lang.String getRemark();
  /**
   * <pre>
   * Optional
   * </pre>
   *
   * <code>string Remark = 3;</code>
   * @return The bytes for remark.
   */
  com.google.protobuf.ByteString
      getRemarkBytes();

  /**
   * <code>string DeviceOrderID = 4;</code>
   * @return The deviceOrderID.
   */
  java.lang.String getDeviceOrderID();
  /**
   * <code>string DeviceOrderID = 4;</code>
   * @return The bytes for deviceOrderID.
   */
  com.google.protobuf.ByteString
      getDeviceOrderIDBytes();

  /**
   * <code>string DeviceID = 5;</code>
   * @return The deviceID.
   */
  java.lang.String getDeviceID();
  /**
   * <code>string DeviceID = 5;</code>
   * @return The bytes for deviceID.
   */
  com.google.protobuf.ByteString
      getDeviceIDBytes();

  /**
   * <code>string LocalIpAddress = 6;</code>
   * @return The localIpAddress.
   */
  java.lang.String getLocalIpAddress();
  /**
   * <code>string LocalIpAddress = 6;</code>
   * @return The bytes for localIpAddress.
   */
  com.google.protobuf.ByteString
      getLocalIpAddressBytes();

  /**
   * <code>string UserID = 7;</code>
   * @return The userID.
   */
  java.lang.String getUserID();
  /**
   * <code>string UserID = 7;</code>
   * @return The bytes for userID.
   */
  com.google.protobuf.ByteString
      getUserIDBytes();
}
