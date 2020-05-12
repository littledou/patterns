package im.juejin.android.common.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;

import im.juejin.android.common.ApplicationProvider;

public class ColorUtil {
    public ColorUtil() {
        super();
    }

    public static int getAttrColor(int arg3) {
        TypedValue v0 = new TypedValue();
        ApplicationProvider.getApplication().getTheme().resolveAttribute(arg3, v0, true);
        return v0.data;
    }

    public static int getAttrColor(Context arg2, int arg3) {
        TypedValue v0 = new TypedValue();
        arg2.getTheme().resolveAttribute(arg3, v0, true);
        return v0.data;
    }

    public static int getColor(int arg1) {
        return ContextCompat.getColor(ApplicationProvider.getApplication(), arg1);
    }

    public static ColorStateList newColorStateList(int arg0) {
        return ColorStateList.valueOf(arg0);
    }

    public static ColorStateList newColorStateList(int arg7, int arg8) {
        int[][] v0 = new int[][]{new int[]{0xFEFEFF5F}, new int[]{0x10100A0}, new int[]{0x10100A7}, new int[]{0x101009E}, new int[]{0x10100A1}};
        int[] v2 = new int[9];
        v2[0] = arg7;
        v2[1] = arg8;
        v2[2] = arg8;
        v2[3] = arg8;
        v2[4] = arg8;
        return new ColorStateList(v0, v2);
    }
}

