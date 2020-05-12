package im.juejin.android.base.views.statusbar;


import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.daimajia.gold.R;

public class StatusBarView extends View {
    private int statusBarColor;
    private int statusBarHeight;

    public StatusBarView(Context arg2) {
        this(arg2, null);
    }

    public StatusBarView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public StatusBarView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.statusBarColor = ContextCompat.getColor(arg1, R.color.status_bar_black);
        this.statusBarHeight = this.getStatusBarHeight(arg1);
    }

    private int getNavigationBarHeight(Context arg5) {
        int v0 = arg5.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        int v5 = v0 > 0 ? arg5.getResources().getDimensionPixelSize(v0) : 0;
        return v5;
    }

    private int getStatusBarHeight(Context arg6) {
        int v1 = 0;
        if(Build.VERSION.SDK_INT < 21) {
            return 0;
        }

        int v0 = arg6.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(v0 > 0) {
            v1 = arg6.getResources().getDimensionPixelSize(v0);
        }

        return v1;
    }

    protected void onDraw(Canvas arg2) {
        arg2.drawColor(this.statusBarColor);
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(arg1, this.statusBarHeight);
    }

    public void setStatusBarColor(int arg1) {
        this.statusBarColor = arg1;
        this.invalidate();
    }

    public void setStatusBarHeight(int arg2) {
        this.statusBarHeight = arg2;
        this.getLayoutParams().height = arg2;
        this.requestLayout();
    }
}

