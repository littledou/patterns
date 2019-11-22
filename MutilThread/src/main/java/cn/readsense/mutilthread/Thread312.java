package cn.readsense.mutilthread;

/**
 * 等待通知机制
 * wait必须在同步代码块中调用，必须持有锁
 * wait后立刻释放锁
 * notify必须在同步代码块中调用，当前必须持有锁
 * notify后锁不会被马上释放，当前同步代码块执行结束才会释放
 * wait使当前正在运行的线程停止，notify使某个已经停止执行的线程继续运行
 */
public class Thread312 {

//    public static void main(String[] args) {
//        String string = new String("");
//        try {
//            string.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        String lock = new String("");
//        System.out.println("synchronized 之前");
//        synchronized (lock) {
//            System.out.println("wait之前");
//            try {
//                lock.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("wait之后");
//        }
//    }

    static class Thread1 extends Thread {
        private Object lock;

        public Thread1(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin wait time: " + System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end wait time: " + System.currentTimeMillis());
            }
        }
    }

    static class Thread2 extends Thread {
        private Object lock;

        public Thread2(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin notify time: " + System.currentTimeMillis());
                lock.notify();
                System.out.println("end notify time: " + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread1 thread1 = new Thread1(lock);
        Thread2 thread2 = new Thread2(lock);

        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
