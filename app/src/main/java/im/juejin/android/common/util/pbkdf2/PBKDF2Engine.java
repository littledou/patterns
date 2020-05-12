package im.juejin.android.common.util.pbkdf2;


import java.io.UnsupportedEncodingException;

public class PBKDF2Engine implements PBKDF2 {
    protected PBKDF2Parameters parameters;
    protected PRF prf;

    public PBKDF2Engine() {
        super();
        this.parameters = null;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters arg1) {
        super();
        this.parameters = arg1;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters arg1, PRF arg2) {
        super();
        this.parameters = arg1;
        this.prf = arg2;
    }

    protected void INT(byte[] arg3, int arg4, int arg5) {
        arg3[arg4] = ((byte) (arg5 / 0x1000000));
        arg3[arg4 + 1] = ((byte) (arg5 / 0x10000));
        arg3[arg4 + 2] = ((byte) (arg5 / 0x100));
        arg3[arg4 + 3] = ((byte) arg5);
    }

    protected byte[] PBKDF2(PRF arg18, byte[] arg19, int arg20, int arg21) {
        int v0 = arg21;
        byte[] v2 = arg19 == null ? new byte[0] : arg19;
        int v10 = arg18.getHLen();
        int v12 = this.ceil(v0, v10);
        int v13 = v0 - (v12 - 1) * v10;
        byte[] v14 = new byte[v12 * v10];
        int v15 = 1;
        int v16 = 0;
        while (v15 <= v12) {
            this._F(v14, v16, arg18, v2, arg20, v15);
            v16 += v10;
            ++v15;
        }

        if (v13 < v10) {
            v2 = new byte[v0];
            System.arraycopy(v14, 0, v2, 0, v0);
            return v2;
        }

        return v14;
    }

    protected void _F(byte[] arg6, int arg7, PRF arg8, byte[] arg9, int arg10, int arg11) {
        int v0 = arg8.getHLen();
        byte[] v1 = new byte[v0];
        byte[] v2 = new byte[arg9.length + 4];
        System.arraycopy(arg9, 0, v2, 0, arg9.length);
        this.INT(v2, arg9.length, arg11);
        int v9;
        for (v9 = 0; v9 < arg10; ++v9) {
            v2 = arg8.doFinal(v2);
            this.xor(v1, v2);
        }

        System.arraycopy(v1, 0, arg6, arg7, v0);
    }

    protected void assertPRF(byte[] arg3) {
        if (this.prf == null) {
            this.prf = new MacBasedPRF(this.parameters.getHashAlgorithm());
        }

        this.prf.init(arg3);
    }

    protected int ceil(int arg2, int arg3) {
        int v0 = arg2 % arg3 > 0 ? 1 : 0;
        return arg2 / arg3 + v0;
    }

    public byte[] deriveKey(String arg2) {
        return this.deriveKey(arg2, 0);
    }

    public byte[] deriveKey(String arg3, int arg4) {
        byte[] v3_1 = null;
        String v0 = this.parameters.getHashCharset();
        if (arg3 == null) {
            arg3 = "";
        }

        if (v0 == null) {
            v3_1 = arg3.getBytes();
        } else {
            try {
                v3_1 = arg3.getBytes(v0);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        this.assertPRF(v3_1);
        if (arg4 == 0) {
            arg4 = this.prf.getHLen();
        }

        return this.PBKDF2(this.prf, this.parameters.getSalt(), this.parameters.getIterationCount(), arg4);
    }

    public PBKDF2Parameters getParameters() {
        return this.parameters;
    }

    public PRF getPseudoRandomFunction() {
        return this.prf;
    }

    public void setParameters(PBKDF2Parameters arg1) {
        this.parameters = arg1;
    }

    public void setPseudoRandomFunction(PRF arg1) {
        this.prf = arg1;
    }

    public boolean verifyKey(String arg6) {
        byte[] v0 = this.getParameters().getDerivedKey();
        if (v0 != null) {
            if (v0.length == 0) {
            } else {
                byte[] v6 = this.deriveKey(arg6, v0.length);
                if (v6 != null) {
                    if (v6.length != v0.length) {
                    } else {
                        int v2 = 0;
                        while (true) {
                            if (v2 >= v6.length) {
                                return true;
                            } else if (v6[v2] != v0[v2]) {
                                return false;
                            } else {
                                ++v2;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    protected void xor(byte[] arg4, byte[] arg5) {
        int v0;
        for (v0 = 0; v0 < arg4.length; ++v0) {
            arg4[v0] = ((byte) (arg4[v0] ^ arg5[v0]));
        }
    }
}
