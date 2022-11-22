package Services.DummyORI;


import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;

//import Services.GatewayDummyService.Model.OrderStruc;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import Model.OrderStruc;


class MQDummySubscriber  extends Thread{
    private int i = 0;
    private static String FurlConsumer = "tcp://10.72.38.99:61616"; // ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String FsubjectConsumer = "";
    //private ConnectionFactory FConnectionFactory = null;
    private ActiveMQConnectionFactory FConnectionFactory = null;
    private Connection FConnection = null;
    private Session FSession = null;
    private Destination FDestination = null;
    private MessageConsumer FConsumer = null;

    private Boolean isStop;
    private boolean FStatus = false;

    public MQDummySubscriber(String inurl, String insubject )
    {
        isStop  = false;
        FStatus = false;

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
        while (! isStop) {
            try {
                Message message = FConsumer.receive();
                //   System.out.println("Receive New Message");
                ActiveMQObjectMessage queueMessage=(ActiveMQObjectMessage)message;
                Object payload=queueMessage.getObject();
                if (payload instanceof OrderStruc) {
                    //     System.out.println("Extracting New Message");
                    i++; // Buat Debug
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
                    String d = sdf.format(date);
                    OrderStruc ord= (OrderStruc)payload;
                    String clid = ord.getClientID();

                    // Buat Debug
                    //      System.out.println(i + ": clientid :" + clid + " ; waktu : " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
                    if (i % 20000 == 0) {
                        System.out.println(i + ": clientid :" + clid + " ; waktu : " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
                    }

                    if (i  == 1) {
                        System.out.println("Jumlah : "+ i +" ; waktu : " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
                    }
                }

            } catch (JMSException ex) {
                Logger.getLogger(MQDummySubscriber.class.getName()).log(Level.SEVERE, null, ex);
                isStop = true;
            }
        }
        if (FConnection != null) {
            try {
                FConnection.close();
                System.out.println("Consumer Connection Closed");
            } catch (JMSException ex) {
                Logger.getLogger(MQDummySubscriber.class.getName()).log(Level.SEVERE, null, ex);
                isStop = true;
            }
        }

        FStatus = false;
    }

    private int connect() {
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
            Logger.getLogger(MQDummySubscriber.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MQDummySubscriber.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MQDummySubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("BYE");
    }
}

public class DummyService {
    public static void main(String[] args) {
        MQDummySubscriber x = new MQDummySubscriber("tcp://127.0.0.1:61616?tcpNoDelay=true","OQ");
        x.start();

    }
}
