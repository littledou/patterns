package cn.readsense.mutilthread;

/**
 * 生产者消费者一对一
 */
public class Thread3111 {

    private static String value = "";

    static class P {
        private Object lock;

        public P(Object lock) {
            this.lock = lock;
        }

        public void setValue() {
            synchronized (lock) {
                if (!value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String str = System.currentTimeMillis() + "_" + System.nanoTime();

                System.out.println("set value: " + str);
                value = str;
                lock.notify();
            }
        }
    }

    static class C {
        private Object lock;

        public C(Object lock) {
            this.lock = lock;
        }

        public void getValue() {
            synchronized (lock) {
                if (value.equals("")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println("get value: " + value);

                value = "";

                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        final C c = new C(lock);
        final P p = new P(lock);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    p.setValue();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    c.getValue();
                }
            }
        }).start();

    }
}
