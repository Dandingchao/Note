package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import spring.service.service1;

import javax.annotation.Resource;

@Configuration
@ComponentScan()
public class Config {

    /**
    * @Description:
    * @Param: [] 
    * @returns: void 
    * @Author: ypc 
    * @Date: 2021/1/4 16:17
    */
    public void sayHi(){
        System.out.println("hi,I'm config");
    }
}
