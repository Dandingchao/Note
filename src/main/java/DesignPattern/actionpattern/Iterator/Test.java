package designpattern.actionpattern.Iterator;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test(){
        Aggregate aggregate=new ConcreteAggregate();
        aggregate.add("中山大学");
        aggregate.add("广州大学");
        Iterator iterator=aggregate.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
