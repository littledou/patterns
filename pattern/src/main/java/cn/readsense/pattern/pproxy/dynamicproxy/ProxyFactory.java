package cn.readsense.pattern.pproxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object object) {
        this.target = object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Class<?>[] interfaces = target.getClass().getInterfaces();
                        System.out.println("开始动态代理-执行事务 "+ Arrays.toString(target.getClass().getInterfaces()));
                        Object invoke = method.invoke(target, objects);
                        System.out.println("结束动态代理-执行事务");
                        return null;
                    }
                });
    }

}
