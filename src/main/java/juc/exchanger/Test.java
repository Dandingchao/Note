package juc.exchanger;

import threadpool.poolentity.Pool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadPoolExecutor;
//exchanger会阻塞线程直至交换完成，交换完成后，返回交换得到的结果。不会给成员赋值，需要手动操作
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new Pool().getThreadPoolExecutor();
        ThreadForExchanger t1=new ThreadForExchanger();
        ThreadForExchanger t2=new ThreadForExchanger();
        Exchanger<Integer> exchanger=new Exchanger<>();
        t1.setExchanger(exchanger);
        t2.setExchanger(exchanger);
        t1.setMyInteger(23);
        t2.setMyInteger(24);
        threadPoolExecutor.execute(t1);
        threadPoolExecutor.execute(t2);
        try {
            Thread.sleep(2000);
            System.out.println(t1.getMyInteger());
            System.out.println("~~~~");
            System.out.println(t2.getMyInteger());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
