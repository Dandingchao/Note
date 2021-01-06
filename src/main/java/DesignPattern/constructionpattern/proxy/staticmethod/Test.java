package designpattern.constructionpattern.proxy.staticmethod;

import designpattern.constructionpattern.proxy.comunicationInterface;
import designpattern.constructionpattern.proxy.comunicationService;

public class Test {
    public static void main(String[] args) {
        comunicationInterface comunicationInterface=new comunicationService();
        comunicationProxy comunicationProxy=new comunicationProxy(comunicationInterface);
        comunicationProxy.sayHi();
        comunicationProxy.sayGoodBye();
    }
}
