package cn.readsense.pattern.p2factory.abstrac.shape;

import cn.readsense.pattern.p2factory.abstrac.AbstractFactory;
import cn.readsense.pattern.p2factory.abstrac.color.Color;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shape) {
        switch (shape) {
            case Shape.CIRCLE:
                return new Circle();
            case Shape.RECTANGLE:
                return new Rectangle();
            case Shape.SQUARE:
                return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
