package designpattern.actionpattern.state;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle(){//进行处理，同时调用状态类回调自身改变自身的状态
        this.state.handle(this);
    }
}
