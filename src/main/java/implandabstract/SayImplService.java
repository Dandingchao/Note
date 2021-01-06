package implandabstract;

public class SayImplService implements SayImpl {
    @Override
    public void sayHi(){
        System.out.println("say hi");
    }
    public void saiHi2(){
        System.out.println("this hi is not definded in impl");
    }
}
