package im.juejin.android.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.concurrent.TimeUnit;

import im.juejin.android.base.network.HttpLoggingInterceptor;
import im.juejin.android.base.network.RequestHeaderInterceptor;
import im.juejin.android.base.utils.AppLogger;
import im.juejin.android.common.ApplicationProvider;
import im.juejin.android.common.netclient.JJNet;
import okhttp3.OkHttpClient;

public abstract class BaseApp extends Application implements IApp {
    public static boolean isMainActivityLived = false;

    private void initARouter() {
        if (!AppLogger.isRelease()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private void initCommonLibrary() {
        ApplicationProvider.init(this);
    }

    private void initNetClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(20L, TimeUnit.SECONDS)
                .writeTimeout(20L, TimeUnit.SECONDS)
                .addInterceptor(new RequestHeaderInterceptor());
        if (!AppLogger.isRelease())
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        JJNet.INSTANCE.setClient(builder.build());
    }


    public void onCreate() {
        super.onCreate();
        initARouter();
        initCommonLibrary();
        initNetClient();
        initModuleApp(this);
        initModuleData(this);
    }
}
