package im.juejin.android.base.action;

import com.alibaba.fastjson.JSON;

import im.juejin.android.base.utils.SpUtils;
import im.juejin.android.base.utils.TextUtil;
import kotlin.jvm.internal.Intrinsics;

public class UserAction {
    public static final UserAction INSTANCE = new UserAction();

    private static UserBean userBean;

    public final String getCurrentUserId() {
        return !isLogin() ? "" : getUserId(getCurrentUser());
    }

    public static final boolean isLogin() {
        return (INSTANCE.getCurrentUser() != null);
    }


    public final String getUserId(UserBean paramUserBean) {
        if (paramUserBean == null || TextUtil.isEmpty(paramUserBean.getObjectId()))
            return "";
        String str = paramUserBean.getObjectId();
        Intrinsics.checkNotNull(str, "userBean.getObjectId()");
        return str;
    }

    public final UserBean getCurrentUser() {
        try {
            if (userBean != null)
                return userBean;
            String str = (String) SpUtils.get("CURRENT_USER", "");
            return TextUtil.isEmpty(str) ? null : (UserBean) JSON.parseObject(str, UserBean.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
