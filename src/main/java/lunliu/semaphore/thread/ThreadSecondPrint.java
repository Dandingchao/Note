package lunliu.semaphore.thread;

import lombok.Data;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class ThreadSecondPrint implements Runnable {
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;
    private ReentrantLock reentrantLock;
    private CyclicBarrier cyclicBarrier;
    private Integer integer =2;
    @Override
    public void run() {
        while (integer < 102) {
            try {
                semaphore2.acquire();
                semaphore3.acquire();
                System.out.println(integer.toString()+Thread.currentThread());
                integer+=2;
                semaphore1.release();
                semaphore3.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
