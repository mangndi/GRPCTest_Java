package MarketData;

import com.equity.ResponseProbeMD;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* catatan : Ini class untuk workaround melakukan terminate dari sisi server, */
/*karena GRPC ini masih belum sempurna untuk modul streaming server nya */

public class ProbeMD {
    private ProbeMDCheckAndCleanUp probeMDCheckAndCleanUp;
 //   private ProbeMDCleanUp probeMDCleanUp;
    private ConcurrentHashMap<String, Integer> activeConnectionMDS ;
    public ProbeMD(ConcurrentHashMap _activeConnectionMDS ) {
        activeConnectionMDS = _activeConnectionMDS;
        probeMDCheckAndCleanUp = new ProbeMDCheckAndCleanUp(_activeConnectionMDS, 6000);
//        probeMDCleanUp = new ProbeMDCleanUp(_activeConnectionMDS, 12000);

    }

    public Integer checkKey(String key) {
     return activeConnectionMDS.get(key);
    }

    public void checkPoint(String Key) {
        Integer  value = activeConnectionMDS.get(Key);
        if (value != null) {
            activeConnectionMDS.remove(Key);
            activeConnectionMDS.put(Key, 1);
            //activeConnectionMDS.computeIfPresent(id, (key, oldValue) -> oldValue);// (key, oldValue) -> oldValue + 1);
        } else {
            activeConnectionMDS.put(Key, 1);
        }
        activeConnectionMDS.remove("");
        System.out.println("New Probe "+ Key);

    }
    public void start(){
        probeMDCheckAndCleanUp.status = true;
   //     probeMDCleanUp.status = true;
        probeMDCheckAndCleanUp.start();
   //     probeMDCleanUp.start();
    }

    public void stop() {
        probeMDCheckAndCleanUp.status = false;
        //probeMDCleanUp.status = false;
    }
}


class ProbeMDCheckAndCleanUp extends Thread{
    private Integer sleep = 5000;
    public boolean status = true;
    private ConcurrentHashMap<String, Integer> activeConnectionMDS ;
    public ProbeMDCheckAndCleanUp(ConcurrentHashMap _activeConnectionMDS, Integer _sleep ){
        activeConnectionMDS = _activeConnectionMDS;
        sleep = _sleep;
    }
    public void run(){
        super.run();
        System.out.println("thread is running...");
        while (status) {
            try {
                // update all key -1
                int i = 0;
                int val = 0;
                int j = 0;
                for (Map.Entry<String, Integer> entry : activeConnectionMDS.entrySet()) {
                    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    System.out.println("    . Checked : "+entry.getKey()+" : "+ entry.getValue() );
                    activeConnectionMDS.computeIfPresent(entry.getKey(), (key, oldValue) -> oldValue - 1);
                    // CleanUp
                    val = entry.getValue();
                    if (val < 0) {
                        j++;
                        System.out.println("   . Clenup : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        activeConnectionMDS.remove(entry.getKey());
                    } else {
                    //    System.out.println("   . Clenup Not : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    }
                    i++;
                }
             //   System.out.println(". Checked : "+ i);
                System.out.println(". Clenup : "+ j + " of "+ i);
                // Clean Up
                /*
                int val = 0;
                int j = 0;
                i = 0;
                for (Map.Entry<String, Integer> entry : activeConnectionMDS.entrySet()) {
                    val = entry.getValue();
                    if (val < 0) {
                        i++;
                        System.out.println("   . Clenup : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        activeConnectionMDS.remove(entry.getKey());
                    } else {
                        System.out.println("   . Clenup Not : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    }
                    j++;
                }
                System.out.println(". Clenup : "+ i + "of "+ j);
*/
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                status = false;
                throw new RuntimeException(e);
            }
        }
    }

}

/*
class ProbeMDCleanUpx extends Thread{
    private Integer sleep = 11000;
    public boolean status = true;
    private ConcurrentHashMap<String, Integer> activeConnectionMDS ;
    public ProbeMDCleanUpx(ConcurrentHashMap _activeConnectionMDS, Integer _sleep ){
        activeConnectionMDS = _activeConnectionMDS;
        sleep = _sleep;
    }
    public void run(){
        System.out.println("thread is running...");
        while (status) {
            try {

                // update all key -1
                // delete
                int i = 0;
                int val = 0;
                for (Map.Entry<String, Integer> entry : activeConnectionMDS.entrySet()) {
                    val = entry.getValue();
                    if (val < 0) {

                        System.out.println("   . Clenup : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        activeConnectionMDS.remove(entry.getKey());
                    } else {
                        System.out.println("   . Clenup Not : Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    }
                    i++;
                }
                System.out.println(". Clenup : "+ i);
                Thread.sleep(sleep);

            } catch (InterruptedException e) {
                status = false;
                throw new RuntimeException(e);
            }
        }
    }

}

 */