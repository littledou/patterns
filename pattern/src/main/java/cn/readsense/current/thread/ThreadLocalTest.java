package cn.readsense.current.thread;

public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {

        String name = "dddd_0.jpg";

        System.out.println(int.class.toString());
        System.out.println(Integer.class.toString());

//        final ThreadLocalTest test = new ThreadLocalTest();
//
//
//        test.set();
//        System.out.println("main " + test.getLong());
//        System.out.println("main " + test.getString());
//
//
//        Thread thread1 = new Thread() {
//            public void run() {
//                test.set();
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println(test.getLong());
//                    System.out.println(test.getString());
//                }
//
//            }
//
//        };
//        thread1.start();
////        thread1.join();
//
//        for (int i = 0; i < 1000; i++) {
//            System.out.println("main " + test.getLong());
//            System.out.println("main " + test.getString());
//        }
    }
}
