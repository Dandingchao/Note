package designpattern.constructionpattern.bridge;

public class Test {
    @org.junit.jupiter.api.Test
    public void Test() {
        Implementor implementor=new ConcreteImplementor();
        AbstractChara A=new Jack(implementor);
        A.saiHi();
    }
}
