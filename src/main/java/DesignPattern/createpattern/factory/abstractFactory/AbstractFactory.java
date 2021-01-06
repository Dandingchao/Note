package designpattern.createpattern.factory.abstractFactory;
//定义一个接口，给出产品的生产函数，具体实现交由具体的实现类去实现.此处用常用对象类型替换可能使用类型
public interface AbstractFactory {
    public Integer newProduct1();
    public String newProduct2();
}
