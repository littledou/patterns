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
    private static int port = 55533;
    private static String host = "127.0.0.1";
    private ServerSocket serverSocket;
    private boolean end;

    public SocketHandlerBIO() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {

        while (!end) {
            try {
                Socket socket = serverSocket.accept();
                openSocketConn(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    void openSocketConn(Socket socket) {
        if (socket != null) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //打开一个连接，1客户端提示关闭，2超时关闭

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
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtil.closeStreamPipe(outputStream);
        }
    }

    public String readSocket(Socket socket) {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            return StreamUtil.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtil.closeStreamPipe(inputStream);
        }
        return null;
    }
}

