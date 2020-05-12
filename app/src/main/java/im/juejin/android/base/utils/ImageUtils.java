package im.juejin.android.base.utils;


import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import im.juejin.android.common.ApplicationProvider;
import im.juejin.android.common.extensions.ImageLoaderExKt;
import im.juejin.android.common.util.ScreenUtil;
import im.juejin.android.componentbase.ServiceFactory;

public class ImageUtils {
    private static final String JPG_SUFFIX_FOR_SINGLE_IMG_PNG = "?imageView2/0/w/%s/h/%s/format/png";
    private static final String JPG_SUFFIX_FOR_SINGLE_IMG_WEBP = "?imageView2/0/w/%s/h/%s/format/webp";
    private static final String JPG_SUFFIX_FOR_SQUARE_IMG_PNG = "?imageView2/1/w/%s/h/%s/format/png";
    private static final String JPG_SUFFIX_FOR_SQUARE_IMG_WEBP = "?imageView2/1/w/%s/h/%s/format/webp";
    private static final int MAX_IMG_WIDTH = 400;
    private static final int MIN_IMG_WIDTH = 0xF0;
    public static final HashMap mFileTypes = new HashMap();

    static {
        ImageUtils.mFileTypes.put("FFD8FFE1", "jpg");
        ImageUtils.mFileTypes.put("FFD8FFE0", "jpg");
        ImageUtils.mFileTypes.put("FFD8", "jpg");
        ImageUtils.mFileTypes.put("89504E47", "png");
        ImageUtils.mFileTypes.put("47494638", "gif");
        ImageUtils.mFileTypes.put("49492A00", "tif");
        ImageUtils.mFileTypes.put("424D", "bmp");
        ImageUtils.mFileTypes.put("41433130", "dwg");
        ImageUtils.mFileTypes.put("38425053", "psd");
        ImageUtils.mFileTypes.put("7B5C727466", "rtf");
        ImageUtils.mFileTypes.put("3C3F786D6C", "xml");
        ImageUtils.mFileTypes.put("68746D6C3E", "html");
        ImageUtils.mFileTypes.put("44656C69766572792D646174653A", "eml");
        ImageUtils.mFileTypes.put("D0CF11E0", "doc");
        ImageUtils.mFileTypes.put("5374616E64617264204A", "mdb");
        ImageUtils.mFileTypes.put("252150532D41646F6265", "ps");
        ImageUtils.mFileTypes.put("255044462D312E", "pdf");
        ImageUtils.mFileTypes.put("504B0304", "docx");
        ImageUtils.mFileTypes.put("52617221", "rar");
        ImageUtils.mFileTypes.put("57415645", "wav");
        ImageUtils.mFileTypes.put("41564920", "avi");
        ImageUtils.mFileTypes.put("2E524D46", "rm");
        ImageUtils.mFileTypes.put("000001BA", "mpg");
        ImageUtils.mFileTypes.put("000001B3", "mpg");
        ImageUtils.mFileTypes.put("6D6F6F76", "mov");
        ImageUtils.mFileTypes.put("3026B2758E66CF11", "asf");
        ImageUtils.mFileTypes.put("4D546864", "mid");
        ImageUtils.mFileTypes.put("1F8B08", "gz");
        ImageUtils.mFileTypes.put("4D5A9000", "exe/dll");
        ImageUtils.mFileTypes.put("75736167", "txt");
    }

    public ImageUtils() {
        super();
    }

    public static String addMetaToUrl(String arg5, int arg6, int arg7) {
        Object[] v4_1;
        Locale v0;
        int v1 = 2;
        int v4 = 3;
        if (arg5.contains("?")) {
            v0 = Locale.getDefault();
            v4_1 = new Object[v4];
            v4_1[0] = arg5;
            v4_1[1] = Integer.valueOf(arg6);
            v4_1[v1] = Integer.valueOf(arg7);
            return String.format(v0, "%s&w=%d&h=%d", v4_1);
        }

        v0 = Locale.getDefault();
        v4_1 = new Object[v4];
        v4_1[0] = arg5;
        v4_1[1] = Integer.valueOf(arg6);
        v4_1[v1] = Integer.valueOf(arg7);
        return String.format(v0, "%s?w=%d&h=%d", v4_1);
    }

