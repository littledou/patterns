package cn.readsense.pattern.pproxy.staticproxy;

import cn.readsense.pattern.pproxy.IUserDao;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始静态代理");
        target.save();
        System.out.println("结束静态代理");
    }



}
