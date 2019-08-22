package cn.readsense.pattern.singleton;

/**
 * 双重校验锁机制-避免已经示例化的对象仍请求锁,请求锁比if判断消耗资源
 */
public class SingleTon4 {

    private static SingleTon4 instance;

    private SingleTon4() {
    }

    public static SingleTon4 getInstance() {
        if (instance == null) {
            synchronized (SingleTon4.class) {
                if (instance == null) {
                    instance = new SingleTon4();
                }
            }
        }
        return instance;
    }
}
