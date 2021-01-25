import threadpool.entity.TestEntity1Thread;
import threadpool.entity.TestEntity2Thread;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j

public class biexiele {
    private int a;
    public static void main(String[] args) {
        DaddyDog t=DaddyDog.getDaddyDog();
        Dog tdsa=new Dog();
        tdsa.setAge(15);
        tdsa.setName("dsjaioda");
        String jsondog=JSON.toJSONString(tdsa);
        JSONObject jsonObject=JSON.parseObject(jsondog);
        System.out.println(jsonObject);
        System.out.println(jsondog);
        SingletonPattern singletonPattern=SingletonPattern.getInstance();
        System.out.println(singletonPattern==SingletonPattern.getInstance());

        Map<String,Integer> dja=new HashMap<String, Integer>();
        dja.put("sadj",5);
        dja.get("sadj");
        //创建线程
        ExecutorService fixedThreadPool=Executors.newFixedThreadPool(10);
        TestEntity1Thread testentity1Thread=new TestEntity1Thread();
        TestEntity2Thread testentity2Thread=new TestEntity2Thread();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(testentity2Thread);
        Thread thread=new Thread(testentity1Thread);
        Thread thread1=new Thread(futureTask);
        Future taszxc=fixedThreadPool.submit(thread,"hi");
        //打印实现runnable接口的线程的返回值
        System.out.println("----------------------------------");
        fixedThreadPool.submit(thread);//提交线程1
        //fixedThreadPool.submit(thread1);
        //fixedThreadPool.execute(thread1);
        //启动两个线程
        thread.start();
        thread1.start();
        //打印线程返回值
        System.out.println("----------------------------------");
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------");



        //显示一下当前进程的id
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] da = name.split("@");
        System.out.println("Now pid is" + da[0] + ",now Time is " + date + ",now thread is " + Thread.currentThread().getName());



    }
}
