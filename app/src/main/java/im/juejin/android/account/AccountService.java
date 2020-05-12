package im.juejin.android.account;


import android.content.Context;

import im.juejin.android.componentbase.service.IAccountService;

public class AccountService implements IAccountService {

    public void init(Context arg1) {
    }

    public boolean unbindThirdPart(String arg3) throws Exception {
        boolean v0 = AccountNetClient.INSTANCE.unbindThirdPart(arg3);
        if (v0) {
            AccountAction.INSTANCE.removeThirdPart(arg3);
        }

        return v0;
    }
}
