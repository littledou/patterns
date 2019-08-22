package cn.readsense.pattern.p2factory;

public class Car extends Vehicle {
    @Override
    public Vehicle getInstance() {
        return new Car();
    }
}
