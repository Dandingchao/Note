import InterAndAbstract.sayAbstract;
import InterAndAbstract.sayExtend;
import InterAndAbstract.sayImpl;
import InterAndAbstract.sayImplService;
import entity.Testentity4ThreadSychronized;
import entity.TestentityNoImplHaveRun;

public class pa {
    public static void main(String[] args) {
        Testentity4ThreadSychronized testentity4ThreadSychronized=new Testentity4ThreadSychronized();
        Testentity4ThreadSychronized testentity4ThreadSychronized1=new Testentity4ThreadSychronized();
        Thread thread1=new Thread(testentity4ThreadSychronized);
        Thread thread2=new Thread(testentity4ThreadSychronized);
        Thread thread3=new Thread(testentity4ThreadSychronized1);
        //thread1.start();
        thread2.start();
        thread3.start();
    }

}
