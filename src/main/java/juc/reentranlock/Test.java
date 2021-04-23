package juc.reentranlock;


import threadpool.poolentity.Pool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

//reentranlock,一把锁，需要手动加锁和释放,构造函数中添加boolean变量用于确定创建的是公平锁还是非公平锁
//非公平锁会在判断当前无锁时和已经存在等待队列中的线程用cas竞争获取锁，因为存在队列中的头部线程被唤醒后没有竞争过当前线程获取锁，故非公平
//trylock仅会在没有其他线程竞争的情况下获取，lock则是尽力获取锁
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new Pool().getThreadPoolExecutor();
        ThreadForReenTrantLock tread=new ThreadForReenTrantLock();
        ReentrantLock reentrantLock=new ReentrantLock(false);
        tread.setReentrantLock(reentrantLock);
        for (int i=0;i<10;i++){
            pool.execute(tread);
        }
    }
}
