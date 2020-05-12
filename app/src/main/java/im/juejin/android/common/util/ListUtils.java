package im.juejin.android.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static String concat(List arg3, String arg4) {
        if (ListUtils.isNullOrEmpty(arg3)) {
            return "";
        }

        StringBuilder v0 = new StringBuilder();
        int v1;
        for (v1 = 0; v1 < arg3.size(); ++v1) {
            if (v1 != 0) {
                v0.append(arg4);
            }

            v0.append(arg3.get(v1));
        }

        return v0.toString();
    }

    public static ArrayList getSingleArrayList(Object arg1) {
        return new ArrayList(Collections.singletonList(arg1));
    }

    public static List getSubList(List arg1, int arg2) {
        if (arg1 != null) {
            if (arg1.size() <= arg2) {
            } else {
                arg1 = arg1.subList(0, arg2);
            }
        }

        return arg1;
    }

    public static boolean isNullOrEmpty(List arg0) {
        boolean v0 = arg0 == null || arg0.size() <= 0;
        return v0;
    }

    public static boolean notNull(List arg0) {
        boolean v0 = arg0 != null && arg0.size() > 0;
        return v0;
    }
}
