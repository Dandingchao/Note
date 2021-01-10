package designpattern.actionpattern.state;

public class StateB extends State{
    @Override
    public void handle(Context context) {
        System.out.println("现在是状态B，执行之后改变状态");
        context.setState(new StateA());
    }
}
