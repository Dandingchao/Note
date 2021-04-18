package threadpool.Test;

import threadpool.entity.TestEntity1Thread;
import threadpool.entity.TestEntity4ThreadSychronized;
import threadpool.model.Entity1;
import threadpool.model.Entity2;
import threadpool.poolentity.Pool;

public class Test {
    public static void main(String[] args) {
        TestEntity1Thread testEntity1Thread=new TestEntity1Thread();
        /*Thread thread=new Thread(entity1);
        Thread thread1=new Thread(entity1);
        thread.start();*/
        Pool pool=new Pool();
        for(int i=0;i<50;i++){
            pool.getThreadPoolExecutor().submit(testEntity1Thread);
        }
        //pool.getThreadPoolExecutor().execute(thread);
    }
}
