package cn.readsense.pattern.p1singleton;

/**
 * 饿汉式-提前加载-无锁安全，新的jvm上类只有在使用时才会被加载，最佳单例是这个，效率最高
 */
public class SingleTon2 {

    static {
        System.out.println("SingleTon2");
    }

    private static final SingleTon2 instance = new SingleTon2(1);

    int i;

    private SingleTon2(int i) {
        this.i = i;
    }

    public static SingleTon2 getInstance() {
        return instance;
    }
}
