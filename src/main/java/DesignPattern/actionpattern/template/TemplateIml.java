package designpattern.actionpattern.template;

public class TemplateIml extends Template{
    @Override
    public void doSomething() {
        System.out.println("I do something");
    }

    @Override
    public void doSomething2() {
        System.out.println("I do something 2");
    }
}
