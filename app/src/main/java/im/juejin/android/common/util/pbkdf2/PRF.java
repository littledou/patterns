package im.juejin.android.common.util.pbkdf2;

public interface PRF {
    byte[] doFinal(byte[] arg1);

    int getHLen();

    void init(byte[] arg1);
}
