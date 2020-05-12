package im.juejin.android.base.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.daimajia.gold.R;
import com.daimajia.gold.extensitions.ViewExKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

import java.util.HashMap;

import im.juejin.android.base.utils.AppLogger;
import im.juejin.android.base.utils.SpUtils;
import im.juejin.android.base.views.statusbar.FixInsetsFrameLayout;
import im.juejin.android.base.views.statusbar.StatusBarView;
import im.juejin.android.common.util.ColorUtil;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

public class BaseActivity extends AppCompatActivity {
    private HashMap findViewCache;
    private ViewGroup flToolbar;
    private Toolbar mToolbar;
    private boolean night;
    private ViewGroup rootLayout;
    private int toolbarId;
    private boolean useCustomToolbar;

    public BaseActivity() {
        super();
    }

    public void clearFindViewByIdCache() {
        HashMap v0 = this.findViewCache;
        if (v0 != null) {
            v0.clear();
        }
    }

    public View findCachedViewById(int arg3) {
        View v0_1 = null;
        if (this.findViewCache == null) {
            this.findViewCache = new HashMap();
        }

        Object v0 = this.findViewCache.get(arg3);
        if (v0 == null) {
            v0_1 = ((FragmentActivity) this).findViewById(arg3);
            findViewCache.put(arg3, v0_1);
        }

        return v0_1;
    }

    protected final ViewGroup getFlToolbar() {
        return this.flToolbar;
    }

    public final Toolbar getMToolbar() {
        return this.mToolbar;
    }

    public final boolean getNight() {
        return this.night;
    }

    protected final ViewGroup getRootLayout() {
        return this.rootLayout;
    }

    protected int getToolbarHomeImgRes() {
        return R.drawable.toolbar_back_white;
    }

    protected final int getToolbarId() {
        return this.toolbarId;
    }

    protected final boolean getUseCustomToolbar() {
        return this.useCustomToolbar;
    }

    public final void hideNightLayer() {
        View v0 = this.findCachedViewById(R.id.night_layer);
        if (v0 != null) {
            ViewExKt.b(v0);
        }
    }

