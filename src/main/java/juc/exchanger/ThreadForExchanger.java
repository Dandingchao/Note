package juc.exchanger;

import java.util.concurrent.Exchanger;

public class ThreadForExchanger implements Runnable{
    private Exchanger<Integer> exchanger;
    private Integer myInteger;

    public Exchanger<Integer> getExchanger() {
        return exchanger;
    }

    public void setExchanger(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    public Integer getMyInteger() {
        return myInteger;
    }

    public void setMyInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread()+"I begin exchange Integer"+exchanger.exchange(myInteger));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
