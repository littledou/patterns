package cn.readsense.easynet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import cn.readsense.easynet.java.UCNHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String body = UCNHttp.get("ata/福利/10/1");
                    System.out.println(body);

                    Map<String, String> pa = new HashMap();
                    pa.put("account", "rsandroidtest");
                    pa.put("password", "12345678");
                    body = UCNHttp.post("http://orion.readsense.cn/v1/api/sign_in", pa);
                    System.out.println(body);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
