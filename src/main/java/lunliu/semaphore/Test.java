package lunliu.semaphore;

import lunliu.semaphore.thread.*;
import threadpool.poolentity.Pool;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new Pool().getThreadPoolExecutor();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(1);
        ThreadFirstPrint threadFirstPrint = new ThreadFirstPrint();
        ThreadSecondPrint threadSecondPrint = new ThreadSecondPrint();
        threadFirstPrint.setSemaphore1(semaphore1);
        threadFirstPrint.setSemaphore2(semaphore2);
        threadFirstPrint.setSemaphore3(semaphore3);
        threadSecondPrint.setSemaphore1(semaphore1);
        threadSecondPrint.setSemaphore2(semaphore2);
        threadSecondPrint.setSemaphore3(semaphore3);
        pool.execute(threadFirstPrint);
        pool.execute(threadSecondPrint);
    }
}
