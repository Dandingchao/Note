package spring.service;


import org.springframework.stereotype.Service;

@Service
public class Server3 extends server2{
    public void server(){
        service1.sayHi();
        System.out.println("I'm server3");
    }
}
