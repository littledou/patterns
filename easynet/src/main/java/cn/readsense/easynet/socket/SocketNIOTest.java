package cn.readsense.easynet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import cn.readsense.easynet.stream.StreamUtil;

public class SocketNIOTest {
    private static int port = 6644;
    private static String host = "127.0.0.1";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                SocketChannel socketChannel = null;
                try {
                    socketChannel = SocketChannel.open();
                    socketChannel.configureBlocking(false);
                    socketChannel.connect(new InetSocketAddress(host, port));
                    if (socketChannel.finishConnect()) {
                        int i = 0;
                        while (true) {
                            TimeUnit.SECONDS.sleep(1);
                            String info = "hi server " + i++;
                            byteBuffer.clear();
                            byteBuffer.put(info.getBytes());
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()) {
                                System.out.println(Arrays.toString(byteBuffer.array()));
                                socketChannel.write(byteBuffer);
                            }

                            byteBuffer.clear();
                            socketChannel.read(byteBuffer);
                            System.out.println(Arrays.toString(byteBuffer.array()));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    StreamUtil.closeStreamPipe(socketChannel);
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
