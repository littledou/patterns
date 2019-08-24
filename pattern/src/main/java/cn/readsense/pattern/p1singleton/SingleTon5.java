package cn.readsense.pattern.p1singleton;

/**
 * 登记式，静态内部类
 */
public class SingleTon5 {

    private static class SingleTonHolder {
        private static final SingleTon5 INSTANCE = new SingleTon5();
    }

    private SingleTon5() {

    }

    public SingleTon5 getInstance() {
        return SingleTonHolder.INSTANCE;
    }
}
