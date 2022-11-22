package Gateway.Transaction;


import Gateway.Transaction.GRPC.IDXEquityServiceImpl;
import Gateway.Transaction.MQ.MQService;
import com.equity.IDXEquityServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;


import javax.jms.JMSException;


public class TransGateway {

    private static String userid;
    private static String password;
    private static String url;

    private static Counter counter;
    private static MQService mqOrder;
    private static int port;

    private static String orderQueue;
    private static String amendQueue;
    private static String cancelQueue;

    public static void main(String[] args) throws JMSException {
        // Setting param MQ
        userid = "admin";
        password = "admin";
        url = "tcp://127.0.0.1:61616";
        orderQueue = "OQ"; // New Order
        amendQueue = "AQ"; // Amend Order
        cancelQueue = "CQ"; // Cancel Order

        // Bikin beberapa Object MQ dulu sesuai dengan Topic Queue nya

        mqOrder = new MQService(userid, password, url, orderQueue);
        if (mqOrder.start()) {
            System.out.println("ActiveMQ is Ready ");
            // ==>> GRPC
            // Setting param GRPC
            port = 1234;

            // Bikin Counter untuk Loadbalancing GRPC

            // Bikin Layanan GRPC ke User
            IDXEquityServiceGrpc.IDXEquityServiceImplBase imp = new IDXEquityServiceImpl(counter, mqOrder);
            ServerServiceDefinition def = imp.bindService();

            io.grpc.Server svr = ServerBuilder.forPort(port).addService(imp).build();
            try {
                svr.start();
                System.out.println(" Transaction Service Name : " + def.getServiceDescriptor().getName() + ": Ready at Port : " + port);
            } catch (Exception e) {
                System.out.println("GRPC Error " + e.toString());
                svr.shutdownNow();
                mqOrder.stop();
            } finally {
                System.out.println("GRPC Server Standby");
            }

        } else {
            System.out.println("MQ Failed to Start, Check for ActiveMQ services");
        }

    }
}
