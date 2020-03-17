package cn.readsense.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "MainActivity tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readZipFile("/sdcard/3.zip", "上海市_2019-08-29T13_10_09.000604/32/NPL/0021/0/0/0/9/0/9/1/7/FM_eCoupon.SCH");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public static void readZipFile(String file,String fileName) throws Exception {
        long st = System.currentTimeMillis();
        ZipFile zf = new ZipFile(file);
        ZipEntry ze = zf.getEntry(fileName);
        InputStream in = zf.getInputStream(ze);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        StringBuffer result = new StringBuffer();
        while ((line = br.readLine()) != null) {
            result.append(line+"\n");
        }
        long et =  System.currentTimeMillis() - st;
        Log.e(TAG,"time " + " : " + et + " ms");
        
//        System.out.println("ret: "+result);

    }


    /**
     * 无需解压直接读取Zip文件和文件内容
     * @param file
     * @throws Exception
     */
    public void readZipFile2(final String file) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    long st = System.currentTimeMillis();
                    ZipFile zf = null;
                    zf = new ZipFile(file);
                    InputStream in = null;
                    try {
                        in = new BufferedInputStream(new FileInputStream(file));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ZipInputStream zin = new ZipInputStream(in);
                    ZipEntry ze;
                    while ((ze = zin.getNextEntry()) != null) {
                        if (ze.isDirectory()) {
                            //Do nothing
                        } else {
//                        Log.e(TAG,"file - " + ze.getName() + " : " + ze.getSize() + " bytes");
                            if (ze.getName().equals("上海市_2019-08-29T13_10_09.000604/32/NPL/0021/0/0/0/9/0/9/1/7/FM_eCoupon.SCH")) {
                                Log.e(TAG,"file 222222222222- " + ze.getName() + " : " + ze.getSize() + " bytes");
                                BufferedReader br = new BufferedReader(
                                        new InputStreamReader(zf.getInputStream(ze)));
                                String line;
                                while ((line = br.readLine()) != null) {
                                    Log.e(TAG, line);
                                    if (line.contains("xml")) {
                                        long et =  System.currentTimeMillis() - st;
                                        Log.e(TAG,"time " + " : " + et + " ms");
                                    }
                                }
                                br.close();
                            }
                            System.out.println();
                        }
                    }
                    zin.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}
