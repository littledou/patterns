package im.juejin.android.common.imageloader;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;

import java.io.InputStream;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@GlideModule
public final class JJLibraryGlideModule extends LibraryGlideModule {

    @Override
    public void registerComponents(Context arg3, Glide arg4, Registry arg5) {
        Intrinsics.checkParameterIsNotNull(arg3, "context");
        Intrinsics.checkParameterIsNotNull(arg4, "glide");
        Intrinsics.checkParameterIsNotNull(arg5, "registry");
        arg4.getRegistry().append(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient.Builder().build()));
    }
}

