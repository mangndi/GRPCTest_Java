package Gateway.ClientService.GRPC;

import Gateway.ClientService.Counter;
import com.equity.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;


public class ClientServiceImpl extends ClientServiceGrpc.ClientServiceImplBase {
    private Counter counter;
    private static String addr;
    private static int port;

    public ClientServiceImpl(Counter _counter){
        addr = "127.0.0.1";
        port = 3223;
        counter = _counter;

    }

    private static  void getPortfolioEquityProcess(ManagedChannel channel , String _clientid, StreamObserver<ResponsePE> responseObserver) {
        try {
            DBServiceGrpc.DBServiceBlockingStub stub = DBServiceGrpc.newBlockingStub(channel);
            RequestPE _reqPE = RequestPE.newBuilder().setClientid(_clientid).build();
            try {

               stub.getPortfolioEquityDB(_reqPE).forEachRemaining(
                       responsePE -> {
                           System.out.println(responsePE.getPorto().getSymbol());
                           PortfolioEquity _pe = responsePE.getPorto();
                           responseObserver.onNext(ResponsePE.newBuilder().setPorto(_pe).build());
                       }
               );
            } catch (Exception e) {
                System.out.println("Exception on Request to Server "+ e.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception on Request to Server "+ e.toString());
        }
    }
    @Override
    public void getPortfolioEquity(RequestPE requestPE, StreamObserver<ResponsePE> responseObserver){
        //Ceritanya Gini
        // 1. Nerima Request Dari Client .. Key nya ClientID
        // 2. Klo ClienID ngga kosong , diteruskan untuk dimintakan ke ServiceDB
        // 3. Balikan dari ServiceDB dikirimkan ke Client
        // 4. hanya begitu

        counter.counter++;
        String _clientid = requestPE.getClientid();

        System.out.println("Request Porto dari clientid : "+ _clientid);
        try {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(addr, port)
                    .usePlaintext()
                    .build();

            getPortfolioEquityProcess(channel, _clientid, responseObserver);


        } catch (Exception e) {
            System.out.println("Exception on Request to Server "+ e.toString());
        } finally {
            System.out.println("Selesai Malayani getPortfolio " + _clientid);
            responseObserver.onCompleted();
        }



    }
}
