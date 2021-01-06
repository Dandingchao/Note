package DesignPattern.proxy.staticmethod;

import DesignPattern.proxy.comunicationInterface;
import DesignPattern.proxy.comunicationService;

public class Test {
    public static void main(String[] args) {
        comunicationInterface comunicationInterface=new comunicationService();
        comunicationProxy comunicationProxy=new comunicationProxy(comunicationInterface);
        comunicationProxy.sayHi();
        comunicationProxy.sayGoodBye();
    }
}
