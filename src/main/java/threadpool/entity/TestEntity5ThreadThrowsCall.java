package threadpool.entity;

import java.util.concurrent.Callable;

public class TestEntity5ThreadThrowsCall implements Callable {

    @Override
    public Object call() throws Exception {

        Thread.sleep(5000);


        return null;
    }
}
