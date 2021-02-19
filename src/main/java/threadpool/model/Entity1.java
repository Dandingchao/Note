package threadpool.model;

public class Entity1 implements Runnable{

    @Override
    public void run() {
        System.out.println("hi");
    }
}
