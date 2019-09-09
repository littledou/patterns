package cn.readsense.pattern.p5_p_c.p_c_single;

public class ThreadC extends Thread {
    private Consumer consumer;

    public ThreadC(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}
