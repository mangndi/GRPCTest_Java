package Services.ClientServiceDB.GRPC;

import com.equity.DBServiceGrpc;
import com.equity.*;
import io.grpc.stub.StreamObserver;

public class ClientServiceDBImpl extends DBServiceGrpc.DBServiceImplBase {

    @Override
    public void getPortfolioEquityDB(RequestPE requestPE, StreamObserver<ResponsePE> responseObserver) {
        System.out.println("Ada request ke Portfolio DB");
        String clientid = requestPE.getClientid();
        if (clientid != "") {
            try {
                // Simulasi ambil data dari Database
                Thread.sleep(5000);
                int i = 0;
                while (i < 2) {
                //for (int i = 0; i < 1; i++) {
                    String stockID = "";
                    if (i==0) {
                        stockID = "AALI";
                    } else if(i==1)  {
                        stockID = "GGRM";
                    }
                    System.out.println("Proses Porto DB : "+ stockID);
                    PortfolioEquity _pe = PortfolioEquity.newBuilder()
                            .setId(i+1)
                            .setSymbol(stockID)
                            .setExchange("IDX")
                            .setClientID(clientid)
                            .setQuantity(20)
                            .setLotSize(100)
                            .setPrice(458)
                            .setHaircut(45)
                            .setIsBlocked(0)
                            .build();

                    ResponsePE _resRE = ResponsePE.newBuilder()
                            .setPorto(_pe).build();
                    responseObserver.onNext(_resRE);
                    i++;

                }


                //   responseObserver.onNext(ResponsePE.newBuilder().setPorto(_pe).build() );

            } catch (Exception e) {
                System.out.println("");
            }
        }
        responseObserver.onCompleted();
        System.out.println("Selesai : Porto : "+ clientid);
    }

}
