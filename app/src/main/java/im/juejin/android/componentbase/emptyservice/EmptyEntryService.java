package im.juejin.android.componentbase.emptyservice;

import android.content.Context;

import androidx.annotation.NonNull;

import im.juejin.android.componentbase.model.BeanType;
import im.juejin.android.componentbase.service.IEntryService;

public class EmptyEntryService implements IEntryService {
    public EmptyEntryService() {
        super();
    }

    public void goToDetail(@NonNull Context arg1, String arg2, String arg3, String arg4, String arg5, Integer arg6) {
    }

    public boolean isVote(String arg1) {
        return false;
    }

    public void likeEntry(String arg1, boolean arg2) {
    }

    public void postAdInfo() {
    }

    public void shareEntry(Context arg1, BeanType arg2, OnShareListener arg3) {
    }

    public void shareEntry(Context arg1, BeanType arg2, boolean arg3, OnShareListener arg4) {
    }
}