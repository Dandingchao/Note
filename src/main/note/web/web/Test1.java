package web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(50);
        Socket socket = serverSocket.accept();
        Socket socket1 = new Socket();
        socket1.bind(50);
        Reader reader = new InputStreamReader(socket.getInputStream());
        char[] chars = new char[1024];
        int len;
        StringBuilder builder=new StringBuilder();
        while ((len=reader.read(chars))!=-1){

        }
    }
}
