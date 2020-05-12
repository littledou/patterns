package im.juejin.android.componentbase.service;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public interface IAnalyticsService {
    void analyzaEntryDetail(Activity arg1, String arg2, String arg3);

    void analyzeUserInfo();

    Boolean clickAd(String arg1) throws Exception;

    void logOut();

    Boolean punchLocation(String arg1, String arg2) throws Exception;

    void setLoginType(String arg1);

    void track(String arg1);

    void trackBanner(View arg1, List arg2);

    void trackEditText(EditText arg1);

    void trackFragment(Fragment arg1, String arg2);

    Boolean uploadAdShow(String arg1, String arg2, int arg3) throws Exception;

    Boolean uploadUserLog(@Nullable String arg1, @Nullable String arg2, @Nullable String arg3, @Nullable String arg4, @Nullable String arg5) throws Exception;

    Boolean uploadUserLog(@Nullable String arg1, @Nullable String arg2, @Nullable String arg3, @Nullable String arg4, @Nullable String arg5, @Nullable String arg6) throws Exception;

    Boolean viewAd(String arg1) throws Exception;
}

