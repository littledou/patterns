package im.juejin.android.componentbase.service;

import okhttp3.Request;

public interface IDebugService {
    void configureInterceptor(Request.Builder arg1);
}