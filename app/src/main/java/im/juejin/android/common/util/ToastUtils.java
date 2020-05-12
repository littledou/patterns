package im.juejin.android.common.util;

import android.content.Context;
import android.widget.Toast;

import com.growingio.android.sdk.autoburry.VdsAgent;

import im.juejin.android.common.ApplicationProvider;

public class ToastUtils {
    public static Context getContext() {
        return ApplicationProvider.getApplication();
    }

    public static void show(int arg1) {
        ToastUtils.show(ToastUtils.getContext().getResources().getText(arg1));
    }

    public static void show(CharSequence arg3) {
        Toast v3 = Toast.makeText(ToastUtils.getContext(), arg3, 0);
        v3.show();
        if(VdsAgent.isRightClass("android/widget/Toast", "show", "()V", "android/widget/Toast")) {
            VdsAgent.showToast(v3);
        }
    }

    public static void showL(int arg1) {
        ToastUtils.showL(ToastUtils.getContext().getResources().getText(arg1));
    }

    public static void showL(CharSequence arg3) {
        Toast v3 = Toast.makeText(ToastUtils.getContext(), arg3, 1);
        v3.show();
        if(VdsAgent.isRightClass("android/widget/Toast", "show", "()V", "android/widget/Toast")) {
            VdsAgent.showToast(v3);
        }
    }
}
