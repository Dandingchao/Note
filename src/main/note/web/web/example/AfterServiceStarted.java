package web.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * springboot开启操作
 */
@Slf4j
@Component
public class AfterServiceStarted extends Thread implements InitializingBean {

    /**
     * 会在服务启动完成后立即执行
     */
    @Override
    public void run() {
        log.info("当前线程名：{}", Thread.currentThread().getName());
        log.info("由当前线程开始启动Socket服务...");
        Listener listener=null;
        try {
            listener=new Listener();
            listener.run();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (listener!=null){
                listener.interrupt();
            }
            log.info("由当前线程停止完毕");
        }
    }

    @Override
    public void afterPropertiesSet(){
        start();
    }
}