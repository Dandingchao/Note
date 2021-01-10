package designpattern.actionpattern.chainofresponsibility;

public abstract class Handler {
    private Handler next;

    public Handler(Handler handler) {
        this.next = handler;
    }

    public Handler getNext(){
        return this.next;
    }
    public abstract void execute(String request);
}
