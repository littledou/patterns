package cn.readsense.easynet.nio;

public class DBOperate implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("关闭连接");
    }
}
