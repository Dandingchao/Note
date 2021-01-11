package designpattern.actionpattern.visitor;

public class VisitorA implements Visitor{
    @Override
    public void visitA(ElementA elementA) {
        System.out.println("visit A"+elementA.operationA());
    }

    @Override
    public void visitB(ElementB elementB) {
        System.out.println("visit B"+elementB.operatorB());
    }
}
