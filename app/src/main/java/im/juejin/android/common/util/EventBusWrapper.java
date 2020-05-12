package im.juejin.android.common.util;

import org.greenrobot.eventbus.EventBus;

public class EventBusWrapper {
    public EventBusWrapper() {
        super();
    }

    public static boolean isRegistered(Object arg1) {
        return EventBus.getDefault().isRegistered(arg1);
    }

    public static void post(Object arg1) {
        EventBus.getDefault().post(arg1);
    }

    public static void register(Object arg1) {
        EventBus.getDefault().register(arg1);
    }

    public static void unregister(Object arg1) {
        EventBus.getDefault().unregister(arg1);
    }
}

