package cn.readsense.easynet.java;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGET {

    public static byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        log("code: " + conn.getResponseCode());
        final InputStream inputStream = conn.getInputStream();
        final byte[] bytes = read(inputStream);
        inputStream.close();
        return bytes;
    }


    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        log("code: " + conn.getResponseCode());
        final InputStream inputStream = conn.getInputStream();
        final byte[] bytes = read(inputStream);
        inputStream.close();
        return new String(bytes, "utf-8");
    }


    //从流中读取数据
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }



    private static void log(String s) {
        System.out.println(s);
    }


}
