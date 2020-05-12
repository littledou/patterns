package com.daimajia.gold.extensitions;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class ViewExKt {
    private static final void a(View arg0, long arg1) {
        arg0.setTag(0x42F6A407, Long.valueOf(arg1));
    }

    public static final void a(View arg1, long arg2, Function1 arg4) {
        ViewExKt.b(arg1, arg2);
        arg1.setOnClickListener(new InterOnClickListener(arg1, arg4));
    }

    public static final void a(View arg1, Function1 arg2) {
        arg1.setOnClickListener(new InterOnClickListener(arg1, arg2));
    }

    public static final boolean a(View arg1) {
        boolean v1 = arg1.getVisibility() == View.GONE;
        return v1;
    }

    public static final void b(View arg1) {
        arg1.setVisibility(View.GONE);
    }

    private static final void b(View view, long arg1) {
        view.setTag(0x42F6A803, arg1);
    }

    public static final void c(View arg1) {
        arg1.setVisibility(View.VISIBLE);
    }

    public static final boolean d(View arg2) {
        Intrinsics.checkParameterIsNotNull(arg2, "receiver$0");
        arg2.clearFocus();
        @SuppressLint("WrongConstant") Object v0 = arg2.getContext().getSystemService("input_method");
        if (v0 != null) {
            return ((InputMethodManager) v0).hideSoftInputFromWindow(arg2.getWindowToken(), 0);
        }

        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final Bitmap e(View arg3) {
        Intrinsics.checkParameterIsNotNull(arg3, "receiver$0");
        Bitmap v0 = Bitmap.createBitmap(arg3.getWidth(), arg3.getHeight(), Bitmap.Config.RGB_565);
        arg3.draw(new Canvas(v0));
        return v0;
    }

    public static final boolean f(View arg0) {
        return ViewExKt.i(arg0);
    }

    private static final long g(View arg2) {
        long v0_1;
        int v0 = 0x42F6A407;
        if (arg2.getTag(v0) != null) {
            Object v2 = arg2.getTag(v0);
            if (v2 != null) {
                v0_1 = ((Long) v2).longValue();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
            }
        } else {
            v0_1 = 0;
        }

        return v0_1;
    }

    private static final long h(View arg2) {
        long v0_1;
        int v0 = 0x42F6A803;
        if (arg2.getTag(v0) != null) {
            Object v2 = arg2.getTag(v0);
            if (v2 != null) {
                v0_1 = ((Long) v2).longValue();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
            }
        } else {
            v0_1 = -1;
        }

        return v0_1;
    }

    private static final boolean i(View arg7) {
        long v0 = System.currentTimeMillis();
        boolean v2 = v0 - ViewExKt.g(arg7) >= ViewExKt.h(arg7) ? true : false;
        ViewExKt.a(arg7, v0);
        return v2;
    }

    static class InterOnClickListener implements View.OnClickListener {
        View v;
        Function1 function1;

        public InterOnClickListener(View arg1, Function1 arg2) {
            this.v = arg1;
            this.function1 = arg2;

        }

        @Override
        public void onClick(View arg2) {
//            VdsAgent.onClick(this, arg2);
            if (ViewExKt.f(this.v)) {
                if (arg2 != null) {
                    function1.invoke(arg2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type T");
                }
            }
        }
    }


}