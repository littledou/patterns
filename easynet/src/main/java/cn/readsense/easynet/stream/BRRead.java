package cn.readsense.easynet.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {

    public static void main(String[] args) throws IOException {
        //读取字符
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;

        while ((c = (char) bufferedReader.read()) != 'q') {
            System.out.println(c);
        }

        //读取字符串
        String str;
        while (!(str = bufferedReader.readLine()).equals("end")) {
            System.out.println(str);
        }
    }

}
