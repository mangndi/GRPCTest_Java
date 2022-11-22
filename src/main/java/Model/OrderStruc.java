package Model;

import java.io.Serializable;

public class OrderStruc implements Serializable {
    Integer SideType ; //  All = 0;  Buy = 1; Sell = 2; Switch = 3; // Mutual Fund ONLY
    Integer Instrument; // 0 : Equity, 1 : Mutual Fund
    String Symbol; // Kode Saham
    String Exchange;  // IDX :
    String ClientID; //15 Char
    Long Quantity; // in Lot
    Integer Price;
    Integer BoardType; //   RG = 0; TN = 1; NG = 2;
    Integer PreventDuplicate; // 0 : Ya, 1: No
    Integer TimeInForce; //   Day = 0; GTC = 1; GTD = 2; Session = 3;
    String ExpireDate;
    Integer UserConfirmed;  // 0 : Ya, 1: No
    String MarketData;
    String DeviceOrderID;

    public Integer getSideType() {
        return SideType;
    }

    public void setSideType(Integer sideType) {
        SideType = sideType;
    }

    public Integer getInstrument() {
        return Instrument;
    }

    public void setInstrument(Integer instrument) {
        Instrument = instrument;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getExchange() {
        return Exchange;
    }

    public void setExchange(String exchange) {
        Exchange = exchange;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getBoardType() {
        return BoardType;
    }

    public void setBoardType(Integer boardType) {
        BoardType = boardType;
    }

    public Integer getPreventDuplicate() {
        return PreventDuplicate;
    }

    public void setPreventDuplicate(Integer preventDuplicate) {
        PreventDuplicate = preventDuplicate;
    }

    public Integer getTimeInForce() {
        return TimeInForce;
    }

    public void setTimeInForce(Integer timeInForce) {
        TimeInForce = timeInForce;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public Integer getUserConfirmed() {
        return UserConfirmed;
    }

    public void setUserConfirmed(Integer userConfirmed) {
        UserConfirmed = userConfirmed;
    }

    public String getMarketData() {
        return MarketData;
    }

    public void setMarketData(String marketData) {
        MarketData = marketData;
    }

    public String getDeviceOrderID() {
        return DeviceOrderID;
    }

    public void setDeviceOrderID(String deviceOrderID) {
        DeviceOrderID = deviceOrderID;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getLocalIpAddr() {
        return LocalIpAddr;
    }

    public void setLocalIpAddr(String localIpAddr) {
        LocalIpAddr = localIpAddr;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    String DeviceID;
    String LocalIpAddr;
    String UserID;
}
