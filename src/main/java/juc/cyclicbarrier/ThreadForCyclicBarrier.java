package juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadForCyclicBarrier implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread()+"arriver the barrier");
            System.out.println("cycis broker?"+cyclicBarrier.isBroken()+"cyclicbarrier part is "+cyclicBarrier.getParties()+" now waiting:"+cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await();
            cyclicBarrier.reset();
            System.out.println(Thread.currentThread()+"over the barrier");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
