package cn.readsense.easynet.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetUtilv1 {

    public static String get(String url) {
        HttpURLConnection http = null;
        InputStream is = null;
        try {
            URL urlGet = new URL(url);
            http = (HttpURLConnection) urlGet.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            // 设置连接超时时间
            http.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            http.setReadTimeout(5 * 1000);

            http.connect();

            is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            return new String(jsonBytes, "UTF-8");
        } catch (Exception e) {
            return null;
        } finally {
            if (null != http) http.disconnect();
            try {
                if (null != is) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String post(String url, String data) {
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader reader = null;
        try {
            //创建连接
            URL urlPost = new URL(url);
            conn = (HttpURLConnection) urlPost
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 设置连接超时时间
            conn.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            conn.setReadTimeout(5 * 1000);

            conn.connect();

            //POST请求
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            out.print(data);
            out.flush();
            out.close();
            out = null;

            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            reader = null;
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != conn) conn.disconnect();
            if (null != out) out.close();
            try {
                if (null != reader) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        URL url = new URL("https://www.so.com");
                        System.out.println(url.getProtocol());
                        System.out.println(url.getHost());
                        System.out.println(url.getPort());
                        System.out.println(url.getFile());

                        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                        String s;
                        while((s=br.readLine())!=null){
                            System.out.println(s);
                        }
                        br.close();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private static HttpURLConnection SetHttpConnection(String repUrl, String requestMethod) {
        HttpURLConnection connection = null;
        try {
            // 创建URL对象
            URL url = new URL(repUrl);

            // 打开连接 获取连接对象
            //URLConnection connection = url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setConnectTimeout(5000); // 5秒 连接主机的超时时间（单位：毫秒）
            connection.setReadTimeout(5000); // 5秒 从主机读取数据的超时时间（单位：毫秒）

            //发送POST请求设置下面两行
            // 设置允许输入
            connection.setDoInput(true);
            // 设置允许输出
            connection.setDoOutput(true);
            if (requestMethod.equals("POST")) {
                connection.setUseCaches(false);//Post 请求不能使用缓存
            }

            // 设置请求编码
//            connection.addRequestProperty("encoding", "UTF-8");

            //设置请求头参数
            //connection.setRequestProperty("Authorization",this.token);
//            connection.setRequestProperty("Charsert", "UTF-8");
//            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", CONTENT_TYPE+";boundary=" + BOUNDARY);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }


    private static final String PREFIX = "--";                            //前缀
    private static final String BOUNDARY = UUID.randomUUID().toString();  //边界标识 随机生成
    private static final String CONTENT_TYPE = "multipart/form-data";     //内容类型
    private static final String LINE_END = "\r\n";                        //换行

    /**
     * @param repUrl
     * @param map
     * @param requestMethod
     * @return
     */
    private static StringBuilder baseMethodBuild(String repUrl, Map<String, String> map, String requestMethod) {
        StringBuilder stringReturnBuilder = new StringBuilder();
        try {
            HttpURLConnection connection = SetHttpConnection(repUrl, requestMethod);

            // 从连接对象中获取输出字节流对象
            OutputStream outputStream = connection.getOutputStream();
            /**
             * 请求体
             */

            DataOutputStream dos = new DataOutputStream(outputStream);
            if (map.size() > 0) {
                //上传参数

                //dos.writeBytes(getStrParams(map).toString() );
                //中文字符
                dos.write(getStrParams(map).toString().getBytes());
                dos.flush();
            }


            //请求结束标志
            dos.writeBytes(PREFIX + BOUNDARY + PREFIX + LINE_END);
            dos.flush();
            dos.close();

            // 从连接对象中获取输入字节流对象
            InputStream inputStream;
            //根据 ResponseCode来选择getInputStream/getErrorStream
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream();
            }

            // 将输入字节流对象包装成输入字符流对象，并将字符编码为UTF-8格式
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            // 创建一个输入缓冲区对象，将要输入的字符流对象传入
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 创建一个字符串对象，用来接收每次从输入缓冲区中读入的字符串
            String line;
            // 创建一个可变字符串对象，用来装载缓冲区对象的最终数据，使用字符串追加的方式，将响应的所有数据都保存在该对象中

            // 使用循环逐行读取缓冲区的数据，每次循环读入一行字符串数据赋值给line字符串变量，直到读取的行为空时标识内容读取结束循环
            while ((line = bufferedReader.readLine()) != null) {
                // 将缓冲区读取到的数据追加到可变字符对象中
                stringReturnBuilder.append(line);
                System.out.println(line);
            }
            // 依次关闭打开的输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            // 依次关闭打开的输出流
            outputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return stringReturnBuilder;
        }
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
