package designpattern.actionpattern.observer;

public class ConcreteSubject extends Subject{
    public void notifyObserver(){
        System.out.println("SubjectChange");
        System.out.println("notifyOberser");
        for (Observer ob:
             this.list) {
            ob.response();
        }
    }
}
