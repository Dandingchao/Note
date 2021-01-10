package designpattern.actionpattern.template;

public abstract class Template {
    public void templateMethod(){
        sayHi();
        doSomething();
        doSomething2();
    }
    public void sayHi(){
        System.out.println("hi");
    }
    public abstract void doSomething();
    public abstract void doSomething2();
}
