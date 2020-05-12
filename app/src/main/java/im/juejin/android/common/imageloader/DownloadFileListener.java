package im.juejin.android.common.imageloader;

import android.graphics.drawable.Drawable;

import java.io.File;

public interface DownloadFileListener {
    void onLoadFailed(Drawable arg1);

    void onResourceReady(File arg1);
}
