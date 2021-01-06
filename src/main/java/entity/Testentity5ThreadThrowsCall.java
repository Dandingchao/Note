package entity;

import java.util.concurrent.Callable;

public class Testentity5ThreadThrowsCall implements Callable {

    @Override
    public Object call() throws Exception {

        Thread.sleep(5000);


        return null;
    }
}
