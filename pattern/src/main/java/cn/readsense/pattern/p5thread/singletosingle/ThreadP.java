package cn.readsense.pattern.p5thread.singletosingle;

public class ThreadP extends Thread {
    private Producer producer;

    public ThreadP(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            producer.setValue();
        }
    }
}
