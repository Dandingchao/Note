package designpattern.createpattern.singleton;
/**
* @Description: 懒汉模式通过双重锁创建单例，如果是饿汉模式，直接用static创建就行了，好处是开始就创建，缺点也是开始就创建
* @Param:  
* @returns:  
* @Author: ypc 
* @Date: 2021/1/6 15:00
* @packageName: designpattern.singleton
*/
public class SingletonEntity1 {
    private String name;
    private Integer count;
    private static volatile SingletonEntity1 singletonEntity1=null;
    public SingletonEntity1 getSingletonEntity1(){
        if (singletonEntity1==null){
            synchronized (SingletonEntity1.class){
                if (singletonEntity1==null){
                    singletonEntity1=new SingletonEntity1();
                }
            }
        }
        return this.singletonEntity1;
    }
    private SingletonEntity1(){
        name="SingletonEntity1";
        count=0;
    }
}
