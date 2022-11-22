package Services.ClientServiceDB;


import Services.ClientServiceDB.GRPC.ClientServiceDBImpl;
import com.equity.ClientServiceGrpc;
import com.equity.DBServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

public class ClientServiceDB {

    private static int port;

    public static void main(String[] args) {
        port = 3223;
        // RMSObj [0..9] --> ConcurentHashMap<....>
        DBServiceGrpc.DBServiceImplBase imp = new ClientServiceDBImpl();
        ServerServiceDefinition def = imp.bindService();
        io.grpc.Server svr = ServerBuilder.forPort(port)
                .addService(imp)
                .build();
        try {
            svr.start();
            System.out.println(" Client Service DB Name : " + def.getServiceDescriptor().getName() + ": Ready at Port : " + port);

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
