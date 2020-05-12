
泛型: 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型

    泛型方法
        无界类型参数: <E>
        有界类型参数: <T extends Comparable<T>>

    泛型类: class ClassName<T>

    泛型接口: interface Generator<T>
        实现泛型接口的类，未传入泛型实参: class FruitGenerator<T> implements Generator<T>
        实现泛型接口的类，传入泛型实参: class FruitGenerator implements Generator<String>

    泛型通配符
        类型参数: <?>
        上限类型参数: <? extends Number>接收Number类型以及其子类
        下限类型参数: <? super Number>接收Number类型以及其三层父类

