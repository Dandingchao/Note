package spring;

import spring.entity.Singleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.service.service1;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        for (String name:
             applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("____________");
        Singleton singleton=(Singleton)applicationContext.getBean("singleton");
        Singleton singleton1=Singleton.getSingleton();
        Singleton singleton2=Singleton.getSingleton();
        Config config=(Config)applicationContext.getBean("config");
        config.sayHi();
        System.out.println(singleton.t);
        System.out.println(singleton==singleton1);
        System.out.println(singleton1==singleton2);
        System.out.println(singleton1.t);
        //service1 service =(service1)applicationContext.getBean("service1");
        //service.sayHi();
        ApplicationContext applicationContext1=new AnnotationConfigApplicationContext();
    }
}
