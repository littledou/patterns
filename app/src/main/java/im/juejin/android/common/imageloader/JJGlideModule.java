package im.juejin.android.common.imageloader;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import kotlin.jvm.internal.Intrinsics;

@GlideModule
public class JJGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context arg2, GlideBuilder arg3) {
        Intrinsics.checkParameterIsNotNull(arg2, "context");
        Intrinsics.checkParameterIsNotNull(arg3, "builder");
        arg3.setDefaultRequestOptions(RequestOptions.formatOf(DecodeFormat.PREFER_RGB_565));
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
