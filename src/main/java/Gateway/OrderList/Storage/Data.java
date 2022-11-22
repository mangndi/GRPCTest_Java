package Gateway.OrderList.Storage;

import Gateway.OrderList.Counter;
import Model.DataOrder;
import Model.DataTrade;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Data {
    // ORDER
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, DataOrder>> dtOrder;
    // TRADES
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, DataTrade>> dtTrade;
    private Counter counter;

    public Data(Counter _counter) {
        // CLientID, Data Order nya
        counter = _counter;
        counter.counter = 0;
        dtOrder = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, DataOrder>>();
        dtTrade = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, DataTrade>>();
    }

    public void addOrderData(String _clientID, DataOrder _dataOrder) {
        ConcurrentHashMap<Integer, DataOrder> dtOrderDetail = new  ConcurrentHashMap<Integer, DataOrder>();
        if (dtOrderDetail.get(_dataOrder.ID) != null ) {
            dtOrderDetail.replace(_dataOrder.ID, _dataOrder);
        } else {
            dtOrderDetail.put(_dataOrder.ID, _dataOrder);
        }
        System.out.println("Jumlah Order "+ dtOrderDetail );
        dtOrder.put(_clientID,dtOrderDetail );
        counter.counter++;
    }

    public void removeOrderData(String _clientID) {
        dtOrder.remove(_clientID);
    }

    public void cleanOrderData() {
        dtOrder.clear();
    }

    public void addTradeData(String _clientID, DataTrade _dataTrade) {
        ConcurrentHashMap<Integer, DataTrade> dtTradeDetail = new  ConcurrentHashMap<Integer, DataTrade>();
        dtTradeDetail.put(_dataTrade.ID, _dataTrade);

        dtTrade.put(_clientID,dtTradeDetail );
        counter.counter++;
    }

    public void removeTradeData(String _clientID) {
        dtTrade.remove(_clientID);
    }

    public void cleanTradeData() {
        dtTrade.clear();
    }

    public ConcurrentHashMap<Integer,DataOrder> getOrderData(String _clientID) {

        ConcurrentHashMap<Integer,DataOrder>  value = dtOrder.get(_clientID);
        return value;
        /*
        if (value != null ) {
            for (Map.Entry<Integer,DataOrder> entryDetail : value.entrySet()) {
                Integer keyDetail = entryDetail.getKey();
                DataOrder orderDetail = entryDetail.getValue();
               // nah ini kembalikan kenasabah
            }
        } */

    }

    public void getTradeData(String _clientID) {

        ConcurrentHashMap<Integer,DataTrade>  value = dtTrade.get(_clientID);
        if (value != null ) {
            for (Map.Entry<Integer,DataTrade> entryDetail : value.entrySet()) {
                Integer keyDetail = entryDetail.getKey();
                DataTrade tradeDetail = entryDetail.getValue();
                // nah ini kembalikan kenasabah
            }
        }

    }

}
