package designpattern.actionpattern.state;

public class Test {
    @org.junit.Test
    public void test(){
        Context context=new Context(new StateA());
        context.handle();
    }
}
