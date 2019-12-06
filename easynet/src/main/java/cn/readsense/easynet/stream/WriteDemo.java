package cn.readsense.easynet.stream;

import java.io.PrintStream;

public class WriteDemo {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        printStream.write('o');
        printStream.write('u');
        printStream.write('t');
        printStream.write('\n');
        //等同与
        System.out.println("out");
    }

}
