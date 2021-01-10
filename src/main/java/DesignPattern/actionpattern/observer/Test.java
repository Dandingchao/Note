package designpattern.actionpattern.observer;

public class Test {
    @org.junit.Test
    public void test(){
        Subject subject=new ConcreteSubject();
        subject.addList(new ConcreteObserverA());
        subject.addList(new ConcreteObserverB());
        subject.notifyObserver();
    }
}
