package designpattern.constructionpattern.proxy.dynamicmethod;

import designpattern.constructionpattern.proxy.comunicationInterface;
import designpattern.constructionpattern.proxy.comunicationService;

public class Test {
    public static void main(String[] args) {
        comunicationInterface comunicationInterface=new comunicationService();
        System.out.println(comunicationInterface.getClass());

        comunicationInterface comunicationInterface1=(comunicationInterface) new comunicationProxy(comunicationInterface).getProxyInstance();

        System.out.println(comunicationInterface1.getClass());

        comunicationInterface1.sayHi();

        comunicationInterface1.sayGoodBye();
    }

}
