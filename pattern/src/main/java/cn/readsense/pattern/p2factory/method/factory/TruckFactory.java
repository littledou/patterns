package cn.readsense.pattern.p2factory.method.factory;

import cn.readsense.pattern.p2factory.Vehicle;
import cn.readsense.pattern.p2factory.method.LargeTruck;
import cn.readsense.pattern.p2factory.method.SmallTruck;

public class TruckFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(String size) {
        if (size.equals("small")) {
            return new SmallTruck();
        } else if (size.equals("large")) {
            return new LargeTruck();
        }
        return null;
    }


    public static void main(String args[]) {
        VehicleFactory vehicleFactory = new TruckFactory();
        vehicleFactory.orderVehicle("large", "blue");
    }
}
