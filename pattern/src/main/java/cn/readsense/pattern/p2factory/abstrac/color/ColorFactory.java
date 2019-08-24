package cn.readsense.pattern.p2factory.abstrac.color;

import cn.readsense.pattern.p2factory.abstrac.AbstractFactory;
import cn.readsense.pattern.p2factory.abstrac.shape.Shape;

public class ColorFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case Color.RED:
                return new Red();
            case Color.GREEN:
                return new Green();
            case Color.BLUE:
                return new Blue();
        }
        return null;
    }
}
