package cn.readsense.easynet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.readsense.easynet.stream.StreamUtil;

public class SocketTest {
    private static int port = 6644;
    private static String host = "127.0.0.1";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(host, port);

                    executorService.execute(new ReadRunnable(socket));

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String str;
                    System.out.println("等待输入");
                    OutputStream outputStream = socket.getOutputStream();
                    while (!(str = bufferedReader.readLine()).equals("end")) {
                        outputStream.write(str.getBytes());
                    }

                    outputStream.write(str.getBytes());
                    StreamUtil.closeStreamPipe(outputStream);
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    static class ReadRunnable implements Runnable {
        private Socket socket;

        public ReadRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " - client start read");
            try (InputStream inputStream = socket.getInputStream()) {
                int len;
                byte[] data = new byte[1024];
                // 按字节流方式读取数据
                while ((len = inputStream.read(data)) != -1) {
                    String str = new String(data, 0, len);
                    System.out.println(Thread.currentThread().getName() + " - " + str);
                    if (str.equals("end")) break;
                }
                System.out.println(Thread.currentThread().getName() + " - client end read");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
