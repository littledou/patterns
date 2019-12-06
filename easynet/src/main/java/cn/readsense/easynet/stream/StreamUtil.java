package cn.readsense.easynet.stream;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class StreamUtil {

    public static void write(OutputStream outputStream, String msg) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            outputStreamWriter.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtil.closeStreamPipe(outputStreamWriter);
        }
    }

    public static String read(InputStream inputStream) {
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
            closeStreamPipe(outStream);
        }
        return null;
    }

    public static String read0(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 将输入字节流对象包装成输入字符流对象，并将字符编码为UTF-8格式
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            // 创建一个输入缓冲区对象，将要输入的字符流对象传入
            bufferedReader = new BufferedReader(inputStreamReader);
            // 使用循环逐行读取缓冲区的数据，每次循环读入一行字符串数据赋值给line字符串变量，直到读取的行为空时标识内容读取结束循环
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                // 将缓冲区读取到的数据追加到可变字符对象中
                sb.append(line);
                sb.append("\r\n");

            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeReadPipe(inputStreamReader);
            closeReadPipe(bufferedReader);
        }
        return null;
    }

    public static void closeReadPipe(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStreamPipe(Object stream) {
        if (stream != null) {
            try {
                if (stream instanceof OutputStream)
                    ((OutputStream) stream).close();
                else if (stream instanceof InputStream)
                    ((InputStream) stream).close();
                else if (stream instanceof Writer)
                    ((Writer) stream).close();
                else if (stream instanceof Reader)
                    ((Reader) stream).close();
                else throw new RuntimeException("cant close target stram");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
