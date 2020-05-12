package im.juejin.android.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String encrypt(String arg5) {
        String v0 = "";
        if (arg5 == null) {
            arg5 = v0;
        }

        try {
            MessageDigest v1 = MessageDigest.getInstance("MD5");
            v1.update(arg5.getBytes());
            byte[] v5 = v1.digest();
            StringBuffer v1_1 = new StringBuffer(v0);
            int v2;
            for (v2 = 0; v2 < v5.length; ++v2) {
                int v3 = v5[v2];
                if (v3 < 0) {
                    v3 += 0x100;
                }

                if (v3 < 16) {
                    v1_1.append("0");
                }

                v1_1.append(Integer.toHexString(v3));
            }

            return v1_1.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
