package threadpool.poolentity;

import lombok.Data;

import java.util.concurrent.*;

@Data
public class Pool {
    private ExecutorService executorService;
    private ThreadPoolExecutor threadPoolExecutor;
    public Pool() {
        this.threadPoolExecutor=new ThreadPoolExecutor(10,50,10000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
    }
}
