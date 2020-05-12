package im.juejin.android.hull.activity;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.core.app.ActivityCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.daimajia.gold.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import im.juejin.android.base.action.UserAction;
import im.juejin.android.base.activity.BaseActivity;
import im.juejin.android.base.model.AdBean;
import im.juejin.android.base.utils.SpUtils;
import im.juejin.android.common.ApplicationProvider;
import im.juejin.android.common.extensions.RxJavaExKt;
import im.juejin.android.common.util.EventBusWrapper;
import im.juejin.android.common.util.ListUtils;
import im.juejin.android.componentbase.ServiceFactory;
import im.juejin.android.componentbase.model.BannerBean;
import im.juejin.android.componentbase.service.IEntryService;
import im.juejin.android.componentbase.service.IHullService;
import im.juejin.android.hull.fragment.OnClickKnowListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;
import rx.schedulers.Schedulers;

public final class LogoActivity extends BaseActivity implements OnClickKnowListener {
    private final int AD_TIME;
    private Object bannerService;
    private Object categoryService;
    private Subscription countdownTask;
    private IEntryService entryService;
    private AdBean splashBannerBean;
    private Subscription task;

    public LogoActivity() {
        super();
        this.AD_TIME = 2;
    }

    public static final void access$checkCategoryList(LogoActivity arg0) {
        arg0.checkCategoryList();
    }

    public static final void access$checkNewOfflineActivity(LogoActivity arg0) {
        arg0.checkNewOfflineActivity();
    }

    public static final void access$fetchSuid(LogoActivity arg0) {
        arg0.fetchSuid();
    }

    public static final int access$getAD_TIME$p(LogoActivity arg0) {
        return arg0.AD_TIME;
    }

    public static final Object access$getCategoryService$p(LogoActivity arg0) {
        return arg0.categoryService;
    }

    public static final AdBean access$getSplashBannerBean$p(LogoActivity arg0) {
        return arg0.splashBannerBean;
    }

    public static final void access$handleDownLoadTask(LogoActivity arg0, int arg1) {
        arg0.handleDownLoadTask(arg1);
    }

    public static final void access$handleNavigation(LogoActivity arg0) {
        arg0.handleNavigation();
    }

    public static final void access$setCategoryService$p(LogoActivity arg0, Object arg1) {
        arg0.categoryService = arg1;
    }

    public static final void access$setSplashBannerBean$p(LogoActivity arg0, AdBean arg1) {
        arg0.splashBannerBean = arg1;
    }

    public static final void access$statisticSplashUserAction(LogoActivity arg0, AdBean arg1, String arg2) {
        arg0.statisticSplashUserAction(arg1, arg2);
    }

    public static final void access$stopProgressAnim(LogoActivity arg0) {
        arg0.stopProgressAnim();
    }

    public static final void access$unSubscribeCountdownTask(LogoActivity arg0) {
        arg0.unSubscribeCountdownTask();
    }

    public static final void access$uploadAdData(LogoActivity arg0) {
        arg0.uploadAdData();
    }

    public final void afterUserAgreementDialog() {
        this.launchCount();
        this.startDownLoadTask();
        ServiceFactory v0 = ServiceFactory.getInstance();
        String v1 = "ServiceFactory.getInstance()";
        Intrinsics.a(v0, v1);
        IHullService v0_1 = v0.getHullService();
        Intrinsics.a(v0_1, "ServiceFactory.getInstance().hullService");
        if (v0_1.isFromPush()) {
            this.handleNavigation();
            v0 = ServiceFactory.getInstance();
            Intrinsics.a(v0, v1);
            v0.getHullService().fromPush("");
            return;
        }

        this.getSplash();
    }

    private final void analyticAD(int arg2) {
        if (arg2 == this.AD_TIME) {
            this.statisticSplashUserAction(this.splashBannerBean, "view");
        }
    }

    private final void checkCategoryList() {
        if (!UserAction.isLogin()) {
            return;
        }

        RxUtils.wrapper(new LogoActivity$checkCategoryList$1(this)).b(RxUtils.ignoreSubscriber());
    }

    private final void checkNewOfflineActivity() {
    }

    private final void checkPermission() {
        LogoActivity v0 = this;
        if ((PermissionUtils.needRequestPermission(((Activity) v0), "android.permission.WRITE_EXTERNAL_STORAGE")) || (PermissionUtils.needRequestPermission(((Activity) v0), "android.permission.READ_PHONE_STATE"))) {
            ActivityCompat.requestPermissions(((Activity) v0), Config.PERMISSIONS_NECESSARY, 0x70);
        } else {
            this.jump2Activity();
        }
    }

