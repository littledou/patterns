package cn.readsense.pattern.p2factory.method.factory;

import cn.readsense.pattern.p2factory.Vehicle;
import cn.readsense.pattern.p2factory.method.SedanCar;
import cn.readsense.pattern.p2factory.method.SportCar;

public class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(String size) {
        if (size.equals("small")) {
            return new SportCar();
        } else if (size.equals("large")) {
            return new SedanCar();
        }
        return null;
    }


    public static void main(String args[]) {
        VehicleFactory vehicleFactory = new CarFactory();
        vehicleFactory.orderVehicle("large", "blue");

    }
}
