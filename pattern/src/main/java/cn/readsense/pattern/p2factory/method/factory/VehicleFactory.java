package cn.readsense.pattern.p2factory.method.factory;

import cn.readsense.pattern.p2factory.Vehicle;
import cn.readsense.pattern.p2factory.method.CityBike;

/**
 * 工厂方法模式：工厂类被抽象化，用于实例化特定产品类的代码被转移至实现抽象方法的子类中，不需要修改就可以扩展工厂类
 */
public abstract class VehicleFactory {

    protected abstract Vehicle createVehicle(String size);

    public Vehicle orderVehicle(String size, String color) {

        Vehicle vehicle = createVehicle(size);
        vehicle.testVehicle();
        vehicle.setColor(color);
        return vehicle;
    }



    public static void main(String args[]) {

    }

    //匿名工厂
    VehicleFactory vehicleFactory = new VehicleFactory() {
        @Override
        protected Vehicle createVehicle(String size) {
            if (size.equals("small"))
                return new CityBike();
            return null;
        }
    };
}
