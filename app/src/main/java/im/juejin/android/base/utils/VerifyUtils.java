package im.juejin.android.base.utils;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.daimajia.gold.R;

import java.util.UUID;
import java.util.regex.Pattern;

public class VerifyUtils {
    private static String clientId;

    private static String localSUID;

    private static String localToken = SpUtils.<String>get("token", "");

    static {
        clientId = SpUtils.<String>getDevice("client_id", "");
        localSUID = SpUtils.<String>getDevice("suid", "");
    }

    public static String getClientId() {
        if (!TextUtil.isEmpty(clientId))
            return clientId;
        clientId = SpUtils.<String>getDevice("client_id", "");
        if (TextUtil.isEmpty(clientId)) {
            clientId = UUID.randomUUID().toString();
            SpUtils.saveDevice("client_id", clientId);
        }
        return clientId;
    }

    public static String getLocalSuid() {
        return !TextUtil.isEmpty(localSUID) ? localSUID : SpUtils.<String>getDevice("suid", "");
    }

    public static String getLocalToken() {
        if (TextUtil.isEmpty(localToken)) {
            String str = SpUtils.<String>get("token", "");
            localToken = str;
            return str;
        }
        return localToken;
    }

    public static boolean isPhoneNumber(String paramString) {
        return Pattern.matches("^[\\d]{11}$", paramString);
    }

    public static boolean isValidEmailAddress(String paramString) {
        return (paramString == null || "".equals(paramString)) ? false : Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(paramString).matches();
    }

    public static void saveLocalSui(String paramString) {
        localSUID = "";
        SpUtils.saveDevice("suid", paramString);
    }

    public static void saveLocalToken(String paramString) {
        localToken = "";
        SpUtils.save("token", paramString);
    }

    public static void startCountDownTimer(final TextView tvText, int paramInt1, final int finishTextRes) {
        (new CountDownTimer(paramInt1, 1000L) {
            public void onFinish() {
                TextView textView = tvText;
                if (textView == null)
                    return;
                textView.setText(finishTextRes);
                tvText.setClickable(true);
                textView = tvText;
                textView.setTextColor(textView.getResources().getColor(R.color.juejin_blue));
            }

            @SuppressLint({"SetTextI18n"})
            public void onTick(long param1Long) {
                TextView textView = tvText;
                if (textView == null)
                    return;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Long / 1000L);
                stringBuilder.append("s 后重发");
                textView.setText(stringBuilder.toString());
                tvText.setClickable(false);
                textView = tvText;
                textView.setTextColor(textView.getResources().getColor(R.color.gray_text));
            }
        }).start();
    }
}
