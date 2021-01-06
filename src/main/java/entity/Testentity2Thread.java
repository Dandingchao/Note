package entity;

import org.omg.CORBA.Current;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.logging.SimpleFormatter;

public class Testentity2Thread implements Callable<Integer>{
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
