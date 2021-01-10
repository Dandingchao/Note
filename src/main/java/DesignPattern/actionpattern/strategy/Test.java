package designpattern.actionpattern.strategy;

public class Test {
    @org.junit.Test
    public void Test(){
        Context context=new Context(new StrategyMethodA());
        context.strategyMehod();
    }
}
