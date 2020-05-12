package im.juejin.android.common.imageloader;

public interface LoadFileListener {
    boolean onLoadFailed();

    boolean onResourceReady();
}

