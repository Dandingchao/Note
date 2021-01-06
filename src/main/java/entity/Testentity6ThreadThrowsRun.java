package entity;

public class Testentity6ThreadThrowsRun implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
