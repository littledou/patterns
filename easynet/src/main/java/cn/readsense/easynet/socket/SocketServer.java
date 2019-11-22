package cn.readsense.easynet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    //监听的端口
    static int port = 55533;
    static String host = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Socket socket = new Socket(host,port);
                    OutputStream outputStream = socket.getOutputStream();
                    String msg = "hemm";
                    outputStream.write(msg.getBytes("utf-8"));
                    outputStream.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("server wait connect");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] temp = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(temp)) != -1) {
            stringBuilder.append(new String(temp, 0, len, "utf-8"));
        }
        System.out.println("get msg from client: " + stringBuilder);
        inputStream.close();
        socket.close();
        serverSocket.close();
    }


}
