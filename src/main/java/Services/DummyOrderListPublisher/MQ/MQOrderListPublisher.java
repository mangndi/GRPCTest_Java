package Services.DummyOrderListPublisher.MQ;


import Model.DataOrder;
import Model.OrderStruc;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.io.Serializable;

public class MQOrderListPublisher {
    String userid = "admin";
    String password = "admin";
    String url = "tcp://127.0.0.1:61616";
    String queue ="QRI";// "QRI";

    ConnectionFactory factory;
    Connection connection;
    Session session;
    Destination destination;
    MessageProducer producer;


    public MQOrderListPublisher(String _userid,String _password,String _url, String _queue)   {
        userid = _userid;
        password = _password;
        url = _url;
        queue = _queue;

    }

    //   public void send(ObjectMessage obj) throws JMSException {
    public void send(DataOrder ord) throws JMSException {
        try {
            ObjectMessage obj =  session.createObjectMessage(ord);
            int x = 0;
            //     while (x < 100000) {
            producer.send(obj);
            //         x++;
            //    }
        } catch (JMSException e) {
            System.out.println(e.toString());
        }
    }


    public boolean start() {
        factory = new ActiveMQConnectionFactory(userid,password, url);

        try {
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queue);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            return true;
        }catch (JMSException e ) {
            e.printStackTrace();
            return false;
        }
    }

    public void stop() throws JMSException {
        producer.close();
        session.close();
        connection.stop();

    }


}
