package im.juejin.android.common.util.pbkdf2;

public interface PBKDF2 {
    byte[] deriveKey(String arg1);

    byte[] deriveKey(String arg1, int arg2);

    PBKDF2Parameters getParameters();

    PRF getPseudoRandomFunction();

    void setParameters(PBKDF2Parameters arg1);

    void setPseudoRandomFunction(PRF arg1);

    boolean verifyKey(String arg1);
}

