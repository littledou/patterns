package cn.readsense.current.thread;

/**
 * 测试一定计算量下多线程是否会快
 * 线程创建和上下文切换开销
 */
public class ConcurrenctTest {
    private static final long count = 100000000L;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            concurrency();
            serial();
        }

    }

    private static void concurrency() {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });

        thread.start();

        int b = 0;
        for (int i = 0; i < count; i++) {
            b += 5;
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("concurrency cost: " + (end - start) + " ms");
    }

    private static void serial() {
        long start = System.currentTimeMillis();

        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }


        int b = 0;
        for (int i = 0; i < count; i++) {
            b += 5;
        }

        long end = System.currentTimeMillis();

        System.out.println("serial cost: " + (end - start) + " ms");
    }


}
