package cn.readsense.easynet.stream;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileDemo {

    private static final String path = "./file.txt";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws FileNotFoundException {

//        OutputStream outputStream = new FileOutputStream("./file.txt");
//
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
//
//        try {
//            outputStreamWriter.write("中文输入");
//            outputStreamWriter.write("english");
//            outputStreamWriter.write("\r\n");
//            outputStreamWriter.append("中文输入");
//            outputStreamWriter.append("english");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StreamUtil.closeStreamPipe(outputStreamWriter);
//        StreamUtil.closeStreamPipe(outputStream);
//
//        InputStream inputStream = new FileInputStream("./file.txt");
//        System.out.println(StreamUtil.read0(inputStream));
//        StreamUtil.closeStreamPipe(inputStream);

        //java7支持Files
        try {
            Files.write(Paths.get(path), "ignb \n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
