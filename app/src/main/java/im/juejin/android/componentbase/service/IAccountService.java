package im.juejin.android.componentbase.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IAccountService extends IProvider {
    boolean unbindThirdPart(String arg1) throws Exception;
}
