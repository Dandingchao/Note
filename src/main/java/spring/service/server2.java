package spring.service;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class server2 {
    @Resource
    service1 service1;
    public void server(){
        service1.sayHi();
        System.out.println("I'm server2");
    }

}
