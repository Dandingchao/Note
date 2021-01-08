package designpattern.constructionpattern.decorator;

public class ManDecorator extends Decorator {

    public ManDecorator(Man man) {
        super(man);
    }
    @Override
    public void saiHi(){
        decoratorMethod();
        super.saiHi();
    }

    public void decoratorMethod(){
        System.out.println("I do the thing Man can't do");
    }
}
