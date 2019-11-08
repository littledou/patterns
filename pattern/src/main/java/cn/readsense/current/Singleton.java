package cn.readsense.current;

public class Singleton {
    private volatile static Singleton ourInstance;

    public static Singleton getInstance() {
        if (ourInstance == null) {
            synchronized (Singleton.class) {
                if (ourInstance == null) {
                    ourInstance = new Singleton();
                }
            }
        }
        return ourInstance;
    }

    private Singleton() {
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
