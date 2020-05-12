package im.juejin.android.componentbase.emptyservice;


import androidx.fragment.app.Fragment;

import im.juejin.android.componentbase.EmptyFragment;
import im.juejin.android.componentbase.service.IXiaoceService;

public class EmptyXiaoceService implements IXiaoceService {
    public EmptyXiaoceService() {
        super();
    }

    public Fragment getUserXiaoceListFragment() {
        return EmptyFragment.newInstance("用户已购列表");
    }

    public Fragment getXiaoceListFragment() {
        return EmptyFragment.newInstance("小册列表");
    }

    public Fragment getXiaocePagerFragment() {
        return EmptyFragment.newInstance("小册");
    }
}