package cn.readsense.pattern.p2factory.simple;

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


    public Vehicle createVehicle(String vehicleId) throws IllegalAccessException, InstantiationException {
        if (registeredProducts.containsKey(vehicleId)) {
            return (Vehicle) registeredProducts.get(vehicleId).newInstance();
        }
        return null;
    }
}
