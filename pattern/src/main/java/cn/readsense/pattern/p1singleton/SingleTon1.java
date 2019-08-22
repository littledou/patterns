package cn.readsense.pattern.p1singleton;

/**
 * 懒汉式 - 延迟加载 -  线程不安全
 */
public class SingleTon1 {

    private static SingleTon1 instance;

    private SingleTon1() {
    }

    public static SingleTon1 getInstance() {
        if (instance == null) {
            instance = new SingleTon1();
        }
        return instance;
    }
}
