package cn.readsense.pattern.pproxy.staticproxy;

import org.junit.Test;

import cn.readsense.pattern.pproxy.IUserDao;
import cn.readsense.pattern.pproxy.UserDao;
import cn.readsense.pattern.pproxy.dynamicproxy.ProxyFactory;

public class ProxyTest {

    @Test
    public void staticProxy() {

        IUserDao target = new UserDao();

        UserDaoProxy userDaoProxy = new UserDaoProxy(target);

        userDaoProxy.save();
    }

    @Test
    public void dynamicProxy() {
        IUserDao target = new UserDao();

        IUserDao instance = (IUserDao) new ProxyFactory(target).getProxyInstance();

        instance.save();

    }


}