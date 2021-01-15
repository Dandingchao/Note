package entity;

public class DaddyDog1 extends DaddyDog{
    @Override
    public void sayHi(){
        unHappy();
        super.sayHi();
    }
    public void unHappy(){
        System.out.println("I'm unhappy");
    }
}
