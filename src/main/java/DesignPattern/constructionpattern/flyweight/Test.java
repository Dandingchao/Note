package designpattern.constructionpattern.flyweight;

import org.springframework.beans.factory.annotation.Autowired;
/**
* @Description: nihaoa作为一个key值把一个对象存储进
 * 去了，之后如果还需要key是nihaoa就不用心创建了flyweight对象了，可以直接从池hashmap中获取，后面的unsharedinfom在使用的时候创建新的作为参数进去
* @Param:
* @returns:
* @Author: ypc 
* @Date: 2021/1/8 16:24
* @packageName: designpattern.constructionpattern.flyweight
*/
public class Test {
    @org.junit.jupiter.api.Test
    public void Test(){
        FlyweightFactory flyweightFactory=new FlyweightFactory();
        flyweightFactory.getFlyweight("nihaoa").sayHiAndInfom(new UnsharedInform("UNSHAREDINFOM"));
        
    }
}
