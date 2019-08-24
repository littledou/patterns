package cn.readsense.pattern.p2factory.abstrac;

import cn.readsense.pattern.p2factory.abstrac.color.ColorFactory;
import cn.readsense.pattern.p2factory.abstrac.shape.ShapeFactory;

public class AbstractProduct {

    public static AbstractFactory getFactory(String factoryType) {

        switch (factoryType) {
            case AbstractFactory.COLOR:
                return new ColorFactory();
            case AbstractFactory.SHAPE:
                return new ShapeFactory();
        }

        return null;
    }
}
