package im.juejin.android.componentbase;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import im.juejin.android.componentbase.emptyservice.EmptyAnalyticsService;
import im.juejin.android.componentbase.emptyservice.EmptyCategoryService;
import im.juejin.android.componentbase.emptyservice.EmptyDebugService;
import im.juejin.android.componentbase.emptyservice.EmptyEntryService;
import im.juejin.android.componentbase.emptyservice.EmptyHullService;
import im.juejin.android.componentbase.emptyservice.EmptyPushService;
import im.juejin.android.componentbase.emptyservice.EmptyUserService;
import im.juejin.android.componentbase.emptyservice.EmptyXiaoceService;
import im.juejin.android.componentbase.service.IAnalyticsService;
import im.juejin.android.componentbase.service.ICategoryService;
import im.juejin.android.componentbase.service.IDebugService;
import im.juejin.android.componentbase.service.IEntryService;
import im.juejin.android.componentbase.service.IHullService;
import im.juejin.android.componentbase.service.INotificationService;
import im.juejin.android.componentbase.service.IPinService;
import im.juejin.android.componentbase.service.IPushService;
import im.juejin.android.componentbase.service.IUserService;
import im.juejin.android.componentbase.service.IXiaoceService;

public class ServiceFactory {
    class Out {
    }

    static class Inner {
        private static ServiceFactory serviceFactory = new ServiceFactory(null);


        private Inner() {
            super();
        }

        static ServiceFactory getFactory() {
            return Inner.serviceFactory;
        }
    }

    private IAnalyticsService analyticsService;
    private ICategoryService categoryService;
    private IDebugService debugService;
    private IEntryService entryService;
    private IHullService hullService;
    private INotificationService notificationService;
    private IPinService pinService;
    private IPushService pushService;
    private IUserService userService;
    private IXiaoceService xiaoceService;

    private ServiceFactory() {
        super();
    }

    ServiceFactory(Out arg1) {
        this();
    }

    public IAnalyticsService getAnalyticsService() {
        if (this.analyticsService == null) {
            this.analyticsService = new EmptyAnalyticsService();
        }

        return this.analyticsService;
    }

    public ICategoryService getCategoryService() {
        if (this.categoryService == null) {
            this.categoryService = new EmptyCategoryService();
        }

        return this.categoryService;
    }

    public IDebugService getDebugService() {
        if (this.debugService == null) {
            this.debugService = new EmptyDebugService();
        }

        return this.debugService;
    }

    public IEntryService getEntryService() {
        if (this.entryService == null) {
            this.entryService = new EmptyEntryService();
        }

        return this.entryService;
    }

    public Fragment getFragment(String arg2) {
        Object v0_1;
        try {
            v0_1 = ARouter.getInstance().build(arg2).navigation();
        } catch (Exception v0) {
            v0.printStackTrace();
            v0_1 = null;
        }

        if (v0_1 == null) {
            EmptyFragment v0_2 = EmptyFragment.newInstance(arg2);
        }

        return ((Fragment) v0_1);
    }

    public IHullService getHullService() {
        if (this.hullService == null) {
            this.hullService = new EmptyHullService();
        }

        return this.hullService;
    }

    public static ServiceFactory getInstance() {
        return Inner.getFactory();
    }

    public INotificationService getNotificationService() {
        return this.notificationService;
    }

    public IPinService getPinService() {
        return this.pinService;
    }

    public IPushService getPushService() {
        if (this.pushService == null) {
            this.pushService = new EmptyPushService();
        }

        return this.pushService;
    }

    public IUserService getUserService() {
        if (this.userService == null) {
            this.userService = new EmptyUserService();
        }

        return this.userService;
    }

    public IXiaoceService getXiaoceService() {
        if (this.xiaoceService == null) {
            this.xiaoceService = new EmptyXiaoceService();
        }

        return this.xiaoceService;
    }

    public void setAnalyticsService(IAnalyticsService arg1) {
        this.analyticsService = arg1;
    }

    public void setCategoryService(ICategoryService arg1) {
        this.categoryService = arg1;
    }

    public void setDebugService(IDebugService arg1) {
        this.debugService = arg1;
    }

    public void setEntryService(IEntryService arg1) {
        this.entryService = arg1;
    }

    public void setHullService(IHullService arg1) {
        this.hullService = arg1;
    }

    public void setNotificationService(INotificationService arg1) {
        this.notificationService = arg1;
    }

    public void setPinService(IPinService arg1) {
        this.pinService = arg1;
    }

    public void setPushService(IPushService arg1) {
        this.pushService = arg1;
    }

    public void setUserService(IUserService arg1) {
        this.userService = arg1;
    }

    public void setXiaoceService(IXiaoceService arg1) {
        this.xiaoceService = arg1;
    }
}
