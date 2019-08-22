package cn.readsense.pattern.p1singleton;

/**
 * 同步锁单例模式--两种方式实现
 */
public class SingleTon3 {

    private static SingleTon3 instance;

    private SingleTon3() {
    }

    public static synchronized SingleTon3 getInstance1() {
        if (instance == null) {
            instance = new SingleTon3();
        }
        return instance;
    }

    public static SingleTon3 getInstance2() {

        synchronized (SingleTon3.class) {
            if (instance == null) {
                instance = new SingleTon3();
            }
        }
        return instance;
    }
}
