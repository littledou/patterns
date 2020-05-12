package im.juejin.android.common.util;

import java.util.Random;

public class RandomCharUtil {
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerLetterChar = "abcdefghijklmnopqrstuvwxyz";
    public static final String numberChar = "0123456789";
    public static final String numberLowerLetterChar = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String numberUpperLetterChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String upperLetterChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public RandomCharUtil() {
        super();
    }

    public static String getRandomALLChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(v1.nextInt(62)));
        }

        return v0.toString();
    }

    public static String getRandomLetterChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(v1.nextInt(52)));
        }

        return v0.toString();
    }

    public static String getRandomLowerLetterChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("abcdefghijklmnopqrstuvwxyz".charAt(v1.nextInt(26)));
        }

        return v0.toString();
    }

    public static String getRandomNumberChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("0123456789".charAt(v1.nextInt(10)));
        }

        return v0.toString();
    }

    public static String getRandomNumberLowerLetterChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(v1.nextInt(36)));
        }

        return v0.toString();
    }

    public static String getRandomNumberUpperLetterChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(v1.nextInt(36)));
        }

        return v0.toString();
    }

    public static String getRandomUpperLetterChar(int arg5) {
        StringBuffer v0 = new StringBuffer();
        Random v1 = new Random();
        int v2;
        for (v2 = 0; v2 < arg5; ++v2) {
            v0.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(v1.nextInt(26)));
        }

        return v0.toString();
    }
}
