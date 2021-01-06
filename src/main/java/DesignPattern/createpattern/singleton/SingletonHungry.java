package designpattern.createpattern.singleton;

public class SingletonHungry {
    private String name;
    private Integer count;
    private static SingletonHungry singletonHungry=new SingletonHungry();

    private SingletonHungry(){
        name="SingletonHungry";
        count=0;
    }
    public SingletonHungry getSingletonHungry(){
        return singletonHungry;
    }
}
