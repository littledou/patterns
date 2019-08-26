package cn.readsense.pattern.p2factory.abstrac;

import cn.readsense.pattern.p2factory.abstrac.color.Color;
import cn.readsense.pattern.p2factory.abstrac.color.ColorFactory;
import cn.readsense.pattern.p2factory.abstrac.shape.Shape;
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


    public static void main(String args[]) {
        AbstractFactory abstractFactoryColor = AbstractProduct.getFactory(AbstractFactory.COLOR);
        final Color color = abstractFactoryColor.getColor(Color.BLUE);
        color.fill();

        AbstractFactory abstractFactoryShape = AbstractProduct.getFactory(AbstractFactory.SHAPE);
        final Shape shape = abstractFactoryShape.getShape(Shape.CIRCLE);
        shape.draw();
    }
}
