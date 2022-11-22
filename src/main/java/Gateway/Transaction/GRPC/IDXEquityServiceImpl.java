package Gateway.Transaction.GRPC;

import Gateway.Transaction.Counter;
import Gateway.Transaction.MQ.MQService;
import Model.OrderStruc;
import com.equity.*;
import io.grpc.stub.StreamObserver;

import javax.jms.Session;

public class IDXEquityServiceImpl extends IDXEquityServiceGrpc.IDXEquityServiceImplBase {

    private Counter counter;
    private Session session;
    private boolean status = true;
    private MQService mqOrder;

    public void setStart() {
        status = true;
    }

    public void setStop() {
        status = false;
    }

    public IDXEquityServiceImpl(Counter _counter, MQService _mqOrder) {
        counter = _counter;
        mqOrder = _mqOrder;
    }

    @Override
    public void sendNewOrder(CreateNewOrder request, StreamObserver<OrderResult> responseObserver) {
        OrderStruc orderStruc = new OrderStruc();
        System.out.println("Ada yg konek"+ request.getDataOrder().getClientID());

        orderStruc.setSideType(request.getDataOrder().getSideType()); //  All = 0;  Buy = 1; Sell = 2; Switch = 3; // Mutual Fund ONLY
        orderStruc.setInstrument(request.getDataOrder().getInstrument() ); // 0 : Equity, 1 : Mutual Fund
        orderStruc.setSymbol(request.getDataOrder().getSymbol()); // Kode Saham
        orderStruc.setExchange(request.getDataOrder().getSymbol());  // IDX :
        orderStruc.setClientID(request.getDataOrder().getClientID()); //15 Char
        orderStruc.setQuantity(request.getDataOrder().getQuantity()); // in Lot
        orderStruc.setPrice(request.getDataOrder().getPrice());
        orderStruc.setBoardType(request.getDataOrder().getBoardType()); //   RG = 0; TN = 1; NG = 2;
        orderStruc.setPreventDuplicate(request.getDataOrder().getPreventDuplicate()); // 0 : Ya, 1: No
        orderStruc.setTimeInForce(request.getDataOrder().getTimeInForce()); //   Day = 0; GTC = 1; GTD = 2; Session = 3;
        orderStruc.setExpireDate(orderStruc.getExpireDate());
        orderStruc.setUserConfirmed(orderStruc.getUserConfirmed() );  // 0 : Ya, 1: No
        orderStruc.setMarketData(orderStruc.getMarketData());
        orderStruc.setDeviceOrderID(orderStruc.getDeviceOrderID() );
        orderStruc.setDeviceID(orderStruc.getDeviceID());
        orderStruc.setLocalIpAddr(orderStruc.getLocalIpAddr());
        orderStruc.setUserID(orderStruc.getUserID());
        //Reasy send to MQ
        try {
            //       System.out.println("Ada Order Baru");
            //       System.out.println("ClientID : "+ request.getDataOrder().getClientID());


            //   ObjectMessage obj =  session.createObjectMessage((Serializable) orderStruc);
            mqOrder.send(orderStruc);
            //       System.out.println("Order Sent to MQ");


        } catch (Exception e) {
            System.out.println("Sent  to MQ Error : "+ e.toString());
        }
        /*
        UUID uuid = UUID.randomUUID();
        System.out.println("Send Response to Client"); */
        responseObserver.onNext(OrderResult.newBuilder().setResponseID(request.getDataOrder().getDeviceOrderID()).build() );
        responseObserver.onCompleted();
        //super.sendNewOrder(request, responseObserver);
    }

    @Override
    public void getProbe(SubsProbe request, StreamObserver<ResponseProbe> responseObserver) {
        responseObserver.onNext(ResponseProbe.newBuilder().setCounter(counter.counter ).build() );
    }
}
