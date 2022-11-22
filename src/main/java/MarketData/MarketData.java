package MarketData;


import MarketData.GRPC.IDXMarketDataServiceImpl;

import com.equity.IDXMarketDataServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

import java.util.concurrent.ConcurrentHashMap;

public class MarketData {


    public static void main(String[] args) {
        int port = 8889;
        Counter counter = new Counter();
        ConcurrentHashMap<String, Integer> activeConnectionMDS  = new ConcurrentHashMap<>();

        ProbeMD probeMD = new ProbeMD(activeConnectionMDS);


        IDXMarketDataServiceGrpc.IDXMarketDataServiceImplBase imp = new IDXMarketDataServiceImpl(counter, probeMD);
        ServerServiceDefinition def = imp.bindService();
        System.out.println(" Service Name : " + def.getServiceDescriptor().getName() + ": Ready");

        //   io.grpc.Server svr =  ServerBuilder.forPort(port).addService(new GreetingServerImpl()).build();
        io.grpc.Server svr = ServerBuilder.forPort(port).addService(imp).build();
        try {

            svr.start();
            System.out.println("Market Data Service Started at " + Integer.toString(port));
            probeMD.start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Request Shutdown");

                svr.shutdown();
                System.out.println("Server Stop ");
            }));

            svr.awaitTermination();
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        } finally {
            System.out.println("Server Standby");

        }
    }
}
