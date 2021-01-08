package designpattern.constructionpattern.flyweight;

import java.util.*;

public class FlyweightFactory {
    Map<String,Flyweight> flyweightMap=new HashMap<>();
    public Flyweight getFlyweight(String key){
        if(flyweightMap.get(key)==null){
            Flyweight flyweight=new FlyweightImpl(key);
            flyweightMap.put(key,flyweight);
        }
        return flyweightMap.get(key);
    }
}
