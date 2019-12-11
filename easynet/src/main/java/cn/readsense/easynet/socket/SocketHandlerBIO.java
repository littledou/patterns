package cn.readsense.easynet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cn.readsense.easynet.stream.StreamUtil;

//BIO
public class SocketHandlerBIO extends Thread {
    //监听的端口
    private static int port = 6644;
    private static String host = "127.0.0.1";
    private ServerSocket serverSocket;
    private boolean end;

    public SocketHandlerBIO() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        System.out.println("服务器启动");
        while (!end) {
            try {
                Socket socket = serverSocket.accept();//服务器阻塞处
                openSocketConn(socket);//接收到客户端连接，启动线程与客户端通信
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("服务器关闭");
    }

    void openSocketConn(final Socket socket) {
        System.out.println("收到新到连接");
        if (socket != null) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("建立连接：" + Thread.currentThread().getName());
                    String str = null;

                    while (!(str = readSocket(socket)).equals("end")) {
                        System.out.println("client: " + str);
                        System.out.println("server write: hi client。i recivered");
                        writeSocket(socket, "hi client。i recivered");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();
        }
    }


    public Socket createNewSocket() {
        try {
            return new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeSocket(Socket socket, String msg) {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            StreamUtil.write(outputStream, msg);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readSocket(Socket socket) {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            return StreamUtil.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "end";
    }
}

