package designpattern.actionpattern.chainofresponsibility;

public class Test {
    @org.junit.Test
    public void test(){
        Handler handler=new HandlerA(new HandlerB(null));
        handler.execute("A");
        handler.execute("B");
        handler.execute("C");
    }
}
