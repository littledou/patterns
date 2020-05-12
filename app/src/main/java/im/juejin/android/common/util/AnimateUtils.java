package im.juejin.android.common.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.daimajia.gold.extensitions.ViewExKt;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class AnimateUtils {
    public static final AnimateUtils INSTANCE = new AnimateUtils();
    ;

    private AnimateUtils() {
        super();
    }

    public final void backgroundColorAnim(View arg4, int arg5, int arg6) {
        Intrinsics.checkParameterIsNotNull(arg4, "view");
        ValueAnimator v5 = ValueAnimator.ofObject(new ArgbEvaluator(), arg6, arg5);
        v5.setDuration(2000);
        v5.addUpdateListener(new InterListener1(arg4));
        v5.start();
    }

    public final void floatThenDismiss(View arg3, long arg4, Function0 arg6) {
        Intrinsics.checkParameterIsNotNull(arg3, "view");
        arg3.setAlpha(1f);
        ViewExKt.c(arg3);
        arg3.animate().alpha(0f).setListener(new InterListener2(arg3, arg6, arg4)).setStartDelay(arg4).start();
        ObjectAnimator v3 = ObjectAnimator.ofFloat(arg3, "translationY", -12f, 12f, -12f, 12f, -12f);
        v3.setInterpolator(new LinearInterpolator());
        v3.setDuration(arg4).start();
    }

    public static void floatThenDismiss(AnimateUtils arg0, View arg1, long arg2, Function0 arg4, int arg5, Object arg6) {
        if ((arg5 & 4) != 0) {
            arg4 = null;
        }

        arg0.floatThenDismiss(arg1, arg2, arg4);
    }

    class InterListener2 extends AnimatorListenerAdapter {
        private View view;
        private Function0 function0;

        InterListener2(View arg1, Function0 arg2, long arg3) {
            this.view = arg1;
            this.function0 = arg2;
        }

        public void onAnimationCancel(Animator arg1) {
            super.onAnimationCancel(arg1);
            if (view != null) {
                ViewExKt.b(view);
            }

            if (function0 != null) {
                function0.invoke();
            }
        }

        public void onAnimationEnd(Animator arg1) {
            super.onAnimationEnd(arg1);
            if (view != null) {
                ViewExKt.b(view);
            }

            if (function0 != null) {
                function0.invoke();
            }
        }
    }


    static class InterListener1 implements ValueAnimator.AnimatorUpdateListener {
        private View view;

        InterListener1(View arg1) {
            this.view = arg1;
        }

        public final void onAnimationUpdate(ValueAnimator arg3) {
            Object v3 = arg3.getAnimatedValue();
            if (v3 != null) {
                view.setBackgroundColor(((Integer) v3).intValue());
                return;
            }

            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

}
