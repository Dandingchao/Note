package juc.reentranlock;


import threadpool.poolentity.Pool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//reentranlock,一把锁，需要手动加锁和释放,构造函数中添加boolean变量用于确定创建的是公平锁还是非公平锁
//非公平锁会在判断当前无锁时和已经存在等待队列中的线程用cas竞争获取锁，因为存在队列中的头部线程被唤醒后没有竞争过当前线程获取锁，故非公平
//trylock仅会在没有其他线程竞争的情况下获取，lock则是尽力获取锁,trylock可一定程度上避免死锁，因为锁不可用时会马上释放
//condition允许锁提前唤醒处于等待队列中的线程，可以设置条件让当前在等待队列中的线程提醒唤醒并获取锁。(不能抢占当前锁，只是允许他提前醒来，如果是非公平锁让其早点醒来竞争)
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new Pool().getThreadPoolExecutor();
        ThreadForReenTrantLock tread=new ThreadForReenTrantLock();
        ReentrantLock reentrantLock=new ReentrantLock(false);
        Condition condition=reentrantLock.newCondition();
        condition.notify();
        tread.setReentrantLock(reentrantLock);
        for (int i=0;i<10;i++){
            pool.execute(tread);
        }
    }
}
