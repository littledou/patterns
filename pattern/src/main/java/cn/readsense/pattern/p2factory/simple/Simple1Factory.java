package cn.readsense.pattern.p2factory.simple;

import cn.readsense.pattern.p2factory.Car;
import cn.readsense.pattern.p2factory.Truck;
import cn.readsense.pattern.p2factory.Vehicle;

/**
 * 简单工厂模式
 * 负责Vehicle的实例化，符合单一职责原则
 * 用户只调用Vehicle接口，符合依赖倒置原则
 * 如果需要新加一种Vehicle类型，需要对Factory进行修改，违反开闭原则
 *
 * 解决方式
 * 1.使用反射机制注册产品类和实例化
 * 2.注册产品对象，并向每个产品添加newInstance方法
 */
public class Simple1Factory {

    public enum VehicleType {
        BIKE, CAR, TRUCK
    }

    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            default:
                return null;
        }
    }
}
