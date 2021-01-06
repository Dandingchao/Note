package entity;

public class SingletonPattern {//单例模式实际上存在一个只指向自身的指针/引用
    private String name;
    private static SingletonPattern singletonPattern;
    public static SingletonPattern getInstance(){
        if(singletonPattern==null){
            synchronized (SingletonPattern.class){
                if (singletonPattern==null){
                    singletonPattern=new SingletonPattern();
                }
            }
        }
        return singletonPattern;
    }
    private SingletonPattern(){
    }

}
