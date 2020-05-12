package im.juejin.android.common.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

import im.juejin.android.common.ApplicationProvider;

public class ScreenUtil {

    private static void adaptScreen(Activity arg2, int arg3, boolean arg4) {
        DisplayMetrics v0 = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics v1 = ScreenUtil.getAppContext().getResources().getDisplayMetrics();
        DisplayMetrics v2 = arg2.getResources().getDisplayMetrics();
        v2.density = arg4 ? (((float) v2.widthPixels)) / (((float) arg3)) : (((float) v2.heightPixels)) / (((float) arg3));
        v2.scaledDensity = v2.density * (v0.scaledDensity / v0.density);
        v2.densityDpi = ((int) (v2.density * 160f));
        v1.density = v2.density;
        v1.scaledDensity = v2.scaledDensity;
        v1.densityDpi = v2.densityDpi;
    }

    public static void adaptScreen4HorizontalSlide(Activity arg1, int arg2) {
        ScreenUtil.adaptScreen(arg1, arg2, false);
    }

    public static void adaptScreen4VerticalSlide(Activity arg1, int arg2) {
        ScreenUtil.adaptScreen(arg1, arg2, true);
    }

    public static void cancelAdaptScreen(Activity arg3) {
        DisplayMetrics v0 = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics v1 = ScreenUtil.getAppContext().getResources().getDisplayMetrics();
        DisplayMetrics v3 = arg3.getResources().getDisplayMetrics();
        v3.density = v0.density;
        v3.scaledDensity = v0.scaledDensity;
        v3.densityDpi = v0.densityDpi;
        v1.density = v0.density;
        v1.scaledDensity = v0.scaledDensity;
        v1.densityDpi = v0.densityDpi;
    }

    public static int dip2px(float arg1) {
        return ((int) (arg1 * ScreenUtil.getAppContext().getResources().getDisplayMetrics().density + 0.5f));
    }

    private static Context getAppContext() {
        return ApplicationProvider.getApplication();
    }

    public static Bitmap getBitmapFromView(View arg2) {
        arg2.setDrawingCacheEnabled(true);
        arg2.buildDrawingCache(true);
        Bitmap v0 = arg2.getDrawingCache();
        if (v0 != null) {
            v0 = Bitmap.createBitmap(v0);
            arg2.setDrawingCacheEnabled(false);
        } else {
            v0 = null;
        }

        return v0;
    }

    public static int getNavigationBarHeight() {
        Context v0 = ScreenUtil.getAppContext();
        boolean v1 = ViewConfiguration.get(v0).hasPermanentMenuKey();
        int v2 = v0.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (v2 > 0 && !v1) {
            return v0.getResources().getDimensionPixelSize(v2);
        }

        return 0;
    }

    public static float getScreenDensity() {
        return ScreenUtil.getAppContext().getResources().getDisplayMetrics().density;
    }

    public static int getScreenDensityDpi() {
        return ScreenUtil.getAppContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static int getScreenHeight() {
        return ScreenUtil.getAppContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenRatio() {
        DisplayMetrics v0 = ScreenUtil.getAppContext().getResources().getDisplayMetrics();
        return (((float) v0.heightPixels)) / (((float) v0.widthPixels));
    }

    public static int getScreenRotation(@NonNull Activity arg2) {
        int v2 = arg2.getWindowManager().getDefaultDisplay().getRotation();
        if (v2 != 0) {
            if (v2 != 1) {
                if (v2 != 2) {
                    if (v2 != 3) {
                        return 0;
                    }

                    return 270;
                }

                return 180;
            }

            return 90;
        }

        return 0;
    }

    public static int getScreenWidth() {
        return ScreenUtil.getAppContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getSleepDuration() {
        try {
            return Settings.System.getInt(ScreenUtil.getAppContext().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException v0) {
            v0.printStackTrace();
            return 0xFFFFFF85;
        }
    }

    public static int getStatusBarHeight() {
        int v0 = ScreenUtil.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return v0 > 0 ? ScreenUtil.getAppContext().getResources().getDimensionPixelSize(v0) : 0;
    }

    public static boolean isAdaptScreen() {
        boolean v0 = Resources.getSystem().getDisplayMetrics().density != ScreenUtil.getAppContext().getResources().getDisplayMetrics().density ? true : false;
        return v0;
    }

    public static boolean isFullScreen(@NonNull Activity arg1) {
        boolean v1 = (arg1.getWindow().getAttributes().flags & 0x400) == 0x400 ? true : false;
        return v1;
    }

    public static boolean isLandscape() {
        boolean v0 = ScreenUtil.getAppContext().getResources().getConfiguration().orientation == 2 ? true : false;
        return v0;
    }

    public static boolean isPortrait() {
        boolean v1 = true;
        if (ScreenUtil.getAppContext().getResources().getConfiguration().orientation == 1) {
        } else {
            v1 = false;
        }

        return v1;
    }

    public static boolean isScreenLock() {
        Object v0 = ScreenUtil.getAppContext().getSystemService("keyguard");
        boolean v0_1 = v0 == null || !((KeyguardManager) v0).inKeyguardRestrictedInputMode() ? false : true;
        return v0_1;
    }

    public static boolean isTablet() {
        boolean v0 = (ScreenUtil.getAppContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? true : false;
        return v0;
    }

    public static Bitmap screenShot(@NonNull Activity arg1) {
        return ScreenUtil.screenShot(arg1, false);
    }

    public static Bitmap screenShot(@NonNull Activity arg6, boolean arg7) {
        Bitmap v6_2;
        View v0 = arg6.getWindow().getDecorView();
        v0.setDrawingCacheEnabled(true);
        v0.setWillNotCacheDrawing(false);
        Bitmap v2 = v0.getDrawingCache();
        if (v2 == null) {
            return null;
        }

        DisplayMetrics v3 = new DisplayMetrics();
        arg6.getWindowManager().getDefaultDisplay().getMetrics(v3);
        if (arg7) {
            Resources v6 = arg6.getResources();
            int v6_1 = v6.getDimensionPixelSize(v6.getIdentifier("status_bar_height", "dimen", "android"));
            v6_2 = Bitmap.createBitmap(v2, 0, v6_1, v3.widthPixels, v3.heightPixels - v6_1);
        } else {
            v6_2 = Bitmap.createBitmap(v2, 0, 0, v3.widthPixels, v3.heightPixels);
        }

        v0.destroyDrawingCache();
        return v6_2;
    }

    public static void setFullScreen(@NonNull Activity arg1) {
        arg1.getWindow().addFlags(0x600);
    }

    public static void setLandscape(@NonNull Activity arg1) {
        arg1.setRequestedOrientation(0);
    }

    public static void setNonFullScreen(@NonNull Activity arg1) {
        arg1.getWindow().clearFlags(0x600);
    }

    public static void setPortrait(@NonNull Activity arg1) {
        arg1.setRequestedOrientation(1);
    }

    @RequiresPermission(value = "android.permission.WRITE_SETTINGS")
    public static void setSleepDuration(int arg2) {
        Settings.System.putInt(ScreenUtil.getAppContext().getContentResolver(), "screen_off_timeout", arg2);
    }

    public static int spToPx(float arg2) {
        return ((int) TypedValue.applyDimension(2, arg2, ScreenUtil.getAppContext().getResources().getDisplayMetrics()));
    }

    public static void toggleFullScreen(@NonNull Activity arg3) {
        Window v3 = arg3.getWindow();
        int v2 = 0x600;
        if ((v3.getAttributes().flags & 0x400) == 0x400) {
            v3.clearFlags(v2);
        } else {
            v3.addFlags(v2);
        }
    }
}
