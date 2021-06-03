package juc.semaphore;

import java.util.concurrent.Semaphore;


//acquire blocing , tryacuqire non-blocking
public class ThreadForSemaphore implements Runnable{
    private Semaphore semaphore;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread()+" is using the semaphore sleep 2000ms");
            Thread.sleep(2000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
