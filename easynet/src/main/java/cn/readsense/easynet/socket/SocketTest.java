package cn.readsense.easynet.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import cn.readsense.easynet.stream.StreamUtil;

public class SocketTest {

    static SocketHandlerBIO socketHandlerBIO;

    public static void main(String[] args) {
        socketHandlerBIO = new SocketHandlerBIO();
        socketHandlerBIO.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = socketHandlerBIO.createNewSocket();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String str;
                    System.out.println("等待输入");
                    InputStream inputStream = null;
                    OutputStream outputStream;
                    while (!(str = bufferedReader.readLine()).equals("end")) {
                        System.out.println("client post msg:" + str);

                        outputStream = socket.getOutputStream();
                        outputStream.write(str.getBytes());
                        outputStream.flush();
                        outputStream.close();

                        System.out.println("wait read server");
                        inputStream = socket.getInputStream();
                        String string = StreamUtil.read(inputStream);

                        System.out.println("收到服务器响应：" + string);
                        System.out.println("等待输入");
                        Thread.sleep(1000);
                    }


                    StreamUtil.closeStreamPipe(inputStream);
//                    StreamUtil.closeStreamPipe(outputStream);
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
