package cn.readsense.easynet.java;

import org.junit.Test;

public class UCNHttpTest {

    @Test
    public void getBody() {
        System.out.println(UCNHttp.get("http://gank.io/api/data/福利/10/1"));
    }

    @Test
    public void post() {
        System.out.println(UCNHttp.post("http://orion.readsense.cn/v1/api/sign_in", null));
    }
}