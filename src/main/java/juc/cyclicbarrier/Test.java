package juc.cyclicbarrier;

import threadpool.poolentity.Pool;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

//cyclicbarrier，将当前线程阻塞，直至线程数量达到规定的个数时唤醒线程继续执行
//带有方法,await,阻塞当前线程,获取栅栏大小，当前等待数，栅栏是否损坏,重置计数
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new Pool().getThreadPoolExecutor();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(10);
        ThreadForCyclicBarrier threadForCyclicBarrier=new ThreadForCyclicBarrier();
        threadForCyclicBarrier.setCyclicBarrier(cyclicBarrier);
        for (int i=0;i<10;i++){
            threadPoolExecutor.execute(threadForCyclicBarrier);
        }

    }
}
