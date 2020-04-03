package im.juejin.android.common;

import android.app.Application;

public class ApplicationProvider {
    private static Application application;

    public static Application getApplication() {
        if (application != null)
            return application;
        throw new RuntimeException("you must call ApplicationProvider.init() in you application onCreate");
    }

    public static void init(Application paramApplication) {
        application = paramApplication;
    }
}
