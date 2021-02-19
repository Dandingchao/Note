package spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import threadpool.model.Entity1;

@Configuration
@ComponentScan()
@EnableAspectJAutoProxy
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

    @Bean
    public Entity1 entity1(){
        return new Entity1();
    }
}
