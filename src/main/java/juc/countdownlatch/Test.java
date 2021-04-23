package juc.countdownlatch;

import threadpool.poolentity.Pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//使用countdownlatch阻塞当前线程，直至countdownlatch计数结束
//阻塞线程join也可以做到，但是如果阻塞的部分不需要被join的线程全部执行完只需要部分执行完时，则只能使用countdownlatch
public class Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        ThreadPoolExecutor threadPoolExecutor=new Pool().getThreadPoolExecutor();
        ThreadForCountDownLatch threadForCountDownLatch=new ThreadForCountDownLatch();
        threadForCountDownLatch.setCountDownLatch(countDownLatch);
        Thread t=new Thread(threadForCountDownLatch);
        for (int i=0;i<10;i++){
            threadPoolExecutor.execute(threadForCountDownLatch);
        }
        try {
            System.out.println("countdownlatch begin wait");
            countDownLatch.await();
            System.out.println("wait over");
            System.out.println(countDownLatch.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