    private final void fetchSuid() {
        RxUtils.wrapper(LogoActivity$fetchSuid$1.INSTANCE).b(RxUtils.ignoreSubscriber());
    }

    private final void getSplash() {
        AdNetClient.INSTANCE.getSplashListByRx().c(5, TimeUnit.SECONDS).a(RxUtils.applySchedulers()).a(new LogoActivity$getSplash$1(this), new LogoActivity$getSplash$2(this));
    }

    private final BannerBean getSplashBannerBean(List arg6, boolean arg7) {
        Object v0;
        BannerBean v1 = null;
        if (ListUtils.isNullOrEmpty(arg6)) {
            return v1;
        }

        Iterator v6 = arg6.iterator();
        do {
            label_5:
            if (!v6.hasNext()) {
                return v1;
            }

            v0 = v6.next();
            if (arg7) {
                if (!TimeUtils.isInDate(((BannerBean) v0).getOsTime(), ((BannerBean) v0).getStartedAt(), ((BannerBean) v0).getEndedAt())) {
                    goto label_5;
                }

                return ((BannerBean) v0);
            }
        }
        while ((TimeUtils.isInDate(((BannerBean) v0).getOsTime(), ((BannerBean) v0).getStartedAt(), ((BannerBean) v0).getEndedAt()) ^ 1) == 0);

        return ((BannerBean) v0);
    }

    private final void handleDownLoadTask(int arg2) {
        this.analyticAD(arg2);
        this.startProgressAnim(arg2);
        this.countdownTask = RxUtils.countdown(arg2).a(LogoActivity$handleDownLoadTask$1.INSTANCE).b(new LogoActivity$handleDownLoadTask$2(this));
    }

    private final void handleNavigation() {
        this.unSubscribeTask(this.task);
        if (Once.isFirstInstallApp()) {
            Once.appIsInstalled();
            RomUtil.createDeskShortCut(this.getApplicationContext(), LogoActivity.class);
        }

        this.checkPermission();
    }

    private final void jump2Activity() {
        IHullService v3_1;
        IHullService v4_1;
        ServiceFactory v4;
        Intent v0;
        String v1 = "push_json";
        String v2 = "ServiceFactory.getInstance().hullService";
        String v3 = "ServiceFactory.getInstance()";
        if (!UserAction.isLogin()) {
            v0 = new Intent(this, MainActivity.class);
            v0.setAction("com.daimajia.gold.EXPLORE");
            v4 = ServiceFactory.getInstance();
            Intrinsics.a(v4, v3);
            v4_1 = v4.getHullService();
            Intrinsics.a(v4_1, v2);
            if (v4_1.isFromPush()) {
                v4 = ServiceFactory.getInstance();
                Intrinsics.a(v4, v3);
                v3_1 = v4.getHullService();
                Intrinsics.a(v3_1, v2);
                v0.putExtra(v1, v3_1.getPushJSON());
            }

            this.startActivity(v0);
        } else {
            v0 = MainActivity.Companion.getStartIntent(this);
            v4 = ServiceFactory.getInstance();
            Intrinsics.a(v4, v3);
            v4_1 = v4.getHullService();
            Intrinsics.a(v4_1, v2);
            if (v4_1.isFromPush()) {
                v4 = ServiceFactory.getInstance();
                Intrinsics.a(v4, v3);
                v3_1 = v4.getHullService();
                Intrinsics.a(v3_1, v2);
                v0.putExtra(v1, v3_1.getPushJSON());
            }

            this.startActivity(v0);
        }

        this.finish();
        this.overridePendingTransition(0x7F01001F, 0x7F010023);
    }

    private final void launchCount() {
        SpUtils.saveDevice("launch_count", Integer.valueOf(SpUtils.getDevice("launch_count", Integer.valueOf(0)).intValue() + 1));
    }

    public void onClickKnowButton() {
        Once.setUserAgreementDialogShown();
        Log.d("JJAPP", "初始化applog");
        if (!GoldApplicationLike.isApplogInited) {
            GoldApplicationLike.initAppLog(ApplicationProvider.getApplication());
            ApplicationProvider.getApplication().registerActivityLifecycleCallbacks(new JJLifecycleCallback());
        }

        this.afterUserAgreementDialog();
    }

