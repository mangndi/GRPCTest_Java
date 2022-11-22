package Gateway.OrderList;

import Model.DataIndex;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* catatan : Ini class untuk workaround melakukan terminate dari sisi server, */
/*karena GRPC ini masih belum sempurna untuk modul streaming server nya */

public class ProbeOL {
    private ProbeOLCheckAndCleanUp probeOLCheckAndCleanUp;
 //   private ProbeMDCleanUp probeMDCleanUp;
    private ConcurrentHashMap<String, Integer> activeConnectionOL;
    private DataIndex dataIndex;
    public ProbeOL(ConcurrentHashMap _activeConnectionOL, DataIndex _dataIndex ) {
        dataIndex = _dataIndex;
        activeConnectionOL = _activeConnectionOL;
        probeOLCheckAndCleanUp = new ProbeOLCheckAndCleanUp(_activeConnectionOL, 6000, dataIndex);
//        probeMDCleanUp = new ProbeMDCleanUp(_activeConnectionMDS, 12000);

    }

    public Integer checkKey(String key) {
     return activeConnectionOL.get(key);
    }

    public void checkPoint(String Key) {
        Integer  value = activeConnectionOL.get(Key);
        if (value != null) {
            activeConnectionOL.remove(Key);
            activeConnectionOL.put(Key, 1);
            //activeConnectionMDS.computeIfPresent(id, (key, oldValue) -> oldValue);// (key, oldValue) -> oldValue + 1);
        } else {
            activeConnectionOL.put(Key, 1);
        }
        activeConnectionOL.remove("");
        System.out.println("New Probe "+ Key);

    }
    public void start(){
        probeOLCheckAndCleanUp.status = true;
   //     probeMDCleanUp.status = true;
        probeOLCheckAndCleanUp.start();
   //     probeMDCleanUp.start();
    }

    public void stop() {
        probeOLCheckAndCleanUp.status = false;
        //probeMDCleanUp.status = false;
    }
}


class ProbeOLCheckAndCleanUp extends Thread{
    private Integer sleep = 5000;
    public boolean status = true;
    private ConcurrentHashMap<String, Integer> activeConnectionMDS ;
    private DataIndex dataIndex;
    public ProbeOLCheckAndCleanUp(ConcurrentHashMap _activeConnectionMDS, Integer _sleep, DataIndex _dataIndex ){
        activeConnectionMDS = _activeConnectionMDS;
        sleep = _sleep;
        dataIndex = _dataIndex;
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
                        String clid = entry.getKey();
                        System.out.println("   . Clenup : Key = " + clid + ", Value = " + entry.getValue());
                        activeConnectionMDS.remove(clid);
                        dataIndex.clearClientID(clid);
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