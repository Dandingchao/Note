package DesignPattern.proxy.staticmethod;

import DesignPattern.proxy.comunicationInterface;

public class comunicationProxy implements DesignPattern.proxy.comunicationInterface {
    private comunicationInterface comunicationInterface;
    public comunicationProxy(comunicationInterface comunicationInterface){
        this.comunicationInterface=comunicationInterface;
    }
    @Override
    public void sayHi() {
        System.out.println("I'm proxy, I will say hi");
        this.comunicationInterface.sayHi();
    }

    @Override
    public void sayGoodBye() {
        System.out.println("I'm proxy I will say goodbye");
        this.comunicationInterface.sayGoodBye();
    }
}
