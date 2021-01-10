package designpattern.actionpattern.observer;

public class ConcreteObserverA implements Observer{
    @Override
    public void response() {
        System.out.println("response A");
    }
}
