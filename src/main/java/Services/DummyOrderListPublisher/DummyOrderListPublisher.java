package Services.DummyOrderListPublisher;

import Model.DataOrder;
import Services.DummyOrderListPublisher.MQ.MQOrderListPublisher;

public class DummyOrderListPublisher {
    private static MQOrderListPublisher mqOrderListPublisher;
    private static String ipAddress;
    private static int port;
    private static String userID;
    private static String password;
    private static String url;
    private static String topic;
    private static int i = 0;
    private static DataOrder getDataOrder() {
        DataOrder dataOrder = new DataOrder();
        i++;
        dataOrder.ID = i;
        dataOrder.DeviceOrderID = i;
        dataOrder.OrderID = i;
        dataOrder.ClientID = "ABCD";
        dataOrder.OrderTime = "05:10:25";
        dataOrder.Symbol = "ASII"+i;
        dataOrder.Board = "RG";
        dataOrder.Exchange = "IDX";
        dataOrder.Qty = 300;
        dataOrder.MatchQty = 180;
        dataOrder.CanceledQty = 20;
        dataOrder.Price = 2500;
        dataOrder.Status = "M";
        dataOrder.desc = "Done";
        dataOrder.UserID = "ABC";
        dataOrder.ForcedToSell = 0;


        return dataOrder;
    }

    public static void main(String[] args) {

        userID = "admin";
        password = "admin";
        url = "tcp://127.0.0.1:61616";;
        topic = "OReply";
        mqOrderListPublisher = new MQOrderListPublisher(userID,password,url,topic);
        if (mqOrderListPublisher.start()) {
            try {
                mqOrderListPublisher.send(getDataOrder());
                System.out.println("Sent");
                mqOrderListPublisher.stop();
            } catch (Exception e) {
                System.out.println("Sending Error");
            }
        } else {
            System.out.println("Service not started");
        }
        System.out.println("Service stoped");
    }
}
