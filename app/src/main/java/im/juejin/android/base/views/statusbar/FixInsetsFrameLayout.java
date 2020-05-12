package im.juejin.android.base.views.statusbar;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public final class FixInsetsFrameLayout extends FrameLayout {
    private boolean insetEnable;
    private int[] mInsets;

    public FixInsetsFrameLayout(Context arg1) {
        super(arg1);
        this.mInsets = new int[4];
        this.insetEnable = false;
    }

    public FixInsetsFrameLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mInsets = new int[4];
        this.insetEnable = false;
    }

    public FixInsetsFrameLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mInsets = new int[4];
        this.insetEnable = false;
    }

    protected final boolean fitSystemWindows(Rect arg5) {
        if (!this.insetEnable && Build.VERSION.SDK_INT >= 21) {
            this.mInsets[0] = arg5.left;
            this.mInsets[1] = arg5.top;
            this.mInsets[2] = arg5.right;
            arg5.left = 0;
            arg5.top = 0;
            arg5.right = 0;
        }

        return super.fitSystemWindows(arg5);
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets arg5) {
        if (!this.insetEnable && Build.VERSION.SDK_INT >= 21) {
            this.mInsets[0] = arg5.getSystemWindowInsetLeft();
            this.mInsets[1] = arg5.getSystemWindowInsetTop();
            this.mInsets[2] = arg5.getSystemWindowInsetRight();
            arg5 = super.onApplyWindowInsets(arg5.replaceSystemWindowInsets(0, 0, 0, arg5.getSystemWindowInsetBottom()));
        }

        return arg5;
    }

    public void setInsetEnable(boolean arg1) {
        this.insetEnable = arg1;
    }
}