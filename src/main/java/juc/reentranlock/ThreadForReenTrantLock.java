package juc.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadForReenTrantLock implements Runnable{
    private ReentrantLock reentrantLock;

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }

    public void setReentrantLock(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        try {
            reentrantLock.tryLock();
            System.out.println(Thread.currentThread()+" get the lock and sleep 2000 ms");
            Thread.sleep(2000);
            reentrantLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
