package cn.readsense.current.lock;

/**
 * 不可重入锁， 也称自旋锁
 */
public class Lock1 {
    boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked)
            wait();
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) {

    }

    Lock1 lock1 = new Lock1();

    public void print() throws InterruptedException {
        lock1.lock();
        add();
        lock1.unlock();
    }

    public void add() throws InterruptedException {
        lock1.lock();
        //TODO do something
        lock1.unlock();
    }
}
