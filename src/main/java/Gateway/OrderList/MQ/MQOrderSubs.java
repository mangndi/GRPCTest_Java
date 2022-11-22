package Gateway.OrderList.MQ;


import Model.DataIndex;
import Model.DataOrder;
import Gateway.OrderList.Storage.Data;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MQOrderSubs extends Thread {
    private int i = 0;
    private static String FurlConsumer = "tcp://127.0.0.1:61616"; // ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String FsubjectConsumer = "";
    //private ConnectionFactory FConnectionFactory = null;
    private ActiveMQConnectionFactory FConnectionFactory = null;
    private Connection FConnection = null;
    private Session FSession = null;
    private Destination FDestination = null;
    private MessageConsumer FConsumer = null;

    private Boolean isStop;
    private boolean FStatus = false;
    private Data data;
    private DataIndex dataIndex;

    public MQOrderSubs(String inurl, String insubject , Data _data, DataIndex _dataIndex)
    {
        isStop  = false;
        FStatus = false;
        dataIndex = _dataIndex;
        data = _data;

        if (!inurl.equals("")) {
            FurlConsumer = inurl;
            if (!insubject.equals("") ) {
                FsubjectConsumer = insubject;
                if (connect() == 0) {
                    setDestination();
                    FStatus = true;

                    System.out.println("Consumer Server Ready");
                }
            }
        }
    }

    public boolean getStatus() {
        return FStatus;
    }

    @Override
    public void run() {
        // Consumer Running on Thread
        data.cleanOrderData();
        while (! isStop) {
            try {
                Message message = FConsumer.receive();
                //   System.out.println("Receive New Message");
                ActiveMQObjectMessage queueMessage=(ActiveMQObjectMessage)message;
                Object payload=queueMessage.getObject();
                if (payload instanceof DataOrder) {
                    //     System.out.println("Extracting New Message");
                    i++; // Buat Debug
                  /*  Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
                    String d = sdf.format(date);*/
                    DataOrder ord= (DataOrder)payload;
                    String clid = ord.ClientID;
                    dataIndex.incomingData(clid);
                    //Add ke Concrrenthashmap
                    data.addOrderData(clid, ord );



                }

            } catch (JMSException ex) {
                Logger.getLogger(MQOrderSubs.class.getName()).log(Level.SEVERE, null, ex);
                isStop = true;
            }
        }
        if (FConnection != null) {
            try {
                FConnection.close();
                System.out.println("Consumer Connection Closed");
            } catch (JMSException ex) {
                Logger.getLogger(MQOrderSubs.class.getName()).log(Level.SEVERE, null, ex);
                isStop = true;
            }
        }

        FStatus = false;
    }

    public int connect() {
        if ( FurlConsumer.trim().equals("")) {
            return -1;
        }
        FConnectionFactory = new ActiveMQConnectionFactory(FurlConsumer);
        //    FConnectionFactory.setAlwaysSessionAsync(true);
        FConnectionFactory.setTrustAllPackages(true);
        try {
            FConnection = FConnectionFactory.createConnection();
            FConnection.start();
            FSession = FConnection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            System.out.println("Consumer Ready");
            return 0;

        } catch (JMSException ex) {
            Logger.getLogger(MQOrderSubs.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Consumer Server FAILED");
            return -1;
        }

    }


    private int setDestination() {

        try {
            FDestination = FSession.createQueue(FsubjectConsumer);
            FConsumer = FSession.createConsumer(FDestination);

            isStop = false;
        } catch (JMSException ex) {
            Logger.getLogger(MQOrderSubs.class.getName()).log(Level.SEVERE, null, ex);
            isStop = true;
        }
        if (isStop)
            return -1;
        else
            return 0;

    }

    public void setStop() {
        isStop = true;
        try {
            FConnection.stop();

        } catch (JMSException ex) {
            Logger.getLogger(MQOrderSubs.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("BYE");
    }
}
