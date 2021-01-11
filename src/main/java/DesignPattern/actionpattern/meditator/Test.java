package designpattern.actionpattern.meditator;

public class Test {
    @org.junit.Test
    public void test(){
        Mediator mediator=new ConcreteMediator();
        mediator.register(new ConcreteColleague());
        mediator.register(new ConcreteColleague());
        Colleague colleague=new ConcreteColleague();
        mediator.register(colleague);
        colleague.send();
    }
}
