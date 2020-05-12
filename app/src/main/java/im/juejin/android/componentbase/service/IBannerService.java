package im.juejin.android.componentbase.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

import im.juejin.android.componentbase.model.BannerBean;

public interface IBannerService extends IProvider {
    void toDetailPage(Context arg1, BannerBean arg2, String arg3);
}
