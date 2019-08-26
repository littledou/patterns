package cn.readsense.pattern.p3builder;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
