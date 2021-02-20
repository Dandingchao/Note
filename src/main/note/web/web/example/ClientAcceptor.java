package web.example;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

@Slf4j
@Log4j2
public class ClientAcceptor implements Runnable {
    private Socket mSocket = null;

    public ClientAcceptor(Socket socket) {
        this.mSocket = socket;
    }

    @Override
    public void run() {
        try {
            if (null != mSocket){
                log.info("当前线程名:"+Thread.currentThread().getName());
                SocketUtil.Accept(mSocket);
                log.info("执行完成SocketUtil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (mSocket!=null){
                    mSocket.close();
                    log.info("客户端正常断开：" + mSocket.getRemoteSocketAddress());
                }
                Thread.currentThread().interrupt();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
}
