package im.juejin.android.componentbase.emptyservice;

import android.util.Log;

import im.juejin.android.componentbase.service.IDebugService;
import okhttp3.Request;

public class EmptyDebugService implements IDebugService {
    public EmptyDebugService() {
        super();
    }

    public void configureInterceptor(Request.Builder arg2) {
        Log.e("STETHO", "STETHO OKHTTP EMPTY");
    }
}