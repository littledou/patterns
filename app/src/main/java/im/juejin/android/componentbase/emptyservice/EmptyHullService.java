package im.juejin.android.componentbase.emptyservice;


import im.juejin.android.componentbase.service.IHullService;

public class EmptyHullService implements IHullService {
    public EmptyHullService() {
        super();
    }

    public void fromPush(String arg1) {
    }

    public String getApplicationId() {
        return "com.daimajia.gold";
    }

    public String getPushJSON() {
        return "";
    }

    public float getScreenRatio() {
        return 1.77777f;
    }

    public boolean isFromPush() {
        return false;
    }

    public boolean isMainActivityLived() {
        return false;
    }
}
