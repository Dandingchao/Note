package designpattern.constructionpattern.proxy;

public class comunicationService implements comunicationInterface {
    @Override
    public void sayHi() {
        System.out.println("Hi");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("GoodBye");
    }
}
