package threadpool.entity;

public class TestEntity6ThreadThrowsRun implements Runnable{

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
