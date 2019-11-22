package cn.readsense.mutilthread;

import java.util.ArrayList;
import java.util.List;


/*
等待wait的条件发生了变化
 */
public class Thread3110 {
    private static List list = new ArrayList();

    static class Add {
        private String lock;

        public Add(String lock) {
            this.lock = lock;
        }

        public void add() {
            synchronized (lock) {
                list.add("any");
                lock.notifyAll();
            }
        }
    }

    static class Subtract {
        private String lock;

        public Subtract(String lock) {
            this.lock = lock;
        }

        public void subtract() {
            synchronized (lock) {
                while (list.size() == 0) {


                    System.out.println(Thread.currentThread().getName() + ": wait begin");

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": wait end");

                }

                list.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        String lock = new String("");
        final Add add = new Add(lock);
        final Subtract subtract = new Subtract(lock);

        Thread subtractThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                subtract.subtract();
            }
        });
        subtractThread1.setName(" subtract thread 1");
        subtractThread1.start();

        Thread subtractThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                subtract.subtract();
            }
        });
        subtractThread2.setName(" subtract thread 2");
        subtractThread2.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add.add();
            }
        });


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }

}
