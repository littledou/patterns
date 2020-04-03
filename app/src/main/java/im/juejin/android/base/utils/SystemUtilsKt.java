package im.juejin.android.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;

import java.util.Locale;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

public class SystemUtilsKt {
    public static final String getDeviceBrand() {
        String str = Build.BRAND;
        Intrinsics.checkNotNull(str, "android.os.Build.BRAND");
        return str;
    }

    public static final String getSystemModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNull(str, "android.os.Build.MODEL");
        return str;
    }

    public static final String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNull(str, "android.os.Build.VERSION.RELEASE");
        return str;
    }

    public static final String getUA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDeviceBrand());
        stringBuilder.append('/');
        stringBuilder.append(getSystemModel());
        stringBuilder.append(" Android/");
        stringBuilder.append(getSystemVersion());
        stringBuilder.append(" Juejin/Android/5.9.3");
        return stringBuilder.toString();
    }

    public static final void hideSoftInput(View paramView) {
        if (paramView == null)
            return;
        paramView.postDelayed(new SystemUtilsKt$hideSoftInput$1(paramView), 200L);
    }

    public static final boolean isCNorTW(Context paramContext) {
        Intrinsics.checkNotNullParameter(paramContext, "context");
        Resources resources = paramContext.getResources();
        Intrinsics.checkNotNull(resources, "context.resources");
        Locale locale = (resources.getConfiguration()).locale;
        Intrinsics.checkNotNull(locale, "context.resources.configuration.locale");
        String str = locale.getCountry();
        return (Intrinsics.areEqual(str, "CN") || Intrinsics.areEqual(str, "TW"));
    }

    public static final boolean isIntentSafe(Activity paramActivity, Intent paramIntent) {
        Intrinsics.checkNotNullParameter(paramActivity, "activity");
        Intrinsics.checkNotNullParameter(paramIntent, "intent");
        PackageManager packageManager = paramActivity.getPackageManager();
        boolean bool = false;
        if (packageManager.queryIntentActivities(paramIntent, 0).size() > 0)
            bool = true;
        return bool;
    }

    public static final void showSoftInput(View paramView) {
        if (paramView == null)
            return;
        paramView.postDelayed(new SystemUtilsKt$showSoftInput$1(paramView), 200L);
    }

    static final class SystemUtilsKt$hideSoftInput$1 implements Runnable {
        SystemUtilsKt$hideSoftInput$1(View param1View) {
        }

        public final void run() {
            Context context = this.$view.getContext();
            Intrinsics.checkNotNull(context, "view.context");
            Object object = context.getApplicationContext().getSystemService("input_method");
            if (object != null) {
                if (object != null)
                    object.hideSoftInputFromWindow(this.$view.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    static final class SystemUtilsKt$showSoftInput$1 implements Runnable {
        SystemUtilsKt$showSoftInput$1(View param1View) {
        }

        public final void run() {
            Context context = this.$view.getContext();
            Intrinsics.checkNotNull(context, "view.context");
            Object object = context.getApplicationContext().getSystemService("input_method");
            if (object != null) {
                object = object;
                if (object != null)
                    object.showSoftInput(this.$view, 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
