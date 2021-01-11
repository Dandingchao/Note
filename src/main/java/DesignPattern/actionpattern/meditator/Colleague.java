package designpattern.actionpattern.meditator;

public abstract class Colleague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void recive();
    public abstract void send();
}
