package cn.readsense.easynet.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileDemo {


    public static void main(String[] args) throws FileNotFoundException {

        OutputStream outputStream = new FileOutputStream("./file.txt");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);

        try {
            outputStreamWriter.write("中文输入");
            outputStreamWriter.write("english");
            outputStreamWriter.write("\r\n");
            outputStreamWriter.append("中文输入");
            outputStreamWriter.append("english");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StreamUtil.closeStreamPipe(outputStreamWriter);
        StreamUtil.closeStreamPipe(outputStream);

        InputStream inputStream = new FileInputStream("./file.txt");
        System.out.println(StreamUtil.read0(inputStream));
        StreamUtil.closeStreamPipe(inputStream);
    }

}
