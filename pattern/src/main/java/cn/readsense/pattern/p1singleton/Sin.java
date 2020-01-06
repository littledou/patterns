package cn.readsense.pattern.p1singleton;

public class Sin {
    private static final Sin ourInstance = new Sin();

    public static Sin getInstance() {
        return ourInstance;
    }

    private Sin() {
    }
}
