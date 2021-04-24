package juc.reentranreadwritelock;

import threadpool.poolentity.Pool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//读写锁，读写锁同锁，获取读锁后，可以重入，可以其他读操作也可以获得锁，写操作无法获得锁。
//获取写锁后，其他锁操作都被阻塞，是否公平锁的创建方式同reentrantlock
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new Pool().getThreadPoolExecutor();
        ThreadForReadWrite threadForReadWrite=new ThreadForReadWrite();
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        threadForReadWrite.setReentrantReadWriteLock(reentrantReadWriteLock);
        for (int i=0;i<10;i++){
            pool.execute(threadForReadWrite);
        }
    }
}
