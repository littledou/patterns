package cn.readsense.pattern.p2factory;

/**
 * 工厂模式原因：继承构成多态，主类除了固有功能外还需要实例化Vehicle对象，打破了单一职责原则
 */
public class Test {

    public static void main(String args[]) {
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Truck();
    }
}
