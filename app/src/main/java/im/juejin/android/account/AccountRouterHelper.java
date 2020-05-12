package im.juejin.android.account;

import android.content.Context;
import android.content.Intent;

import im.juejin.android.base.utils.AppLogger;

public class AccountRouterHelper {
    public static final AccountRouterHelper INSTANCE = new AccountRouterHelper();


    public final Intent getVerifyPopActivityIntent(Context arg4, String arg5) {
//        Intrinsics.checkParameterIsNotNull(arg4, "activityContext");
//        Intrinsics.checkParameterIsNotNull(arg5, "jsurl");
//        Intent v1 = new Intent(arg4, VerifyPopupActivity.class);
//        v1.putExtra("jsurl", arg5);
        //TODO 移除验证
        AppLogger.d("getVerifyPopActivityIntent 移除验证");
        return null;
    }
}
