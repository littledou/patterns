package im.juejin.android.componentbase.service;


public interface IHullService {
    void fromPush(String arg1);

    String getApplicationId();

    String getPushJSON();

    float getScreenRatio();

    boolean isFromPush();

    boolean isMainActivityLived();
}

