package spring.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class Singleton {
    private static volatile Singleton singleton=null;
    public Integer t=1;
    ThreadLocal<Integer> integerThreadLocal=new ThreadLocal<>();
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }

    private Singleton() {
        System.out.println("I'm inisilized");
        this.t = 123;
    }

}
