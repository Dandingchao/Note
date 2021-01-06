import java.util.*;
import java.util.concurrent.*;

public class Threadpool {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue2=new LinkedBlockingQueue<Runnable>();
        ExecutorService pool= Executors.newScheduledThreadPool(10);
        ThreadPoolExecutor standard =new ThreadPoolExecutor(10,10,1000, TimeUnit.MILLISECONDS,queue2);
        Calendar cal = Calendar.getInstance();
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        List<Integer> list=new ArrayList<Integer>();

    }
}
