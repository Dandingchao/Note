package spring;

import spring.entity.Singleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.service.CountServer;
import spring.service.Server1;
import spring.service.Server2;
import spring.service.Server3;
import sun.nio.ch.ThreadPool;
import threadpool.model.Entity1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        for (String name:
             applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println();
       /* Server2 server2=(Server2)applicationContext.getBean("server2");
        server2.sayHi();*/
        CountServer countServer=(CountServer)applicationContext.getBean("countServer");
        countServer.rightCount();
        try {
            countServer.wrongCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        /*Server3 server3=(Server3) applicationContext.getBean("server3");
        server3.server();*/
        //service1 service =(service1)applicationContext.getBean("service1");
        //service.sayHi();
        ApplicationContext applicationContext1=new AnnotationConfigApplicationContext();
    }
}
