package cn.readsense.pattern.singleton;

/**
 * 饿汉式-提前加载-无锁安全，新的jvm上类只有在使用时才会被加载，最佳单例是这个，效率最高
 */
public class SingleTon2 {

    private static SingleTon2 instance = new SingleTon2();

    private SingleTon2() {
    }

    public SingleTon2 getInstance() {
        return instance;
    }
}
