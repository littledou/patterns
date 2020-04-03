package im.juejin.android.base.utils;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import im.juejin.android.common.ApplicationProvider;

public class SpUtils {

    private static final String DEVICE_NAME = "juejin_device";

    public static final String FILE_NAME = "juejin_default";

    public static void clear() {
        SharedPreferences.Editor editor = getSp().edit();
        editor.clear();
        editor.apply();
    }

    public static void clearDevice() {
        SharedPreferences.Editor editor = getDeviceSp().edit();
        editor.clear();
        editor.apply();
    }

    public static boolean contains(String paramString) {
        return getSp().contains(paramString);
    }

    public static boolean containsDevice(String paramString) {
        return getDeviceSp().contains(paramString);
    }

    public static <T> T get(String paramString, T paramT) {
        return get(paramString, paramT, getSp());
    }

    @Nullable
    private static <T> T get(String paramString, T paramT, SharedPreferences paramSharedPreferences) {
        return (T) ((paramT instanceof Boolean) ? Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, ((Boolean) paramT).booleanValue())) : ((paramT instanceof String) ? paramSharedPreferences.getString(paramString, (String) paramT) : ((paramT instanceof Float) ? Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float) paramT).floatValue())) : ((paramT instanceof Long) ? Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long) paramT).longValue())) : ((paramT instanceof Integer) ? Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer) paramT).intValue())) : null)))));
    }

    public static <T> T getDevice(String paramString, T paramT) {
        return get(paramString, paramT, getDeviceSp());
    }

    private static SharedPreferences getDeviceSp() {
        return ApplicationProvider.getApplication().getSharedPreferences(DEVICE_NAME, 0);
    }

    private static SharedPreferences getSp() {
        return ApplicationProvider.getApplication().getSharedPreferences(FILE_NAME, 0);
    }

    public static void remove(String paramString) {
        SharedPreferences.Editor editor = getSp().edit();
        editor.remove(paramString);
        editor.apply();
    }

    public static void removeDevice(String paramString) {
        SharedPreferences.Editor editor = getDeviceSp().edit();
        editor.remove(paramString);
        editor.apply();
    }

    public static void save(String paramString, Object paramObject) {
        save(paramString, paramObject, getSp().edit());
    }

    private static void save(String paramString, Object paramObject, SharedPreferences.Editor paramEditor) {
        if (paramObject instanceof Boolean) {
            paramEditor.putBoolean(paramString, ((Boolean) paramObject).booleanValue());
        } else if (paramObject instanceof String) {
            paramEditor.putString(paramString, (String) paramObject);
        } else if (paramObject instanceof Integer) {
            paramEditor.putInt(paramString, ((Integer) paramObject).intValue());
        } else if (paramObject instanceof Float) {
            paramEditor.putFloat(paramString, ((Float) paramObject).floatValue());
        } else if (paramObject instanceof Long) {
            paramEditor.putLong(paramString, ((Long) paramObject).longValue());
        }
        paramEditor.apply();
    }

    public static void saveDevice(String paramString, Object paramObject) {
        save(paramString, paramObject, getDeviceSp().edit());
    }
}
