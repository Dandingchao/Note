package threadpool.entity;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 创建一个线程，令其报错
 */
public class TestEntity1Thread implements Runnable {
    private String hello;
    private int count;
    private List<Integer> list;
    @Override
    public void run() {
        int count=1;
        boolean flag = true;
        while (flag) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String name = ManagementFactory.getRuntimeMXBean().getName();
            String[] da = name.split("@");
            System.out.println("Now thread pid is" + da[0] + ",now Time is " + date + ",now thread is " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
                if (count==1){
                    count=2;
                    System.out.println(list.get(1));
                }else{
                    count=1;
                    System.out.println(list.get(100));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*System.out.println("say hi" + hello);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String name = ManagementFactory.getRuntimeMXBean().getName();
            String[] da = name.split("@");
            System.out.println("Now pid is" + da[0] + ",now Time is " + date + ",now thread is " + Thread.currentThread().getName());
            flag=false;*/
        }
    }

    public void say(){
        System.out.println("say");
    }

    public void say(String name){
        System.out.println("say"+name);
    }
}
