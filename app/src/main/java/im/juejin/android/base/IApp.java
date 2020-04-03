package im.juejin.android.base;

import android.app.Application;

public interface IApp {
    void initModuleApp(Application paramApplication);

    void initModuleData(Application paramApplication);
}
