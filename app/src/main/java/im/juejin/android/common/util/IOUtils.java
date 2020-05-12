package im.juejin.android.common.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

    public static void close(Closeable arg2) {
        if (arg2 != null) {
            try {
                arg2.close();
            } catch (IOException v2) {
                throw new RuntimeException("IOException occurred. ", ((Throwable) v2));
            }
        }
    }

    public static void closeQuietly(Closeable arg0) {
        if (arg0 != null) {
            try {
                arg0.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
