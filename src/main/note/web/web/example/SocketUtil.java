package web.example;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;
@Slf4j
@Log4j2
public class SocketUtil {


    //发送数据
    public static void Send(byte[] obj, Socket socket) {
        OutputStream socketWriter = null;
        try {
            socketWriter = socket.getOutputStream();
            socketWriter.write(obj);
            socketWriter.flush();
        } catch (Exception s) {
            try {
                socketWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("Socket 已关闭");
        }
    }

    //接受数据
    public static void Accept(Socket socket) {
        InputStream in = null;
        //定义缓冲区
        List<Byte> queueFinal = new LinkedList<Byte>();

        try {
            socket.setSoTimeout(3000);//堵塞超时设置(个人理解)
            socket.setTcpNoDelay(true);//开启NoDelay算法
            socket.setReuseAddress(true);//设置为true的话可以实现端口复用
            socket.setSoLinger(true, 5);//指定的延迟时间（秒）。最大超时值为平台
            socket.setSendBufferSize(1024);//设置IO发送缓冲区
            socket.setReceiveBufferSize(1024);//设置IO接收缓冲区
            socket.setKeepAlive(true);//检测客户端和服务端双方有一方掉线就会抛异常。主动关闭scoket连接用
            boolean flag = true;
            while (flag) {
                if (!socket.isClosed()) {  //判断是否连接 在上方说抛异常时判断连接是否还存在
                    in = socket.getInputStream(); //接收
                    // 首先读取两个字节表示的长度
                    int first = in.available();
                    //如果读取的值为0 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                    if (first == 0) {
                        //次数设置一个死循环的原因:是不想下面read堵塞  减少服务器堵塞时间
                        sleep(3000);
                        byte obj[] = new byte[1];
                        obj[0] = (byte) 0xFF;
                        Send(obj, socket);//回文
                        continue;
                    }
                    System.out.println("byte长度:" + first);
                    byte buf[] = new byte[first];
                    in.read(buf);
                    //将数据全部存入临时缓冲区
                    for (byte b : buf) {
                        queueFinal.add(b);
                    }
                    //4.处理断包、粘包
                    while (!queueFinal.isEmpty()) {
                        Byte b = 49;
                        Byte c = 50;
                        boolean frist = queueFinal.get(0).equals(b);
                        boolean last = queueFinal.get(queueFinal.size() - 2).equals(c);
                        if (frist && last) {
                            //粘包，即包尾后还有内容，如果没有粘包则继续发送tcp请求收取下一帧数据
                            log.info("粘包了");
                            SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
                            StringBuilder builder = new StringBuilder();
                            builder.append("300.10.A");
                            builder.append(df.format(new Date()));
                            log.info("回文时间" + new String(StringToUnicodeUtils.hexStringToByteArray(StringToUnicodeUtils.stringToHexString(builder.toString()))));
                            Send(StringToUnicodeUtils.hexStringToByteArray(StringToUnicodeUtils.stringToHexString(builder.toString())), socket);//回文
                            String[] len = new String[queueFinal.size()];
                            for (int i = 0; i < queueFinal.size(); i++) {
                                len[i] = String.valueOf(StringToUnicodeUtils.bytesToHexString(queueFinal.get(i)));
                            }
                            queueFinal.clear();//清包
                            log.info(JSON.toJSONString(len));
                            //处理数据
                            //此处写数据处理逻辑
                            return;
                        } else if (frist && !last) {
                            //断包，即接收到的包不完整，则跳出内圈循环，进入外圈循环，从输入流中继续读取数据
                            log.error("等待接收");
                            break;
                        } else if (!frist && last) {
                            //残包，即只找到包尾或包头在包尾后面，则扔掉队列缓冲区中包尾及其之前的多余字节
                            log.error("残包了");
                            queueFinal.clear();//清空
                            return;
                        } else {
                            return;
                        }
                    }
                    System.out.println(socket.isBound()); // 是否邦定
                    System.out.println(socket.isClosed()); // 是否关闭
                    System.out.println(socket.isConnected()); // 是否连接
                    System.out.println(socket.isInputShutdown()); // 是否关闭输入流
                    System.out.println(socket.isOutputShutdown()); // 是否关闭输出流
                } else {
                    flag = false;
                    log.info("结束掉死循环");
                    try {
                        if (in != null) {
                            in.close();
                        }
                        log.info("关闭输入流：" + socket.getRemoteSocketAddress());
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (in != null) {
                    in.close();
                }
                socket.close();
                log.info("异常客户端断开：" + socket.getRemoteSocketAddress());
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
}