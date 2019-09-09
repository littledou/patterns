package cn.readsense.pattern.p5thread.singletosingle;

public class ValuePbject {
    public static String value = "";

    public static void main(String[] args) {
        Object lock = new Object();

        Producer producer = new Producer(lock);

        Consumer consumer = new Consumer(lock);

        ThreadC threadC = new ThreadC(consumer);
        ThreadP threadP = new ThreadP(producer);

        threadC.start();
        threadP.start();
    }
}
