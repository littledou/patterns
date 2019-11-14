package cn.readsense.easynet;

import org.junit.Test;

import java.io.IOException;

import cn.readsense.easynet.java.HttpDownLoad;

public class HttpDownLoadUnitTest {

    @Test
    public void run() {
        try {
            HttpDownLoad.downLoadFast("https://www.charlesproxy.com/assets/release/4.5.4/charles-proxy-4.5.4.dmg","test.dmg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
