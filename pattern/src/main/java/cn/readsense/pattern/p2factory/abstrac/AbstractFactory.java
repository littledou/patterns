package cn.readsense.pattern.p2factory.abstrac;

import cn.readsense.pattern.p2factory.abstrac.color.Color;
import cn.readsense.pattern.p2factory.abstrac.shape.Shape;

/**
 *
 */
public abstract class AbstractFactory {
    protected final static String SHAPE = "shape";
    protected final static String COLOR = "color";

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);

}
