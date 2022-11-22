package Model;

import java.util.concurrent.ConcurrentHashMap;

public class DataIndex {
    private String clientid;
    static ConcurrentHashMap<String, Integer> clientIDX;

    private Integer lastIndex;
    public DataIndex()  {
        clientIDX = new ConcurrentHashMap<String, Integer>();
    }

    public void checkIn(String _clientid) {
        if (clientIDX.get(_clientid)  == null  ) {
            clientIDX.put(_clientid,1);
        }
    }

    public void incomingData(String _clientid) {
        Integer value = clientIDX.get(_clientid);
        if (value  == null  ) {
            clientIDX.put(_clientid,1);
        } else {
            clientIDX.put(_clientid,value+1);
        }
    }

    public void cleanUp() {
        clientIDX.clear();
    }

    public Integer getValue(String _clientid) {
        Integer value = clientIDX.get(_clientid);
        if (value  == null  ) {
            return 0;
        } else {
            return value;
        }
    }

    public void clearClientID(String _clientid) {
        clientIDX.remove(_clientid);
    }
    /*
    public Integer getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(Integer lastIndex) {
        this.lastIndex = lastIndex;
    } */
}
