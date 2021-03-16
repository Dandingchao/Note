import Tree.Btree;
import javafx.scene.effect.Reflection;

import java.lang.reflect.Field;
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
        Btree tree =new Tree.Btree();
        tree.setValue(15);
        Btree test=new Btree();
        try {
            Class s=tree.getClass();
            Field field=s.getDeclaredField("value");
            field.setAccessible(true);
            System.out.println(field.get(test));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
