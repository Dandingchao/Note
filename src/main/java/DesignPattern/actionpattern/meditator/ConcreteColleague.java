package designpattern.actionpattern.meditator;

public class ConcreteColleague extends Colleague{
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void recive() {
        System.out.println("I recive the message");
    }

    @Override
    public void send() {
        System.out.println("I send a request");
        mediator.relay(this);
    }
}
