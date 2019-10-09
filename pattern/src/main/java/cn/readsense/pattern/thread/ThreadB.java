package cn.readsense.pattern.thread;

public class ThreadB extends Thread{
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                
                System.out.println("list.size(): "+list.size());
                if (list.size() == 5) {
                    System.out.println("list size = 5, thread B out");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
