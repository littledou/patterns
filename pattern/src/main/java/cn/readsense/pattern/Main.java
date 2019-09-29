package cn.readsense.pattern;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        final File[] listFiles = new File("").listFiles();

        final File[] testFiles = new File("").listFiles();

        for (File feature : listFiles) {
            for (File img : testFiles) {
                if (feature.getName().startsWith(img.getName()))
                    feature.delete();
            }
        }
    }


}
