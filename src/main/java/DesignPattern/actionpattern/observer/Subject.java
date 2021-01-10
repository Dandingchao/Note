package designpattern.actionpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> list =new ArrayList<>();
    public abstract void notifyObserver();
    public void addList(Observer observer){
        list.add(observer);
    }
    public void removeList(Observer observer){
        list.remove(observer);
    }
}