    private static String bytesToHexString(byte[] arg6) {
        StringBuilder v0 = new StringBuilder();
        if (arg6 != null) {
            if (arg6.length <= 0) {
            } else {
                int v2;
                for (v2 = 0; v2 < arg6.length; ++v2) {
                    String v3 = Integer.toHexString(arg6[v2] & 0xFF).toUpperCase();
                    if (v3.length() < 2) {
                        v0.append(0);
                    }

                    v0.append(v3);
                }

                return v0.toString();
            }
        }

        return null;
    }

    private static int[] changeImageWidth(int[] arg3) {
        int v2 = 0xF0;
        if (arg3[0] < v2) {
        } else {
            v2 = arg3[0];
        }

        arg3[0] = v2;
        return arg3;
    }

    public static String getFileHeader(String arg4) {
        String v0_1;
        int v4_1;
        FileInputStream v1;
        FileInputStream v0 = null;
        try {
            v1 = new FileInputStream(arg4);
            v4_1 = 4;
        } catch (Throwable v4) {
            v1 = v0;
            goto label_16;
        } catch (Exception) {
            v1 = v0;
            goto label_20;
        }

        try {
            byte[] v4_2 = new byte[v4_1];
            v1.read(v4_2, 0, v4_2.length);
            v0_1 = ImageUtils.bytesToHexString(v4_2);
            goto label_9;
        } catch (Throwable v4) {
        } catch (Exception) {
            label_20:
            if (v1 == null) {
                return v0_1;
            }

            try {
                label_9:
                v1.close();
            } catch (IOException) {
            }

            return v0_1;
        }

        label_16:
        if (v1 != null) {
            try {
                v1.close();
                goto label_18;
            } catch (IOException e) {
                label_18:
                throw v4;
            }
        }

        goto label_18;
        return v0_1;
    }

    public static String getFileType(String arg1) {
        arg1 = ImageUtils.getFileHeader(arg1);
        if (!TextUtil.isEmpty(arg1)) {
            if (arg1.startsWith("FFD8")) {
            } else {
                return ImageUtils.mFileTypes.get(arg1);
            }
        }

        return "jpg";
    }

    public static String getGifThumbnailUrlLimitSize(String arg2, int arg3) {
        if (TextUtil.isEmpty(arg2)) {
            return "";
        }

        if (arg2.startsWith("http")) {
            if (arg2.contains("imageView2/")) {
            } else {
                StringBuilder v0 = new StringBuilder(arg2);
                arg2 = arg2.contains("?") ? "&imageView2/0" : "?imageView2/0";
                v0.append(arg2);
                if (arg3 > 0) {
                    v0.append("/w/");
                    v0.append(arg3);
                }

                arg2 = v0.toString();
            }
        }

        return arg2;
    }

    public static File getImageFile(String arg1) {
        if (!arg1.startsWith("/")) {
            arg1 = ImageUtils.getImagePath(Uri.parse(arg1));
        }

        return new File(arg1);
    }

    public static String getImagePath(Uri arg7) {
        String v0 = "_data";
        Cursor v7 = ApplicationProvider.getApplication().getContentResolver().query(arg7, new String[]{v0}, null, null, null);
        if (v7 == null) {
            return "";
        }

        int v0_1 = v7.getColumnIndexOrThrow(v0);
        v7.moveToFirst();
        v0 = v7.getString(v0_1);
        v7.close();
        return v0;
    }

    public static Uri getImageUri(Context arg4, Bitmap arg5) {
        String v0 = null;
        try {
            arg5.compress(Bitmap$CompressFormat.JPEG, 100, new ByteArrayOutputStream());
            return Uri.parse(MediaStore$Images$Media.insertImage(arg4.getContentResolver(), arg5, "GoldShareImage", v0));
        } catch (Exception v4) {
            v4.printStackTrace();
            return ((Uri) v0);
        }
    }

    public static String getMetaOfUrl(String arg4, int[] arg5) {
        try {
            Uri v0 = Uri.parse(arg4);
            arg5[0] = Integer.parseInt(v0.getQueryParameter("w"));
            arg5[1] = Integer.parseInt(v0.getQueryParameter("h"));
            int v5 = arg4.indexOf("?");
            if (v5 == -1) {
                v5 = arg4.length();
            }

            return arg4.substring(0, v5);
        } catch (Exception) {
            return arg4;
        }
    }

    public static String getPureUrl(String arg3) {
        if (TextUtil.isEmpty(arg3)) {
            return "";
        }

        int v0 = arg3.indexOf("?");
        if (v0 == -1) {
            v0 = arg3.length();
        }

        return arg3.substring(0, v0);
    }

