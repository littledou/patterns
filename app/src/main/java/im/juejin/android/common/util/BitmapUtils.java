package im.juejin.android.common.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class BitmapUtils {
    private static final Bitmap.Config CONFIG = Bitmap.Config.RGB_565;

    public BitmapUtils() {
        super();
    }

    public static byte[] bitmap2BtyeArray(Bitmap arg3) {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        arg3.compress(Bitmap.CompressFormat.PNG, 80, ((OutputStream) v0));
        return v0.toByteArray();
    }

    public static int calculateInSampleSize(BitmapFactory.Options arg3, int arg4, int arg5) {
        int v0 = arg3.outHeight;
        int v3 = arg3.outWidth;
        int v1 = 1;
        if (v0 > arg5 || v3 > arg4) {
            v0 /= 2;
            v3 /= 2;
            while (v0 / v1 > arg5) {
                if (v3 / v1 <= arg4) {
                    return v1;
                }

                v1 *= 2;
            }
        }

        return v1;
    }

    public static void compressImage(String arg2, int arg3, int arg4, String arg5) {
        BitmapFactory.Options v0 = new BitmapFactory.Options();
        v0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(arg2, v0);
        v0.inJustDecodeBounds = false;
        v0.inSampleSize = BitmapUtils.calculateInSampleSize(v0, arg3, arg4);
        BitmapUtils.saveBitmap2file(BitmapFactory.decodeFile(arg2, v0), arg5);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources arg2, int arg3, int arg4, int arg5) {
        BitmapFactory.Options v0 = new BitmapFactory.Options();
        v0.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(arg2, arg3, v0);
        v0.inSampleSize = BitmapUtils.calculateInSampleSize(v0, arg4, arg5);
        v0.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(arg2, arg3, v0);
    }

    public static Bitmap getBitmapFromUrl(String arg1) {
        Bitmap v1_1;
        try {
            if (!TextUtils.isEmpty(((CharSequence) arg1)) && (arg1.startsWith("http"))) {
                v1_1 = BitmapFactory.decodeStream(new URL(arg1).openStream());
                return v1_1;
            }

            v1_1 = BitmapFactory.decodeFile(arg1);
        } catch (Throwable v1) {
            v1.printStackTrace();
            v1_1 = null;
        }

        return v1_1;
    }

    public static Bitmap getCroppedBitmap(Bitmap arg7) {
        Bitmap v0 = Bitmap.createBitmap(arg7.getWidth(), arg7.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas v1 = new Canvas(v0);
        Paint v2 = new Paint();
        Rect v3 = new Rect(0, 0, arg7.getWidth(), arg7.getHeight());
        v2.setAntiAlias(true);
        v1.drawARGB(0, 0, 0, 0);
        v2.setColor(0xFF424242);
        v1.drawCircle(((float) (arg7.getWidth() / 2)), ((float) (arg7.getHeight() / 2)), ((float) (arg7.getWidth() / 2)), v2);
        v2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        v1.drawBitmap(arg7, v3, v3, v2);
        return v0;
    }

    public static byte[] getWechatCompressImage(Bitmap arg4) {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        int v2 = 100;
        arg4.compress(Bitmap.CompressFormat.JPEG, v2, ((OutputStream) v0));
        while (v0.toByteArray().length / 0x400 > 0x20) {
            v0.reset();
            v2 += -10;
            arg4.compress(Bitmap.CompressFormat.JPEG, v2, ((OutputStream) v0));
        }

        return v0.toByteArray();
    }

    public static boolean saveBitmap2file(Bitmap arg2, String arg3) {
        Bitmap.CompressFormat v0 = Bitmap.CompressFormat.JPEG;
        try {
            FileOutputStream v1 = new FileOutputStream(arg3);
            boolean v2_1 = arg2.compress(v0, 100, ((OutputStream) v1));
            ((OutputStream) v1).close();
            return v2_1;
        } catch (Exception v2) {
            v2.printStackTrace();
            return false;
        }
    }

    public static Bitmap scaleBitmap(Bitmap arg5, int arg6, int arg7) {
        int v0 = arg5.getWidth();
        int v1 = arg5.getHeight();
        StringBuilder v2 = new StringBuilder();
        v2.append("Width and height are ");
        v2.append(v0);
        String v3 = "--";
        v2.append(v3);
        v2.append(v1);
        String v4 = "Pictures";
        Log.v(v4, v2.toString());
        if (v0 > v1) {
            arg7 = ((int) ((((float) v1)) / ((((float) v0)) / (((float) arg6)))));
        } else if (v1 > v0) {
            arg6 = ((int) ((((float) v0)) / ((((float) v1)) / (((float) arg7)))));
        }

        Log.v(v4, "after scaling Width and height are " + arg6 + v3 + arg7);
        return Bitmap.createScaledBitmap(arg5, arg6, arg7, true);
    }

    public static Bitmap scaleCenterCrop(Bitmap arg6, int arg7, int arg8) {
        float v2 = ((float) arg8);
        float v0 = ((float) arg6.getWidth());
        float v4 = ((float) arg7);
        float v1 = ((float) arg6.getHeight());
        float v3 = Math.max(v2 / v0, v4 / v1);
        v0 *= v3;
        v3 *= v1;
        v2 = (v2 - v0) / 2f;
        v4 = (v4 - v3) / 2f;
        RectF v1_1 = new RectF(v2, v4, v0 + v2, v3 + v4);
        Bitmap v7 = Bitmap.createBitmap(arg8, arg7, BitmapUtils.CONFIG);
        Canvas v8 = new Canvas(v7);
        Paint v0_1 = new Paint();
        v0_1.setAntiAlias(true);
        v0_1.setFilterBitmap(true);
        v0_1.setDither(true);
        v8.drawBitmap(arg6, null, v1_1, v0_1);
        return v7;
    }
}