    protected void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        this.setContentView(R.layout.activity_splash);
        this.setFullScreen();
        EventBusWrapper.register(this);
        this.bannerService = ARouter.getInstance().build("/entry/BannerService").j();
        this.categoryService = ARouter.getInstance().build("/entry/CategoryService").j();
        ServiceFactory v2 = ServiceFactory.getInstance();
        Intrinsics.checkNotNull(v2, "ServiceFactory.getInstance()");
        this.entryService = v2.getEntryService();
        View v2_1 = this.findCachedViewById(R.id.iv_splash);
        if (v2_1 != null) {
            ((ImageView) v2_1).setOnClickListener(new LogoActivity$onCreate$1(this));
        }

        v2_1 = this.findCachedViewById(R.id.fl_skip);
        if (v2_1 != null) {
            ((FrameLayout) v2_1).setOnClickListener(new LogoActivity$onCreate$2(this));
        }

        if (!Once.isUserAgreementDialogShown()) {
            this.showUserAgreementDialog();
        } else {
            this.afterUserAgreementDialog();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBusWrapper.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(MainActivityCreatedEvent arg2) {
        Intrinsics.checkParameterIsNotNull(arg2, "event");
        this.finish();
        this.overridePendingTransition(0, 0);
    }

    public void onRequestPermissionsResult(int arg2, String[] arg3, int[] arg4) {
        Intrinsics.checkParameterIsNotNull(arg3, "permissions");
        Intrinsics.checkParameterIsNotNull(arg4, "grantResults");
        if (arg2 == 0x70) {
            PermissionUtils.verifyPermissions(arg4);
            this.jump2Activity();
        } else {
            super.onRequestPermissionsResult(arg2, arg3, arg4);
        }
    }

    protected void onResume() {
        super.onResume();
        this.hideToolBar();
    }

    private final void showUserAgreementDialog() {
        String v1 = "UserAgreementDialogFragment";
        if (this.getSupportFragmentManager().findFragmentByTag(v1) == null) {
            UserAgreementDialogFragment v0 = UserAgreementDialogFragment.Companion.newInstance();
            v0.setCancelable(false);
            this.getSupportFragmentManager().beginTransaction().add(((Fragment) v0), v1).commitAllowingStateLoss();
        }
    }

    private final void startDownLoadTask() {
        this.task = Observable.a(Long.valueOf(1)).b(Schedulers.io()).a(new LogoActivity$startDownLoadTask$1(this)).b(RxUtils.ignoreSubscriber());
    }

    private final void startProgressAnim(int arg4) {
        if (arg4 == this.AD_TIME && this.findCachedViewById(R.id.progressBar) != null) {
            ObjectAnimator v0 = ObjectAnimator.ofInt(this.findCachedViewById(R.id.progressBar), "progress", new int[]{0, 500});
            Intrinsics.a(v0, "animation");
            v0.setDuration(((long) (arg4 * 1000)));
            v0.setInterpolator(new DecelerateInterpolator());
            v0.start();
        }
    }

    private final void statisticSplashUserAction(AdBean arg2, String arg3) {
        if (arg2 == null) {
            return;
        }

        Observable v2 = RxUtils.wrapper(new LogoActivity$statisticSplashUserAction$1(arg3, arg2));
        Intrinsics.a(v2, "RxUtils.wrapper {\n      …)\n            }\n        }");
        RxJavaExKt.asyncExecute(v2);
    }

    private final void stopProgressAnim() {
        View v0 = this.findCachedViewById(R.id.progressBar);
        if (v0 != null) {
            ((ProgressBar) v0).clearAnimation();
        }
    }

    private final void unSubscribeCountdownTask() {
        Subscription v0 = this.countdownTask;
        if (v0 != null) {
            if (v0 == null) {
                Intrinsics.a();
            }

            if (v0.isUnsubscribed()) {
                return;
            }

            v0 = this.countdownTask;
            if (v0 == null) {
                Intrinsics.a();
            }

            v0.unsubscribe();
        }
    }

    public final void unSubscribeTask(Subscription arg2) {
        if (arg2 != null && !arg2.isUnsubscribed()) {
            arg2.unsubscribe();
        }
    }

    private final void uploadAdData() {
        IEntryService v0 = this.entryService;
        if (v0 != null && ((v0 instanceof IEntryService))) {
            if (v0 != null) {
                v0.postAdInfo();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type im.juejin.android.componentbase.service.IEntryService");
            }
        }
    }
}

