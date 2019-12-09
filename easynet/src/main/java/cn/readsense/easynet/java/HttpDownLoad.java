package cn.readsense.easynet.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownLoad {


    //    /**
//     * 单线程下载，打开网络输入流，直接将流写入文件
//     */
    public static void downLoad(String path, String savepath) throws IOException {
        URL url = new URL(path);

        InputStream is = url.openStream();
        String[] split = path.split("/");

        OutputStream outputStream = new FileOutputStream(new File(savepath).getAbsolutePath() + "/" + split[split.length - 1]);

        byte[] buffer = new byte[1024];

        int len = 0;
        while ((len = is.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        is.close();
        outputStream.close();
    }

    /**
     * 多线程下载
     * 1. 打开连接
     * 2. 计算大小，在本地创建同样大小的空文件
     * 3. 计算每个线程起始下载位置
     * 4. 依次启动多个线程下载指定位置的网络资源到指定位置
     */
    public static void downLoadFast(String path, String filename) throws IOException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int filelength = conn.getContentLength();

        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rwd");
        randomAccessFile.setLength(filelength);
        randomAccessFile.close();
        conn.disconnect();

        int threadsize = 2;
        int threadlength = filelength / threadsize;//短除，剩余部分放到最后一个线程

        for (int i = 0; i < threadsize; i++) {
            int startposition = i * threadlength;
            int datasize = threadlength;
            if (i == threadsize - 1) datasize = threadlength + (filelength % threadsize);
            new DownLoadThread(i, startposition, datasize, path, filename).start();
        }

    }

    private static class DownLoadThread extends Thread {

        private int startposition;
        private int datasize;
        private String path;
        private String filename;
        private int threadid;

        public DownLoadThread(int threadid, int startposition, int datasize, String path, String filename) {
            this.threadid = threadid;
            this.startposition = startposition;
            this.datasize = datasize;
            this.path = path;
            this.filename = filename;
        }

        @Override
        public void run() {
            try {
                RandomAccessFile threadfile = new RandomAccessFile(filename, "rwd");
                threadfile.seek(startposition);
                URL url = new URL(path);

                final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                //指定从什么位置开始下载
                conn.setRequestProperty("Range", "bytes=" + startposition + "-");

                InputStream is = conn.getInputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                int length = 0;
                while (length < datasize && (len = is.read(buffer)) != -1) {
                    threadfile.write(buffer, 0, len);
                    //计算累计下载的长度
                    length += len;

                    System.out.println("线程 " + threadid + " 下载长度：" + length + "， 共: " + datasize + " 已下载：" + (length * 100f / (float) datasize) + "%");
                }
                threadfile.close();
                is.close();
                System.out.println("线程 " + threadid + " 下载完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            downLoadFast("https://www.charlesproxy.com/assets/release/4.5.4/charles-proxy-4.5.4.dmg",
                    "test.dmg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
