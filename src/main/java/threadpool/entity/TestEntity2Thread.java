package threadpool.entity;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 创建线程，打印当前JVM的进程ID和线程名和时间
 */
public class TestEntity2Thread implements Callable<Integer>{
    private String hello;
    private int count;

    @Override
    public Integer call() throws Error,Exception{
        boolean flag=true;
        while (flag){
            try {
                Thread.sleep(5000);
                System.out.println("say hi"+hello);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date=new Date(System.currentTimeMillis());
                String name = ManagementFactory.getRuntimeMXBean().getName();
                String[] da =name.split("@");
                System.out.println("Now pid is"+da[0]+",now Time is "+date+",now thread is "+Thread.currentThread().getName());
            } catch (Error e) {
                e.printStackTrace();
            }
            /*System.out.println("say hi"+hello);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date=new Date(System.currentTimeMillis());
            String name = ManagementFactory.getRuntimeMXBean().getName();
            String[] da =name.split("@");
            System.out.println("Now pid is"+da[0]+",now Time is "+date+",now thread is "+Thread.currentThread().getName());
            flag=false;
            if (hello=="123") {
                break;
            }*/
        }
        return new Integer(2);
    }
}
