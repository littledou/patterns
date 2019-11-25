package cn.readsense.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BRRead {
    public static void main(String[] args) {
        char c = 0;
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        do {
            try {
                c = (char) bufferedReader.read();
                System.out.println("input: " + c);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (c != 'q');
    }
}
