package cn.readsense.pattern.p5thread.singletosingle;

public class Consumer {
    private Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValuePbject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get 的值是：" + ValuePbject.value);
                ValuePbject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
