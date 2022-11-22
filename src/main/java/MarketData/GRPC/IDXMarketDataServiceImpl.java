package MarketData.GRPC;

import MarketData.Counter;
import MarketData.ProbeMD;
import com.equity.IDXMarketDataServiceGrpc;
import com.equity.SubsRunningTrades;
import com.equity.*;
import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class IDXMarketDataServiceImpl extends IDXMarketDataServiceGrpc.IDXMarketDataServiceImplBase {

  //  private ConcurrentHashMap<String, Integer> activeConnectionMDS ;
    private Counter counter;
    private ProbeMD probeMD;

    public IDXMarketDataServiceImpl(Counter _counter, ProbeMD _probeMD ) {
        counter = _counter;
        probeMD = _probeMD;
    //    activeConnectionMDS = _activeConnectionMDS; // new ConcurrentHashMap<>();

    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    @Override
    public void sendSubsRunningTrades(SubsRunningTrades request, StreamObserver<RunningTradesResponse> response) {
        boolean status = true;
        String key = request.getKey();
        System.out.println("Ada yg baru konek "+ key);

        LocalDateTime now = LocalDateTime.now();
        probeMD.checkPoint(key);
        counter.counter++;
        counter.print();

        /* Dummy Data */
        List<String> stockList = Arrays.asList("AALI", "ANTM", "ADMG", "BBCA", "BUMI", "BMTR", "BMRI", "HMSP", "GGRM", "UNVR", "ZBRA", "ITMG", "INDY");

        Random rand = new Random();

        /* Dummy Data */

        int i = 0;

        while (status) {
            i++;
            RunningTradesStruc result = new RunningTradesStruc();
            result.time_ = new SimpleDateFormat("HH:mm:ss").format(new Date());
            result.symbol_ =  stockList.get(rand.nextInt(stockList.size()));
            result.matchedPrice_ =  getRandomNumber(100,5000);
            result.vol_ =  getRandomNumber(1,5000);//rand.nextInt(200);
            result.change_ =  getRandomNumber(1,50);// rand.nextInt(50);
            result.index_ = i;
            response.onNext(RunningTradesResponse.newBuilder().setRunningTrades(result).build() );

            System.out.println( i +". StockID : " + result.symbol_   +";price :"+ result.matchedPrice_);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                status = false;
                System.out.println(e.toString());
            }

            if (probeMD.checkKey(key) == null) {
                status = false;
            }
        }

        System.out.println("Selesai key: "+key);
        response.onCompleted();
    }


    @Override
    public void getProbeMD(SubsProbeMD request, StreamObserver<ResponseProbeMD> response){


        String key = request.getRequestID();
        probeMD.checkPoint(key);

        response.onNext(ResponseProbeMD.newBuilder().setCounter(1).build());
        response.onCompleted();

    }



}



