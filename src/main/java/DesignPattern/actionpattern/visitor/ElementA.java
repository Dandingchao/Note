package designpattern.actionpattern.visitor;

public class ElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitA(this);
    }
    public String operationA(){
        return "具体元素A的操作";
    }
}
