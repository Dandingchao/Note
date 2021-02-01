package spring.service;


import org.springframework.stereotype.Service;

@Service
public class Server3 extends Server2 {
    public void server(){
        service1.sayHi();
        System.out.println("I'm server3");
    }
    public void sayHi(){
        System.out.println("Hi I'm Server3");
    }
}
