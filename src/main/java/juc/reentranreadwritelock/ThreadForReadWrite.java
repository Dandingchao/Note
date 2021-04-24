package juc.reentranreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadForReadWrite implements Runnable {
    private ReentrantReadWriteLock reentrantReadWriteLock;

    public ReentrantReadWriteLock getReentrantReadWriteLock() {
        return reentrantReadWriteLock;
    }

    public void setReentrantReadWriteLock(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }

    @Override
    public void run() {
        try {
            double a = 1;
            if (a !=1) {
                System.out.println(Thread.currentThread()+" is trying get readlock");
                reentrantReadWriteLock.readLock().lock();
                System.out.println(reentrantReadWriteLock.getReadHoldCount());
                System.out.println(reentrantReadWriteLock.getQueueLength());
                System.out.println(reentrantReadWriteLock.getReadLockCount());
                System.out.println("succeed and sleep 2000ms");
                Thread.sleep(2000);
                reentrantReadWriteLock.readLock().unlock();
            }else {
                System.out.println(Thread.currentThread()+" is trying get writelock");
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("succeed write and sleep 2000ms");
                Thread.sleep(2000);
                reentrantReadWriteLock.writeLock().unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
