package cn.readsense.pattern.p5_p_c.p_c_allwait;

public class P {
    private Object lock;

    public P(Object loak) {
        this.lock = loak;
    }

    public void setValue(){
        try {
            synchronized(lock){

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
