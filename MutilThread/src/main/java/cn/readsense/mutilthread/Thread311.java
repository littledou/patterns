package cn.readsense.mutilthread;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用等待/通知机制实现线程间通信
 */
public class Thread311 {


    static class ThreadA extends Thread {
        private List mList;

        public ThreadA(List mList) {
            this.mList = mList;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                mList.add(i + " - " + System.nanoTime());

                System.out.println("添加了" + (i + 1) + "个元素");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
            while (true) {
                System.out.println("线程b " + mList.size());
                if (mList.size() == 5) {

                    System.out.println("==5 了， 线程b要退出了");
                    break;
                }
            }

            System.out.println("线程b要退出");
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();
    }
}
