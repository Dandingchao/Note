package threadpool.poolentity;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                System.out.println("我是线程" + r);
                return t;
            }
        }
        );
        //用lambda表达式编写方法体中的逻辑
        Runnable run = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "正在执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 5; i++) {
            service.submit(run);
        }
        //这里一定要做关闭
        service.shutdown();
    }
}
