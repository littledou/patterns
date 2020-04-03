package im.juejin.android.base.utils;

import android.util.Log;


public class AppLogger {

    public static boolean DEBUG = isRelease() ^ true;

    protected static final String TAG = "GoldDebug";

    protected static String buildMessage(String paramString) {
        StackTraceElement stackTraceElement = (new Throwable()).fillInStackTrace().getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        stringBuilder.append("(): ");
        stringBuilder.append(paramString);
        return stringBuilder.toString();
    }

    public static void d(String paramString) {
        if (DEBUG)
            Log.d("GoldDebug", buildMessage(paramString));
    }

    public static void d(String paramString, Throwable paramThrowable) {
        if (DEBUG)
            Log.d("GoldDebug", buildMessage(paramString), paramThrowable);
    }

    public static void e(String paramString) {
        if (DEBUG)
            Log.e("GoldDebug", buildMessage(paramString));
    }

    public static void e(String paramString, Throwable paramThrowable) {
        if (DEBUG)
            Log.e("GoldDebug", buildMessage(paramString), paramThrowable);
    }

    public static void e(Throwable paramThrowable) {
        if (DEBUG)
            paramThrowable.printStackTrace();
    }

    public static void i(String paramString) {
        if (DEBUG)
            Log.i("GoldDebug", buildMessage(paramString));
    }

    public static void i(String paramString, Throwable paramThrowable) {
        if (DEBUG)
            Log.i("GoldDebug", buildMessage(paramString), paramThrowable);
    }

    public static boolean isRelease() {
        return false;
    }

    public static void longInfo(String paramString) {
        if (paramString.length() > 2000) {
            Log.d("GoldDebug", paramString.substring(0, 2000));
            longInfo(paramString.substring(2000));
            return;
        }
        Log.d("GoldDebug", paramString);
    }

    public static void v(String paramString) {
        if (DEBUG)
            Log.v("GoldDebug", buildMessage(paramString));
    }

    public static void v(String paramString, Throwable paramThrowable) {
        if (DEBUG)
            Log.v("GoldDebug", buildMessage(paramString), paramThrowable);
    }

    public static void w(String paramString) {
        if (DEBUG)
            Log.w("GoldDebug", buildMessage(paramString));
    }

    public static void w(String paramString, Throwable paramThrowable) {
        if (DEBUG)
            Log.w("GoldDebug", buildMessage(paramString), paramThrowable);
    }

    public static void w(Throwable paramThrowable) {
        if (DEBUG)
            Log.w("GoldDebug", buildMessage(""), paramThrowable);
    }
}
