package implandabstract;

public class SayExtend extends SayAbstract {

    @Override
    public void say() {
        System.out.println("this method is defined in abstractclass");
    }

    public void say2(){
        System.out.println("this method is not defined in abstractclass");
    }
}
