package cn.readsense.easynet;

import org.junit.Test;

public class NetV1UnitTest {

    @Test
    public void run() {
        String card = "10";

        final int anInt = Integer.parseInt(card);
        final String hexString = Integer.toHexString(anInt);

        char[] hexChar = {'0', '0', '0', '0'};
        for (int i = 0; i < hexString.length(); i++) {
            if (i <= 3)
                hexChar[hexChar.length - 1 - i] = hexString.charAt(hexString.length() - i - 1);
        }

        System.out.println("1a 00 " + hexChar[0] + hexChar[1] + " " + hexChar[2] + hexChar[3]);
    }


}
