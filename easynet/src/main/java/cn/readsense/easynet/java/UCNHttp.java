package cn.readsense.easynet.java;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public class UCNHttp {

    private static final String PREFIX = "--";                            //前缀
    private static final String BOUNDARY = UUID.randomUUID().toString();  //边界标识 随机生成
    private static final String CONTENT_TYPE = "multipart/form-data";     //内容类型
    private static final String LINE_END = "\r\n";                        //换行

    private static HttpURLConnection setUpHttpURLConnection(String url, String method) throws IOException {
        final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod(method);
        if (method.equals("POST")) {
            conn.setUseCaches(false);//Post 请求不能使用缓存
            conn.setDoOutput(true);// 设置此方法,允许向服务器输出内容
        }
        conn.setReadTimeout(5000);// 设置读取超时为5秒
        conn.setConnectTimeout(5000);// 设置连接网络超时为10秒
        return conn;
    }

    //从流中读取数据
    public static String read(HttpURLConnection conn) {
        int responseCode = 0;// 调用此方法就不必再使用conn.connect()方法
        try {
            responseCode = conn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("code: " + responseCode);
        ByteArrayOutputStream outStream = null;
        InputStream inputStream = null;
        try {
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = conn.getInputStream();
            } else {
                inputStream = conn.getErrorStream();
            }

//            // 将输入字节流对象包装成输入字符流对象，并将字符编码为UTF-8格式
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            // 创建一个输入缓冲区对象，将要输入的字符流对象传入
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            // 使用循环逐行读取缓冲区的数据，每次循环读入一行字符串数据赋值给line字符串变量，直到读取的行为空时标识内容读取结束循环
//            String line;
//            StringBuilder sb = new StringBuilder();
//            while ((line = bufferedReader.readLine()) != null) {
//                // 将缓冲区读取到的数据追加到可变字符对象中
//                sb.append(line);
//            }
//            return sb.toString();

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
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;

    }

    public static String get(String url) {
        HttpURLConnection conn = null;
        try {
            conn = setUpHttpURLConnection(url, "GET");
            return read(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }

        return null;
    }

    public static String post(String url, Map<String, String> map) {
        HttpURLConnection conn = null;
        try {
            conn = setUpHttpURLConnection(url, "POST");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);

            OutputStream os = conn.getOutputStream();// 获得一个输出流,向服务器写数据

            DataOutputStream dos = new DataOutputStream(os);
            if (map != null && map.size() > 0) {
                dos.write(getStrParams(map).toString().getBytes());
                dos.flush();
            }
            //请求结束标志
            dos.writeBytes(PREFIX + BOUNDARY + PREFIX + LINE_END);
            dos.flush();
            dos.close();
            os.close();

            return read(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.disconnect();
        }

        return null;
    }


    private static void log(String s) {
        System.out.println(s);
    }


    private static StringBuilder getStrParams(Map<String, String> strParams) {
        StringBuilder strSb = new StringBuilder();
        for (Map.Entry<String, String> entry : strParams.entrySet()) {
            strSb.append(PREFIX)
                    .append(BOUNDARY)
                    .append(LINE_END)
                    .append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINE_END)
                    .append("Content-Type: text/plain; charset=" + "utf-8" + LINE_END)
                    .append("Content-Transfer-Encoding: 8bit" + LINE_END)
                    .append(LINE_END)// 参数头设置完以后需要两个换行，然后才是参数内容
                    .append(entry.getValue())
                    .append(LINE_END);
        }
        return strSb;
    }

}
