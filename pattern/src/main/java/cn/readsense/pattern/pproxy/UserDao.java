package cn.readsense.pattern.pproxy;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("-----已保存数据------");
    }
}