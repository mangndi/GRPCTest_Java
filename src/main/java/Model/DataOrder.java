package Model;


import java.io.Serializable;

public class DataOrder  implements Serializable  {
    public int ID;
    public int DeviceOrderID;
    public int OrderID;
    public String ClientID;
    public String OrderTime;
    public String Symbol;
    public String Board;
    public String Exchange;
    public int Qty;
    public int MatchQty;
    public int CanceledQty;
    public int Price;
    public String Status;
    public String desc;
    public String UserID;
    public int ForcedToSell;

}
