package cn.readsense.pattern.p2factory;

public class Truck extends Vehicle{
    @Override
    public Vehicle getInstance() {
        return new Truck();
    }
}
