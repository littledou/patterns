package cn.readsense.pattern.p2factory.simple;

import cn.readsense.pattern.p2factory.Car;
import cn.readsense.pattern.p2factory.Truck;
import cn.readsense.pattern.p2factory.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用反射机制注册产品类和实例化
 */
public class Simple2Factory {

    private Map<String, Class> registeredProducts = new HashMap<>();

    public void registerVehicle(String vehicleId, Class vehicleClass) {
        registeredProducts.put(vehicleId, vehicleClass);
    }


    public Vehicle createVehicle(String vehicleId) {
        if (registeredProducts.containsKey(vehicleId)) {
            try {
                return (Vehicle) registeredProducts.get(vehicleId).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String args[]) {
        Simple2Factory simple2Factory = new Simple2Factory();
        simple2Factory.registerVehicle("car", Car.class);
        simple2Factory.registerVehicle("truck", Truck.class);
        final Vehicle instance2 = simple2Factory.createVehicle("car");
    }
}
