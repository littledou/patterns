package cn.readsense.mutilthread;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用等待/通知机制实现线程间通信
 */
public class Thread313 {
    static class ThreadA extends Thread {
        private List mList;

        public ThreadA(List mList) {
            this.mList = mList;
        }

        @Override
        public void run() {
            synchronized (mList) {
                for (int i = 0; i < 10; i++) {
                    mList.add(i + " - " + System.nanoTime());

                    System.out.println("添加了" + (i + 1) + "个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (mList.size() == 5) {
                        mList.notify();

                        System.out.println("nodify ");
                    }
                }
            }
        }
    }

    static class ThreadB extends Thread {
        private List mList;

        public ThreadB(List mList) {
            this.mList = mList;
        }

        @Override
        public void run() {
            synchronized (mList) {
                if (mList.size() != 5) {
                    System.out.println("!=5 了， 线程b进入等待");
                    try {
                        mList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("==5 了， 线程b要退出了");
                }
            }
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList();

        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();


        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();

    }
}
