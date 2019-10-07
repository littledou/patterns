package cn.readsense.pattern.thread;

public class MyWaitNotify {
    private final Object object = new Object();

    private boolean wasSignalled = false;

    public void doWait() {
        synchronized (object) {
            while (!wasSignalled) {
                try {
                    object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (object) {
            wasSignalled = true;
            object.notify();
        }
    }
}