    public static String getQiNiuImgThumbUrl(String arg1) {
        return ImageUtils.getQiNiuImgThumbUrl(arg1, 450);
    }

    public static String getQiNiuImgThumbUrl(String arg1, int arg2) {
        if (ImageUtils.isQiniuUrl(arg1)) {
            if (arg1.contains("?")) {
                arg1 = ImageUtils.getPureUrl(arg1);
            }

            arg1 = arg1 + "?imageView2/0/h/" + arg2 + "/q/80";
        }

        return arg1;
    }

    public static String getQiniuThumbUrl(String arg1) {
        if (!TextUtil.isEmpty(arg1)) {
            if (!ImageUtils.isQiniuUrl(arg1)) {
            } else {
                arg1 = ImageUtils.getThumbnailUrl(ImageUtils.getPureUrl(arg1));
            }
        }

        return arg1;
    }

    private static int[] getSourceWidthHeightFromUrl(String arg0) {
        return ImageUtils.getSourceWidthHeightFromUrl(ImageUtils.getWidthHeightFromUrl(arg0));
    }

    private static int[] getSourceWidthHeightFromUrl(int[] arg6) {
        int v1 = arg6[0];
        int v3 = arg6[1];
        int v4 = 400;
        if (v3 > v4 || v1 > v4) {
            float v5 = 400f;
            if (v1 > v3) {
                v3 = ((int) ((((float) v3)) / (((float) v1)) * v5));
                v1 = 400;
            } else {
                v1 = ((int) ((((float) v1)) / (((float) v3)) * v5));
                v3 = 400;
            }
        }

        arg6[0] = v1;
        arg6[1] = v3;
        return arg6;
    }

    public static String getThumbnailAvatarUrl(String arg7) {
        return ImageUtils.getThumbnailUrl(arg7, true, ScreenUtil.dip2px(40f), ScreenUtil.dip2px(40f), 80, "webp");
    }

    public static String getThumbnailUrl(String arg5, boolean arg6, int arg7, int arg8, int arg9, String arg10) {
        if (TextUtil.isEmpty(arg5)) {
            return "";
        }

        if (!ImageUtils.isQiniuUrl(arg5)) {
            return arg5;
        }

        if (arg7 >= 0 && arg8 >= 0) {
            if (arg9 >= 1 && arg9 <= 100) {
                if (TextUtil.isEmpty(arg10)) {
                    arg10 = "png";
                }

                int v1 = 2;
                int v6 = arg6 ? 2 : 1;
                StringBuilder v2 = new StringBuilder();
                v2.append(ImageUtils.getPureUrl(arg5));
                Locale v5 = Locale.getDefault();
                Object[] v3 = new Object[5];
                v3[0] = Integer.valueOf(v6);
                v3[1] = Integer.valueOf(arg7);
                v3[v1] = Integer.valueOf(arg8);
                v3[3] = Integer.valueOf(arg9);
                v3[4] = arg10;
                v2.append(String.format(v5, "?imageView/%d/w/%d/h/%d/q/%d/format/%s/ignore-error/1", v3));
                return v2.toString();
            }

            throw new IllegalArgumentException("Invalid quality,valid range is 0-100.");
        }

        throw new IllegalArgumentException("Invalid width or height.");
    }

    public static String getThumbnailUrl(String arg7) {
        return ImageUtils.getThumbnailUrl(arg7, true, ScreenUtil.dip2px(80f), ScreenUtil.dip2px(80f), 80, "webp");
    }

    public static String getThumbnailUrl(String arg6, int arg7, int arg8) {
        return ImageUtils.getThumbnailUrl(arg6, true, arg7, arg8, 80, "webp");
    }

    public static String getThumbnailUrlLimitLongEdge(String arg2, int arg3) {
        if (TextUtil.isEmpty(arg2)) {
            return "";
        }

        if (arg2.startsWith("http")) {
            if (arg2.contains("imageView2/")) {
            } else {
                StringBuilder v0 = new StringBuilder(arg2);
                arg2 = arg2.contains("?") ? "&imageView2/0" : "?imageView2/0";
                v0.append(arg2);
                if (arg3 > 0) {
                    v0.append("/w/");
                    v0.append(arg3);
                }

                v0.append("/format/webp/ignore-error/1");
                arg2 = v0.toString();
            }
        }

        return arg2;
    }

