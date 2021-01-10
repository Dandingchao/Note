package designpattern.actionpattern.command;

public class ConcreteCommand implements Command{
    private Reciver reciver;

    public ConcreteCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    public Reciver getReciver() {
        return reciver;
    }
    @Override
    public void execute() {
        reciver.executeMehod();
    }
}
