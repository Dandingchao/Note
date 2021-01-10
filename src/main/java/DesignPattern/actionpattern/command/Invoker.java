package designpattern.actionpattern.command;

public class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command=command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void call(){
        System.out.println("执行命令");
        command.execute();
    }
}
