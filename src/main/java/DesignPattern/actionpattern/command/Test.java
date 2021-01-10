package designpattern.actionpattern.command;

public class Test {
    @org.junit.Test
    public void test(){
        Invoker invoker=new Invoker(new ConcreteCommand(new Reciver()));
        invoker.call();
    }
}
