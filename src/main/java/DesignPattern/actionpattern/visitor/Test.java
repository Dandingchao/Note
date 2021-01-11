package designpattern.actionpattern.visitor;

public class Test {
    @org.junit.Test
    public void test(){
        ObjectStructure objectStructure=new ObjectStructure();
        objectStructure.add(new ElementA());
        objectStructure.add(new ElementB());
        Visitor visitor=new VisitorA();
        objectStructure.accept(visitor);
    }
}
