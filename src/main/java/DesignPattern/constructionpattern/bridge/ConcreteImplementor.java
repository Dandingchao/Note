package designpattern.constructionpattern.bridge;

public class ConcreteImplementor implements Implementor{
    @Override
    public void saiHi() {
        System.out.println("hi");
    }
}
