package designpattern.actionpattern.chainofresponsibility;

public class HandlerA extends Handler{
    public HandlerA(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(String request) {
        if (request.equals("A")){
            executeA(request);
        }else if (this.getNext()!=null){
            this.getNext().execute(request);
        }else {
            System.out.println("this request has not Handle Method");
        }

    }
    private void executeA(String request){
        System.out.println("I handle this request A");
    }
}
