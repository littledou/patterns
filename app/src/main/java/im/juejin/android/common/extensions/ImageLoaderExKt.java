package im.juejin.android.common.extensions;

public class ImageLoaderExKt {
//    public static final void load(ImageView arg9, Uri arg10) {
//        ImageLoaderExKt.load$default(arg9, arg10, 0, false, 0, 0, false, 62, null);
//    }
//
//    public static final void load(ImageView arg9, Uri arg10, int arg11) {
//        ImageLoaderExKt.load$default(arg9, arg10, arg11, false, 0, 0, false, 60, null);
//    }
//
//    public static final void load(ImageView arg9, Uri arg10, int arg11, boolean arg12) {
//        ImageLoaderExKt.load$default(arg9, arg10, arg11, arg12, 0, 0, false, 56, null);
//    }
//
//    public static final void load(ImageView arg9, Uri arg10, int arg11, boolean arg12, @DrawableRes int arg13) {
//        ImageLoaderExKt.load$default(arg9, arg10, arg11, arg12, arg13, 0, false, 0x30, null);
//    }
//
//    public static final void load(ImageView arg9, Uri arg10, int arg11, boolean arg12, @DrawableRes int arg13, @DrawableRes int arg14) {
//        ImageLoaderExKt.load$default(arg9, arg10, arg11, arg12, arg13, arg14, false, 0x20, null);
//    }
//
//    public static final void load(ImageView imageview, Uri uri, int radio, boolean needTransition, @DrawableRes int res1, @DrawableRes int res2, boolean needCircle) {
//        Intrinsics.checkParameterIsNotNull(imageview, "receiver$0");
//        if((imageview.getContext() instanceof Activity)) {
//            Context v0 = imageview.getContext();
//            if(v0 == null) {
//                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
//            }
//            else if(((Activity)v0).isFinishing()) {
//                return;
//            }
//        }
//
//        int v0_1 = -1;
//        if(uri == null) {
//            if(res2 != v0_1) {
//                imageview.setImageResource(res2);
//                return;
//            }
//            else if(res1 != v0_1) {
//                imageview.setImageResource(res1);
//                return;
//            }
//            else {
//                imageview.setImageResource(R.drawable.common_loading);
//            }
//        }
//
//        GlideRequest v7 = GlideApp.with(imageview.getContext()).load(uri).disallowHardwareConfig();
//        Intrinsics.a(v7, "GlideApp.with(context).l….disallowHardwareConfig()");
//        GradientDrawable v1 = new GradientDrawable();
//        v1.setColor(((int)0xFFF1F1F1L));
//        if(radio > 0) {
//            v1.setCornerRadius(((float)radio));
//            v7.transforms(new Transformation[]{new CenterCrop(), new RoundedCorners(radio)});
//        }
//
//        if(needCircle) {
//            v7.circleCrop();
//        }
//
//        if(needTransition) {
//            v7.transition(DrawableTransitionOptions.a(new Builder().a(true)));
//        }
//
//        if(res1 != v0_1 && res2 != v0_1) {
//            v7.placeholder(res1).error(((Drawable)v1));
//        }
//        else if(res2 != v0_1) {
//            v7.placeholder(res2).error(res2);
//        }
//        else if(res1 != v0_1) {
//            v7.placeholder(res1);
//        }
//        else {
//            v7.placeholder(((Drawable)v1));
//        }
//
//        v7.into(imageview);
//    }
}
