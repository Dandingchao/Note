package entity;

public class Testentity4ThreadSychronized implements Runnable{
    private int count;

    private volatile int count2;

    private static volatile int t=2;
    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void say(){
        t=2;
        System.out.println("hi I'm "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("say over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//方法锁

    public void say2(){
        synchronized (Testentity4ThreadSychronized.class){//锁类，静态方法或实例方法都被锁住
            t=4;
            System.out.println("hi I'm "+Thread.currentThread().getName());
            try {
                System.out.println("I'm locked "+Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("say2 over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//类锁等价于锁静态方法
    public void say3(){
            System.out.println("I'm not locked");
    }//无锁

    public static synchronized void say4(){

        System.out.println("I'm say4");
    }//静态锁

    public void run() {
        if (t==1){
            say();
        }else if (t==2){
            say2();
        }else if (t==3){
            say3();
        }else if (t==4) {
            say4();
        }
    }
}
