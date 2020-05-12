package im.juejin.android.common.util.pbkdf2;

public class PBKDF2Parameters {
    private byte[] derivedKey;
    private String hashAlgorithm;
    private String hashCharset;
    private int iterationCount;
    private byte[] salt;

    public PBKDF2Parameters() {
        super();
        this.hashAlgorithm = null;
        this.hashCharset = "UTF-8";
        this.salt = null;
        this.iterationCount = 1000;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(String arg1, String arg2, byte[] arg3, int arg4) {
        super();
        this.hashAlgorithm = arg1;
        this.hashCharset = arg2;
        this.salt = arg3;
        this.iterationCount = arg4;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(String arg1, String arg2, byte[] arg3, int arg4, byte[] arg5) {
        super();
        this.hashAlgorithm = arg1;
        this.hashCharset = arg2;
        this.salt = arg3;
        this.iterationCount = arg4;
        this.derivedKey = arg5;
    }

    public byte[] getDerivedKey() {
        return this.derivedKey;
    }

    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public String getHashCharset() {
        return this.hashCharset;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void setDerivedKey(byte[] arg1) {
        this.derivedKey = arg1;
    }

    public void setHashAlgorithm(String arg1) {
        this.hashAlgorithm = arg1;
    }

    public void setHashCharset(String arg1) {
        this.hashCharset = arg1;
    }

    public void setIterationCount(int arg1) {
        this.iterationCount = arg1;
    }

    public void setSalt(byte[] arg1) {
        this.salt = arg1;
    }
}

