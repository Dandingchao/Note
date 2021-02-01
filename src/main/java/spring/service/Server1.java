package spring.service;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Data
@Lazy
@Service
public class Server1 {
    private String name;
    public Server1(){
        String test="sdasada";
        System.out.println("initializing");
        test.toUpperCase();
        System.out.println(test);
    }
    public void sayHi(){
        System.out.println("hi,I'm server1");
    }
}