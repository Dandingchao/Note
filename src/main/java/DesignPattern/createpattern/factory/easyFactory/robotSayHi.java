package designpattern.createpattern.factory.easyFactory;

public class robotSayHi implements sayHi{
    @Override
    public void sayHi() {
        System.out.println("I'm robot hi");
    }
}
