package Gateway.OrderList.GRPC;

import Gateway.OrderList.MQ.MQOrderSubs;
import Gateway.OrderList.MQ.MQTradeSubs;
import Gateway.OrderList.ProbeOL;
import Gateway.OrderList.Storage.Data;
import Gateway.OrderList.Counter;
import Model.DataIndex;
import Model.DataOrder;
import com.equity.*;
import io.grpc.stub.StreamObserver;
//import io.grpc.stub.StreamObserver;

import javax.jms.Session;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IDXEquityServiceOrderImpl extends IDXEquityServiceGrpc.IDXEquityServiceImplBase {

    private Counter counter;
    private Session session;
    private boolean status = true;

    private DataIndex dataIndex;
    private Data data;

    private ProbeOL probeOL;
    public void setStart() {
        status = true;
    }

    public void setStop() {
        status = false;
    }


    public IDXEquityServiceOrderImpl(Counter _counter, Data _data, DataIndex _dataIndex, ProbeOL _probeOL) {
        counter = _counter;
        dataIndex = _dataIndex;
        data = _data;
        probeOL = _probeOL;
    }

    private Integer getOrderStatus (String ordStatus) {
        Integer sts = 0;
        if (ordStatus.toLowerCase() == "n" ) { // pending new
            sts = 0;
        } else if (ordStatus.toLowerCase() == "o" ) { // open
            sts = 1;
        } else if (ordStatus.toLowerCase() == "m" ) { // match
            sts = 2;
        } else if (ordStatus.toLowerCase() == "a" ) { // amend
            sts = 3;
        } else if (ordStatus.toLowerCase() == "w" ) { // canceled
            sts = 4;
        } else if (ordStatus.toLowerCase() == "p" ) { // partial
            sts = 5;
        } else if (ordStatus.toLowerCase() == "r" ) { // canceled
            sts = 6;
        }

        return sts;
    }

    @Override
    public void sendSubsOrderList(SubsOrderList request, StreamObserver<OrderDetailItems> responseObserver) {
        String clientid = request.getClientID();
        Boolean status = true;
        Integer lastIdx = 0;
        Integer currentIdx = 0;
        probeOL.checkPoint(clientid);
        System.out.println("Incoming "+ clientid);
        counter.counter++;
        while (status) {
            currentIdx = dataIndex.getValue(clientid);
            if (currentIdx != lastIdx) {
                lastIdx = currentIdx;

                if(data != null) {
                    System.out.println("Data not Null, mulai cari");
                    ConcurrentHashMap<Integer,DataOrder> value = data.getOrderData(clientid);
                    if (value != null ) {
                        System.out.println("Data Ketemu");
                        for (Map.Entry<Integer,DataOrder> entryDetail : value.entrySet()) {
                            Integer keyDetail = entryDetail.getKey();
                            DataOrder orderDetail = entryDetail.getValue();
                            // nah ini kembalikan kenasabah
                            OrderDetailStruc orderDetailStruc = new OrderDetailStruc();
                            orderDetailStruc.iD_ = orderDetail.ID;
                            orderDetailStruc.deviceOrderID_ = orderDetail.DeviceOrderID;
                            orderDetailStruc.orderID_ =  orderDetail.OrderID;
                            orderDetailStruc.clientID_ =  orderDetail.ClientID;
                            orderDetailStruc.orderTime_ =  orderDetail.OrderTime;; // Broker reference
                            orderDetailStruc.symbol_ = orderDetail.Symbol;
                            orderDetailStruc.board_ = orderDetail.Board;
                            orderDetailStruc.exchange_ = orderDetail.Exchange;
                            orderDetailStruc.qty_ = orderDetail.Qty;
                            orderDetailStruc.matchQty_ = orderDetail.MatchQty;
                            System.out.println("Kirim : "+ orderDetail.ID);
                        //    responseObserver.onNext(OrderDetailItems.newBuilder().setOrderItem(orderDetailStruc).build());
                            try {
                                Thread.sleep(1);
                            } catch (Exception e) {
                                System.out.println(e.toString());
                            }
                        }
                    }
                }
            } else {
                // check probe
                if (probeOL.checkKey(clientid) == null ) {
                    status = false;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }
        System.out.println("Selesai key: "+clientid);
   //     responseObserver.onCompleted();

    }


    @Override
    public void getProbeOL(SubsProbeOL request, StreamObserver<ResponseProbeOL> responseObserver) {
        String clientid = request.getClientID();
        probeOL.checkPoint(clientid);
        responseObserver.onNext(ResponseProbeOL.newBuilder().setCounter(1).build() );
    }


}
