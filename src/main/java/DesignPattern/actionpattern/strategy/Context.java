package designpattern.actionpattern.strategy;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public void strategyMehod(){
        strategy.strategtMethod();
    }
}
