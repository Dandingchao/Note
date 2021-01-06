package DesignPattern.proxy.cglibproxy;

import DesignPattern.proxy.comunication;
import net.sf.cglib.core.DebuggingClassWriter;

public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\classes");
        comunication comunication2=new comunication();
        /*cglibproxy cglibproxy=new cglibproxy(comunication);

        comunication comunication1=(comunication)cglibproxy.getProxyInstance();
        */
        comunication comunication1=(comunication) new cglibproxy(comunication2).getProxyInstance();
        comunication1.sayHi();
    }
}
