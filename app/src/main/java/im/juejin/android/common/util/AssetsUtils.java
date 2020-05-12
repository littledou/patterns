package im.juejin.android.common.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class AssetsUtils {
    private static final String ENCODING = "utf-8";


    public static String convertStreamToString(InputStream arg5) throws IOException {
        StringWriter v0 = new StringWriter();
        char[] v1 = new char[0x800];
        try {
            BufferedReader v2 = new BufferedReader(new InputStreamReader(arg5, "utf-8"));
            while (true) {
                int v3 = ((Reader) v2).read(v1);
                if (v3 == -1) {
                    break;
                }

                ((Writer) v0).write(v1, 0, v3);
            }
        } catch (Throwable v0_1) {
            arg5.close();
            throw v0_1;
        }

        arg5.close();
        return v0.toString();

    }

    public static String loadText(Context arg0, String arg1) {
        try {
            return AssetsUtils.convertStreamToString(arg0.getResources().getAssets().open(arg1));
        } catch (IOException v0) {
            v0.printStackTrace();
            return null;
        }
    }
}
