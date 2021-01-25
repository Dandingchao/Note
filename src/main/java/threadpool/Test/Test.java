package threadpool.Test;

import threadpool.entity.TestEntity4ThreadSychronized;

public class Test {
    public static void main(String[] args) {
        TestEntity4ThreadSychronized a=new TestEntity4ThreadSychronized();
        Thread thread1=new Thread(a);
        Thread thread2=new Thread(a);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ready to run");
        thread2.start();
    }
}
