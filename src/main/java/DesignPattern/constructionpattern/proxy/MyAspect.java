package designpattern.constructionpattern.proxy;

import org.springframework.context.annotation.EnableAspectJAutoProxy;


public class MyAspect implements comunicationInterface {
    public void saiSSS(){
        System.out.println("SSS");
    }
    @Override
    public void sayHi() {
        System.out.println("hi");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("bye");
    }
}
