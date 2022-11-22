package Services.DummyOrderListPublisher;

public class DummySender extends Thread {

    private boolean status;

    void DummySender() {
        status = true;
    }

    @Override
    public void run() {
        super.run();
        while (status) {

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }


    }


    public void Stop() {

        status = false;
    }
}
