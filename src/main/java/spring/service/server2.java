package spring.service;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Server2 {
    @Resource
    Server1 service1;
    public void server(){
        service1.sayHi();
        System.out.println("I'm server2");
    }
    public void sayHi(){
        System.out.println("Hi,I'm Server2");
    }

}
