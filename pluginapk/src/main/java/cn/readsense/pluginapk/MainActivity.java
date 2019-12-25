package cn.readsense.pluginapk;

import android.os.Bundle;

import cn.readsense.shellapk.activity.ainterface.BasePluginActivity;

public class MainActivity extends BasePluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