    public static String getThumbnailUrlLimitSize(String arg2, int arg3) {
        if (TextUtil.isEmpty(arg2)) {
            return "";
        }

        if (arg2.startsWith("http")) {
            if (arg2.contains("imageView2/")) {
            } else {
                StringBuilder v0 = new StringBuilder(arg2);
                arg2 = arg2.contains("?") ? "&imageView2/0" : "?imageView2/0";
                v0.append(arg2);
                if (arg3 > 0) {
                    v0.append("/h/");
                    v0.append(arg3);
                }

                v0.append("/format/webp/ignore-error/1");
                arg2 = v0.toString();
            }
        }

        return arg2;
    }

    public static Drawable getTintedDrawable(Resources arg0, @DrawableRes int arg1, @ColorRes int arg2) {
        Drawable v1 = arg0.getDrawable(arg1);
        int v0 = arg0.getColor(arg2);
        if (v1 != null) {
            v1.setColorFilter(v0, PorterDuff$Mode.SRC_IN);
        }

        return v1;
    }

    public static int[] getWidthHeightFromFile(File arg5) {
        int v0 = 2;
        try {
            int[] v1 = new int[v0];
            BitmapFactory$Options v2 = new BitmapFactory$Options();
            v2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(arg5.getAbsolutePath(), v2);
            v1[0] = v2.outWidth;
            v1[1] = v2.outHeight;
            return v1;
        } catch (Exception) {
            return new int[v0];
        }
    }

    public static int[] getWidthHeightFromUrl(String arg3) {
        int[] v0 = new int[2];
        try {
            Uri v3 = Uri.parse(arg3);
            v0[0] = Integer.parseInt(v3.getQueryParameter("w"));
            v0[1] = Integer.parseInt(v3.getQueryParameter("h"));
            return v0;
        } catch (Exception) {
            return v0;
        }
    }

    public static boolean isGif(String arg1) {
        try {
            return "gif".equals(Uri.parse(arg1).getQueryParameter("f"));
        } catch (Exception) {
            return 0;
        }
    }

    public static boolean isLargeLongImg(String arg2) {
        boolean v0 = true;
        if (ImageUtils.getWidthHeightFromUrl(arg2)[1] > 5000) {
        } else {
            v0 = false;
        }

        return v0;
    }

    public static boolean isLocalFile(String arg1) {
        if (TextUtil.isEmpty(arg1)) {
            return 0;
        }

        return arg1.startsWith("file://");
    }

    public static boolean isLongImg(String arg4) {
        int[] v4 = ImageUtils.getWidthHeightFromUrl(arg4);
        boolean v0 = true;
        int v1 = v4[1];
        float v2 = (((float) v4[1])) / (((float) v4[0]));
        if (v1 <= 1200 || v2 <= ServiceFactory.getInstance().getHullService().getScreenRatio()) {
            v0 = false;
        } else {
        }

        return v0;
    }

    public static boolean isQiniuUrl(String arg1) {
        boolean v1 = (arg1.contains("-cdn.xitu.io")) || (arg1.contains(".qbox.me")) ? true : false;
        return v1;
    }

    public static boolean isUri(String arg1) {
        if (TextUtil.isEmpty(arg1)) {
            return 0;
        }

        return arg1.startsWith("content://");
    }

    public static void loadSingleThumbImg(ImageView arg7, String arg8, boolean arg9) {
        if (arg7 == null) {
            return;
        }

        if (TextUtil.isEmpty(arg8)) {
            arg7.setImageResource(drawable.ic_loading);
            return;
        }

        String v0 = ImageUtils.getPureUrl(arg8);
        int[] v1 = ImageUtils.getSourceWidthHeightFromUrl(arg8);
        boolean v2 = ImageUtils.isLongImg(arg8);
        if (v2) {
            ImageUtils.changeImageWidth(v1);
        }

        int v5 = arg9 ? v1[1] : v1[0];
        boolean v8 = ImageUtils.isGif(arg8);
        if (!arg9 || (v2)) {
            arg8 = v8 ? "?imageView2/1/w/%s/h/%s/format/png" : "?imageView2/1/w/%s/h/%s/format/webp";
        } else if (v8) {
            arg8 = "?imageView2/0/w/%s/h/%s/format/png";
        } else {
            arg8 = "?imageView2/0/w/%s/h/%s/format/webp";
        }

        ImageLoaderExKt.load(arg7, v0 + String.format(Locale.getDefault(), arg8, Integer.valueOf(v1[0] * 2), Integer.valueOf(v5 * 2)), 0, true, drawable.ic_loading);
    }
}