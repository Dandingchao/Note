package spring.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class ServerAspect {
    @Resource
    AfterServer afterServer;

    @Pointcut("execution (* *.sayHi())")
    public void aspect(){
    }

    @Pointcut("execution (* *.sayOver())")
    public void beforeOver(){
    }

    @Pointcut("execution(* *.rightCount())")
    public void rightCount(){
    }

    @Pointcut("execution(* *.wrongCount())")
    public void wrongCount(){
    }

    @AfterReturning(value = "rightCount()")
    public void isRight(){
        System.out.println("the method run succeed");
    }

    @Before(value = "wrongCount()")
    public void thro()throws Exception{
        System.out.println("wrong");
    }
    @AfterReturning(pointcut = "wrongCount()")
    public void isWrong(){
        System.out.println("the method run succeed");
    }

    @AfterThrowing(throwing = "ex",pointcut = "wrongCount()")
    public void Wrong(Throwable ex) throws Exception{
        System.out.println("this method run failed");
        try {
            throw ex;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @After("wrongCount()")
    public void Lst(){
        System.out.println("I will be executed definitely");
    }

    @Before(value = "aspect()")
    public void sayAngry(){
        System.out.println("I'm angry");
    }

    @Before(value = "beforeOver()")
    public void beforeAngryJudge(){
        System.out.println("Am I angry?");
    }

    @After(value = "spring.aspect.ServerAspect.aspect()")
    public void sayOver(){
        afterServer.sayOver();
    }
}
