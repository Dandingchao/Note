import Imp.Callback;
import entity.Dog;
import entity.UserInfo;

public class lambdatest {
    //总而言之，我觉得lambda挺呆的，只能用于拥有单个方法的接口，接口的时间目前还不清楚，可能存在内存泄露,算是一种新的单方法接口实现方式，写起来更简便
    //没有类型声明目前不知道会不会增大开销。
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        Dog dog1=new Dog();
        dog1.setName("dog1");
        UserInfo userInfo=new UserInfo();
        userInfo.setLogname("user1");
     myinter  nihao = (d,u) -> {System.out.println(d.getName());
        System.out.println(u.getLogname());};
     nihao.dosome(dog1,userInfo);
     Callback callback=(s)-> System.out.println("are u stupid? "+s);
     callback.callback("asdjaiol");

    }
    @FunctionalInterface
    interface myinter{
        void dosome(Dog dog, UserInfo userInfo);
    }
    /*interface GreetingService {
        void sayMessage(String message);
    }*/
}
