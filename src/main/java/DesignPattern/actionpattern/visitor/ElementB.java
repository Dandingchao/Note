package designpattern.actionpattern.visitor;

public class ElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitB(this);
    }
    public String operatorB(){
        return "this is Element B";
    }
}
