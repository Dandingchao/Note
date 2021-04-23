package juc.semaphore;

import threadpool.poolentity.Pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
//信号量，当线程获取到信号量时可以执行某些操作，构造函数允许构建非公平获取方式
//未获取到信号量则阻塞
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new Pool().getThreadPoolExecutor();
        ThreadForSemaphore threadForSemaphore=new ThreadForSemaphore();
        Semaphore semaphore=new Semaphore(5);
        threadForSemaphore.setSemaphore(semaphore);
        for (int i=0;i<100;i++){
            threadPoolExecutor.execute(threadForSemaphore);
        }
    }
}
