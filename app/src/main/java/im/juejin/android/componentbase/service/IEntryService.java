package im.juejin.android.componentbase.service;

import android.content.Context;

import androidx.annotation.NonNull;

import im.juejin.android.componentbase.model.BeanType;

public interface IEntryService {
    public interface OnShareListener {
        void onDeleteClick();

        void showCollectionSet();
    }

    void goToDetail(@NonNull Context arg1, String arg2, String arg3, String arg4, String arg5, Integer arg6);

    boolean isVote(String arg1);

    void likeEntry(String arg1, boolean arg2);

    void postAdInfo();

    void shareEntry(Context arg1, BeanType arg2, OnShareListener arg3);

    void shareEntry(Context arg1, BeanType arg2, boolean arg3, OnShareListener arg4);
}
