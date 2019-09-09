package cn.readsense.pattern.p5thread.singletosingle;

public class Producer {
    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValuePbject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValuePbject.value = value;

                System.out.println("set 的值是：" + value);
                Thread.sleep(1000);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
