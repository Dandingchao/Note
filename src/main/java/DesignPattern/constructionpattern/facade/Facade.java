package designpattern.constructionpattern.facade;

public class Facade {
    private A a=new A();
    private B b=new B();
    private C c=new C();

    public void saiHi(){
        a.sayHiA();
        b.sayHiB();
        c.sayHiC();
    }
}
class A{
    public void sayHiA(){
        System.out.println("A say hi");
    }
}

class B{
    public void sayHiB(){
        System.out.println("B say hi");
    }
}

class C{
    public void sayHiC(){
        System.out.println("C say hi");
    }
}
