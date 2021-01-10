package designpattern.actionpattern.state;

public abstract class State {
    public abstract void handle(Context context);//改变这个执行类的状态
}
