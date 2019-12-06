package cn.readsense.easynet.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SocketServerThread extends Thread{
    //监听的端口
    static int port = 55533;
    static String host = "127.0.0.1";


    public SocketServerThread() {
    }

    @Override
    public void run() {

    }
    private static String read(InputStream inputStream) {
        ByteArrayOutputStream outStream = null;
        try {
            outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            return outStream.toString("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
