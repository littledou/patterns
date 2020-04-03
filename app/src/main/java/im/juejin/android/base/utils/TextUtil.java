package im.juejin.android.base.utils;

import android.text.TextUtils;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TextUtil {
    public static String StringSplit(String paramString, int paramInt) {
        if (paramString == null)
            return null;
        if (paramString.length() <= paramInt)
            return paramString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString.substring(0, paramInt));
        stringBuilder.append("...");
        return stringBuilder.toString();
    }

    public static boolean checkEmail(String paramString) {
        return (paramString == null) ? false : Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?").matcher(paramString).find();
    }

    public static String getText(TextView paramTextView) {
        return (paramTextView != null) ? paramTextView.getText().toString() : "";
    }

    public static boolean isEmpty(TextView paramTextView) {
        return (paramTextView != null && paramTextView.getText() != null && paramTextView.getText().toString().trim().length() == 0);
    }

    public static boolean isEmpty(String paramString) {
        return (paramString == null || paramString.length() == 0);
    }

    public static void setText(TextView paramTextView, String paramString) {
        if (paramTextView != null) {
            if (TextUtils.isEmpty(paramString))
                return;
            paramTextView.setText(paramString);
        }
    }

    public static String stringFilter(String paramString) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9\\u4e00-\\u9fa5_]").matcher(paramString).replaceAll("").trim();
    }

    public static boolean usernameFilter(String paramString) {
        boolean bool2 = false;
        if (paramString == null)
            return false;
        Matcher matcher = Pattern.compile("^[a-zA-Z0-9_\\u4e00-\\u9fa5]+$").matcher(paramString);
        boolean bool1 = bool2;
        if (paramString.length() <= 20) {
            bool1 = bool2;
            if (matcher.find())
                bool1 = true;
        }
        return bool1;
    }
}
