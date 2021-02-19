package threadpool.Test;

import threadpool.entity.TestEntity4ThreadSychronized;
import threadpool.model.Entity1;
import threadpool.model.Entity2;
import threadpool.poolentity.Pool;

public class Test {
    public static void main(String[] args) {
        Entity2 entity1=new Entity2();
        Thread thread=new Thread(entity1);
        Thread thread1=new Thread(entity1);
        Pool pool=new Pool();
        pool.getThreadPoolExecutor().submit(thread1);
        pool.getThreadPoolExecutor().execute(thread);
    }
}
