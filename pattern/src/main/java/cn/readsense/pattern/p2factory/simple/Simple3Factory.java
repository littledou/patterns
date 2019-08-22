package cn.readsense.pattern.p2factory.simple;

import cn.readsense.pattern.p2factory.Car;
import cn.readsense.pattern.p2factory.Truck;
import cn.readsense.pattern.p2factory.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册产品对象，并向每个产品添加newInstance方法
 */
public class Simple3Factory {

    private Map<String, Vehicle> registeredProducts = new HashMap<>();

    public void registerVehicle(String vehicleId, Vehicle vehicleClass) {
        registeredProducts.put(vehicleId, vehicleClass);
    }

    public Vehicle createVehicle(String vehicleId) {
        if (registeredProducts.containsKey(vehicleId)) {
            return registeredProducts.get(vehicleId).getInstance();
        }
        return null;
    }

    public static void main(String args[]) {
        Simple3Factory simple3Factory = new Simple3Factory();
        simple3Factory.registerVehicle("car", new Car());
        simple3Factory.registerVehicle("truck", new Truck());

        final Vehicle instance3 = simple3Factory.createVehicle("car");
    }
}
