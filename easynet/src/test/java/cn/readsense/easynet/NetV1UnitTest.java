package cn.readsense.easynet;

import org.junit.Test;

import cn.readsense.easynet.java.NetUtilv1;

public class NetV1UnitTest {

    @Test
    public void runGetHot() {
        final String message = NetUtilv1.get("https://www.v2ex.com/api/topics/hot.json");

        System.out.println(message);
    }
}
