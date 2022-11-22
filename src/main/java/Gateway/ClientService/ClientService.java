package Gateway.ClientService;

import Gateway.ClientService.GRPC.ClientServiceImpl;
import com.equity.ClientServiceGrpc;
import com.equity.RequestPE;
import com.equity.ResponsePE;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;


public class ClientService {
    //

    private static Counter counter;
    private static int port;
    public static void main(String[] args) {
        counter = new Counter();
        port = 1122;



        ClientServiceGrpc.ClientServiceImplBase imp = new ClientServiceImpl( counter) ;
        ServerServiceDefinition def = imp.bindService();
        io.grpc.Server svr = ServerBuilder.forPort(port).addService(imp).build();

        try {
            svr.start();
            System.out.println(" Client Service Name : " + def.getServiceDescriptor().getName() + ": Ready at Port : " + port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Request Shutdown");

                svr.shutdown();
                System.out.println("Server Stop ");
            }));
            svr.awaitTermination();
        } catch (Exception e) {
            System.out.println("GRPC Error " + e.toString());
            svr.shutdownNow();

        } finally {
            System.out.println("GRPC Server Standby");
        }
    }




}
