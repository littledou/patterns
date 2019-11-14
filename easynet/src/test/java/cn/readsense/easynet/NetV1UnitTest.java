package cn.readsense.easynet;

import org.junit.Test;

import cn.readsense.easynet.java.HttpGET;

public class NetV1UnitTest {

    @Test
    public void run() {
//        final String message = NetUtilv1.get("https://www.v2ex.com/api/topics/hot.json");

        try {
            final String html = HttpGET.getHtml("http://www.so.com");

            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
