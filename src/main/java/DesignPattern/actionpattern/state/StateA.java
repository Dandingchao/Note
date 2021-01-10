package designpattern.actionpattern.state;

public class StateA extends State{
    @Override
    public void handle(Context context) {
        System.out.println("现在是状态A,执行完毕之后变成状态B");
        context.setState(new StateB());
    }
}
