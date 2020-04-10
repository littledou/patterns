package cn.readsense.aac;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        System.out.println("attachBaseContext");
    }
}
