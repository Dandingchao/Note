package designpattern.actionpattern.chainofresponsibility;

public class HandlerB extends Handler {
    public HandlerB(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(String request) {
        if (request.equals("B")){
            this.executeMehod(request);
        }else if (this.getNext()!=null){
            this.getNext().execute(request);
        }else {
            System.out.println("NNONONON");
        }
    }
    private void executeMehod(String rquest){
        System.out.println("I handle this method B");
    }
}