    protected final void hideSoftInputForce() {
        View v0 = this.getCurrentFocus();
        if (v0 != null) {
            Object v1 = this.getSystemService("input_method");
            if (v1 != null) {
                ((InputMethodManager) v1).hideSoftInputFromWindow(v0.getApplicationWindowToken(), 0);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
    }

    public final void hideToolBar() {
        Toolbar v0 = this.mToolbar;
        int v1 = 8;
        if (v0 != null) {
            ViewExKt.b(v0);
            v0.setVisibility(v1);
        }

        ViewGroup v0_1 = this.flToolbar;
        if (v0_1 != null) {
            v0_1.setVisibility(v1);
        }
    }

    private final void initNightLayer() {
        if (this.night) {
            this.showNightLayer();
        } else {
            this.hideNightLayer();
        }
    }

    private final void initToolbar() {
        View v0 = this.findViewById(R.id.toolbar);
        if (v0 != null) {
            this.mToolbar = ((Toolbar) v0);
            v0 = this.findViewById(R.id.fl_toolbar);
            if (v0 != null) {
                this.flToolbar = ((ViewGroup) v0);
                Toolbar v0_1 = this.mToolbar;
                if (v0_1 != null) {
                    this.setSupportActionBar(v0_1);
                    ActionBar v0_2 = this.getSupportActionBar();
                    if (v0_2 != null) {
                        v0_2.setDisplayHomeAsUpEnabled(true);
                    }

                    v0_1 = this.mToolbar;
                    if (v0_1 != null) {
                        v0_1.setBackgroundColor(ColorUtil.getAttrColor(this, R.attr.colorPrimary));
                    }

                    v0_1 = this.mToolbar;
                    if (v0_1 == null) {
                        return;
                    }

                    v0_1.setTitleTextColor(ColorUtil.getAttrColor(this, R.attr.themeToolbarTextColor));
                }

                return;
            }

            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }

        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.Toolbar");
    }

    private final void initToolbar(int arg1) {
        this.mToolbar = this.findViewById(arg1);
        Toolbar v1 = this.mToolbar;
        if (v1 != null) {
            this.setSupportActionBar(v1);
        }
    }

    public boolean isNight() {
        return this.night;
    }

    protected void onCreate(Bundle arg3) {
        View v3_2;
        try {
            Object v0 = SpUtils.get("night_mode", Boolean.valueOf(false));
            this.night = ((Boolean) v0).booleanValue();
            int v0_1 = this.night ? R.style.AppThemeDark : R.style.AppThemeLight;
            this.setTheme(v0_1);
            super.onCreate(arg3);
            super.setContentView(R.layout.activity_base);
            if (Build.VERSION.SDK_INT >= 21) {
                Window v3_1 = this.getWindow();
                v3_2 = v3_1.getDecorView();
                v3_2.setSystemUiVisibility(0xD00);
            }

            this.rootLayout = this.findViewById(R.id.root_layout);
            v3_2 = this.findCachedViewById(R.id.view_statusbar);
            if (v3_2 != null) {
                ((StatusBarView) v3_2).setStatusBarColor(ColorUtil.getAttrColor(this, R.attr.colorPrimaryDark));
            }

            this.initNightLayer();
            this.initToolbar();
        } catch (Exception v3) {
            AppLogger.e(((Throwable) v3));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.hideSoftInputForce();
    }

    @Instrumented
    public boolean onOptionsItemSelected(MenuItem arg3) {
        VdsAgent.onOptionsItemSelected(this, arg3);
        if (arg3 != null && arg3.getItemId() == 0x102002C) {
            this.onBackPressed();
        }

        boolean v3 = super.onOptionsItemSelected(arg3);
        VdsAgent.handleClickResult(new Boolean(v3));
        return v3;
    }

    protected void onResume() {
        super.onResume();
        Toolbar v0 = this.mToolbar;
        if (v0 != null && v0 != null) {
            v0.setNavigationIcon(this.getToolbarHomeImgRes());
        }
    }

    protected final void removeDefaultToolbar() {
        ViewGroup v0 = this.rootLayout;
        if (v0 != null) {
            v0.removeView(this.flToolbar);
        }
    }

    protected final void requestCameraPermission() {
//        PermissionUtils.requestPermissions(this, "android.permission.CAMERA", Config.PERMISSIONS_CAMERA, 0x6F);
    }

    protected final void requestStoragePermission() {
//        PermissionUtils.requestPermissions(this, "android.permission.WRITE_EXTERNAL_STORAGE", Config.PERMISSIONS_CAMERA, 0x70);
    }

    public void setContentView(int arg3) {
        View v3 = View.inflate(this, arg3, null);
        this.setContentView(v3);
    }

    public void setContentView(View arg4) {
        View v0_1;
        Intrinsics.checkParameterIsNotNull(arg4, "view");
        ViewGroup v0 = this.rootLayout;
        if (v0 == null) {
            return;
        }

        int v2 = -1;
        if (this.useCustomToolbar) {
            if (v0 != null) {
                v0.removeView(this.flToolbar);
            }

            v0_1 = this.findCachedViewById(R.id.base_container);
            if (v0_1 != null) {
                ((FixInsetsFrameLayout) v0_1).addView(arg4, new ViewGroup.LayoutParams(v2, v2));
            }

            int v4 = this.toolbarId;
            if (v4 <= 0) {
                return;
            }

            this.initToolbar(v4);
        } else {
            v0_1 = this.findCachedViewById(R.id.base_container);
            if (v0_1 != null) {
                ((FixInsetsFrameLayout) v0_1).addView(arg4, new ViewGroup.LayoutParams(v2, v2));
            }

            this.initToolbar();
        }
    }

    public final void setContentView(int arg1, boolean arg2, int arg3) {
        this.useCustomToolbar = arg2;
        this.toolbarId = arg3;
        this.setContentView(arg1);
    }

    protected final void setFlToolbar(ViewGroup arg1) {
        this.flToolbar = arg1;
    }

    protected final void setFullScreen() {
        this.removeDefaultToolbar();
        View v0 = this.findCachedViewById(R.id.view_statusbar);
        if (v0 != null) {
            ((StatusBarView) v0).setStatusBarHeight(0);
        }

        v0 = this.findCachedViewById(R.id.base_container);
        if (v0 != null) {
            ((FixInsetsFrameLayout) v0).setInsetEnable(true);
        }
    }

    public final void setMToolbar(Toolbar arg1) {
        this.mToolbar = arg1;
    }

    public final void setNight(boolean arg1) {
        this.night = arg1;
    }

    protected final void setRootLayout(ViewGroup arg1) {
        this.rootLayout = arg1;
    }

    public final void setStatusBarColor(@ColorRes int arg2) {
        View v0 = this.findCachedViewById(R.id.view_statusbar);
        if (v0 != null) {
            ((StatusBarView) v0).setStatusBarColor(ColorUtil.getColor(arg2));
        }
    }

    public final void setStatusBarColorInt(@ColorInt int arg2) {
        View v0 = this.findCachedViewById(R.id.view_statusbar);
        if (v0 != null) {
            ((StatusBarView) v0).setStatusBarColor(arg2);
        }
    }

    protected final void setToolbarId(int arg1) {
        this.toolbarId = arg1;
    }

    protected final void setUseCustomToolbar(boolean arg1) {
        this.useCustomToolbar = arg1;
    }

    public final void showNightLayer() {
        View v0 = this.findCachedViewById(R.id.night_layer);
        if (v0 != null) {
            ViewExKt.c(v0);
        }
    }

    protected final void showSoftInputForce() {
        @SuppressLint("WrongConstant") Object v0 = this.getSystemService("input_method");
        if (v0 != null) {
            ((InputMethodManager) v0).toggleSoftInput(2, 1);
            return;
        }

        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
