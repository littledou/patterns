package im.juejin.android.account;

import android.app.Application;

import im.juejin.android.base.BaseApp;
import im.juejin.android.common.ApplicationProvider;

public class AccountApp extends BaseApp {


    public void initModuleApp(Application arg1) {
    }

    public void initModuleData(Application arg1) {
    }

    public void onCreate() {
        super.onCreate();
        ApplicationProvider.init(((Application) this));
    }
}
