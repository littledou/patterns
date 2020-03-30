package cn.readsense.aac;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class CameraManager implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void openCamera() {
        System.out.println("open camera done!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void closeCamera() {
        System.out.println("close camera done!");
    }
}
