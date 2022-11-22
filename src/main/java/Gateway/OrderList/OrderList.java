package Gateway.OrderList;

import Gateway.OrderList.GRPC.IDXEquityServiceOrderImpl;
import Gateway.OrderList.MQ.MQOrderSubs;
import Gateway.OrderList.MQ.MQTradeSubs;
import Gateway.OrderList.Storage.Data;
import Model.DataIndex;
import com.equity.IDXEquityServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

import java.util.concurrent.ConcurrentHashMap;

public class OrderList {
    private static int port;
    private static Data data;
    private static Counter counter;
    private static MQOrderSubs mqOrderSubs;
    private static MQTradeSubs mqTradeSubs;

    private static String inUrl;
    private static String topicOrderList;
    private static String topicTradeList;
    static ConcurrentHashMap<String, Integer> activeConnectionOL;
    private static ProbeOL probeOL;

    private static DataIndex dataIndexOL;
    public static void main(String[] args) {
        // init Param
        counter = new Counter();
        data = new Data(counter);
        dataIndexOL = new DataIndex();
        //initProbe
        activeConnectionOL = new ConcurrentHashMap<String, Integer>();
        probeOL = new ProbeOL(activeConnectionOL, dataIndexOL);
        // init MQ
        inUrl = "tcp://127.0.0.1:61616";
        topicOrderList = "OReply";
        mqOrderSubs = new MQOrderSubs(inUrl, topicOrderList, data , dataIndexOL);

        if (mqOrderSubs.getStatus()) {

            mqOrderSubs.start();
            topicTradeList = "TL";
            mqTradeSubs = new MQTradeSubs(inUrl, topicTradeList, data);
            if (mqTradeSubs.getStatus()) {
                mqTradeSubs.start();

                // Init GRPC
                port = 5454;
                IDXEquityServiceGrpc.IDXEquityServiceImplBase imp = new IDXEquityServiceOrderImpl(counter, data, dataIndexOL, probeOL);
                ServerServiceDefinition def = imp.bindService();

                io.grpc.Server svr = ServerBuilder.forPort(port).addService(imp).build();
                try {
                    svr.start();
                    System.out.println(" Transaction Service Name : " + def.getServiceDescriptor().getName() + ": Ready at Port : " + port);
                } catch (Exception e) {
                    System.out.println("GRPC Error " + e.toString());
                    svr.shutdownNow();
                    mqOrderSubs.setStop();
                    mqTradeSubs.setStop();
                } finally {
                    System.out.println("GRPC Server Standby");
                }
            }
        } else {
            System.out.println("MQ is not started");
        }

    }
}
