package threadpool.poolentity;

import lombok.Data;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

@Data
public class Pool {
    private ExecutorService executorService;
    private ThreadPoolExecutor threadPoolExecutor;
    public Pool() {
        this.threadPoolExecutor = new ThreadPoolExecutor(10,
                50,
                10000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(),
                factory,
                rejectedExecutionHandler);

        this.executorService=Executors.newSingleThreadExecutor();
        this.executorService=Executors.newScheduledThreadPool(10);
    }

    ThreadFactory factory =(r)->{
        Thread t = new Thread(r);
        System.out.println("我是线程" + r);
        return t;
    };

    RejectedExecutionHandler rejectedExecutionHandler =(r,e)->{
        //method拒绝方法，策略
        throw new RejectedExecutionException("Task " + r.toString() +
                " rejected from " +
                e.toString());
        /**
         *四种java自带的默认拒绝策略
         ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常。
         ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提交被拒绝的任务
         ThreadPoolExecutor.CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
         */
    };
    public static class MyThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            System.out.println("I created by this factory");
            return new Thread(r);
        }
    }
    
    public static class MyRejectExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    executor.toString());
        }
    }
}
