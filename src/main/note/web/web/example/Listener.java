package web.example;


import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/*
 * 单例设计模式设计服务类,将服务类设计为线程
 * */
@Slf4j
@Log4j2
public class Listener extends Thread {
    private static Listener mListener = null;
    // 线程池，用于支持并发。无界的任务队列
    static ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(
            20,
            50,
            60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    // 关闭标志
    private volatile boolean mStopFlag;
    private ServerSocket mServerSocket;

    public static Listener getInstance() {
        if (mListener == null) {
            synchronized (Listener.class) {
                if (mListener == null) {
                    mListener = new Listener();
                }
            }
        }
        return mListener;
    }

    /**
     * 只能存在单实例
     */
    public Listener() {
        mStopFlag = false;
        try {
            mServerSocket = new ServerSocket(Consts.ServerPort);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                mServerSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * stop
     */
    public void setStopFlag() {
        mStopFlag = true;
    }

    @Override
    public void run() {
        log.info("服务器已经启动，等待连接");
        while (!mStopFlag) {
            try {
                Socket socket = mServerSocket.accept();// which is connected to the
                socket.setSoTimeout(3000);//堵塞超时设置(个人理解)
                socket.setTcpNoDelay(true);//开启NoDelay算法
                socket.setReuseAddress(true);//设置为true的话可以实现端口复用
                socket.setSoLinger(true, 5);//指定的延迟时间（秒）。最大超时值为平台
                socket.setSendBufferSize(1024);//设置IO发送缓冲区
                socket.setReceiveBufferSize(1024);//设置IO接收缓冲区
                socket.setKeepAlive(true);//检测客户端和服务端双方有一方掉线就会抛异常。主动关闭scoket连接用
                sleep(3000);
                mThreadPool.execute(new ClientAcceptor(socket));
                log.info("线程执行一次");
            } catch (Exception e) {
                setStopFlag();
                mThreadPool.shutdown();
                e.printStackTrace();
            }
        }
        log.info("Listener准备退出");
    }
}

