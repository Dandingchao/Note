package designpattern.createpattern.factory.easyFactory;

public class factory {//一个工厂类，给参数，返回需要创建的类型
    public sayHi create(String param){
        if (param.equals("robot")){
            return new robotSayHi();
        }
        return null;
    }
}
