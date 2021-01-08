package designpattern.constructionpattern.decorator;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Man man=new ConcreteMan();
        man.saiHi();
        System.out.println("--------------------");
        Man man1=new ManDecorator(man);
        man1.saiHi();
        Man man2=new Decorator(man);
        man2.saiHi();
    }
}
