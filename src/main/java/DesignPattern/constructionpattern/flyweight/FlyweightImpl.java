package designpattern.constructionpattern.flyweight;

public class FlyweightImpl implements Flyweight{
    private String key;
    public FlyweightImpl(String key){
        this.key=key;
    }
    @Override
    public void sayHiAndInfom(UnsharedInform unsharedInform) {
        unsharedInform.saiMessage();
        this.sayHi();
    }
    public void sayHi(){
        System.out.println("hi");
    }

    public String getKey() {
        return key;
    }
}
