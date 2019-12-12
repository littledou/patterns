package cn.readsense.easynet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


    public static void main(String[] args) {
        SocketHandlerBIO socketHandlerBIO = new SocketHandlerBIO();
        socketHandlerBIO.start();
    }


    @Override
    public void run() {
        System.out.println("服务器启动");
        while (!end) {
            try {
                Socket socket = serverSocket.accept();//服务器阻塞处
                executorService.execute(new SocketRunnable(socket));//接收到客户端连接，将连接添加至线程池
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("服务器关闭");
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);


    class SocketRunnable implements Runnable {

        private Socket socket;

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("建立连接：" + Thread.currentThread().getName());
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                int len;
                byte[] data = new byte[1024];
                // 按字节流方式读取数据
                while ((len = inputStream.read(data)) != -1) {
                    String str = new String(data, 0, len);
                    System.out.println(Thread.currentThread().getName() + " client: " + str);
                    if (str.equals("end")) {
                        outputStream.write("end".getBytes());
                        break;
                    }
                    outputStream.write("server: reciver".getBytes());

                }
                inputStream.close();
                outputStream.close();
                System.out.println("end " + Thread.currentThread().getName());
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

