package im.juejin.android.common.util.pbkdf2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MacBasedPRF implements PRF {
    protected int hLen;
    protected Mac mac;
    protected String macAlgorithm;

    public MacBasedPRF(String arg2) {
        super();
        this.macAlgorithm = arg2;
        try {
            this.mac = Mac.getInstance(arg2);
            this.hLen = this.mac.getMacLength();
            return;
        }
        catch(NoSuchAlgorithmException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    public MacBasedPRF(String arg1, String arg2) {
        super();
        this.macAlgorithm = arg1;
        try {
            this.mac = Mac.getInstance(arg1, arg2);
            this.hLen = this.mac.getMacLength();
            return;
        }
        catch(NoSuchProviderException v1) {
            throw new RuntimeException(((Throwable)v1));
        }
        catch(NoSuchAlgorithmException v1_1) {
            throw new RuntimeException(((Throwable)v1_1));
        }
    }

    public byte[] doFinal(byte[] arg2) {
        return this.mac.doFinal(arg2);
    }

    public int getHLen() {
        return this.hLen;
    }

    public void init(byte[] arg4) {
        try {
            this.mac.init(new SecretKeySpec(arg4, this.macAlgorithm));
            return;
        }
        catch(InvalidKeyException v4) {
            throw new RuntimeException(((Throwable)v4));
        }
    }
}

