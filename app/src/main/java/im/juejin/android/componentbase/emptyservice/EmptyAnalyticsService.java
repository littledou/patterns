package im.juejin.android.componentbase.emptyservice;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import im.juejin.android.componentbase.service.IAnalyticsService;

public class EmptyAnalyticsService implements IAnalyticsService {
    public EmptyAnalyticsService() {
        super();
    }

    public void analyzaEntryDetail(Activity arg1, String arg2, String arg3) {
    }

    public void analyzeUserInfo() {
    }

    public Boolean clickAd(String arg1) throws Exception {
        return Boolean.valueOf(false);
    }

    public void logOut() {
    }

    public Boolean punchLocation(String arg1, String arg2) throws Exception {
        return Boolean.valueOf(false);
    }

    public void setLoginType(String arg1) {
    }

    public void track(String arg1) {
    }

    public void trackBanner(View arg1, List arg2) {
    }

    public void trackEditText(EditText arg1) {
    }


    public void trackFragment(Fragment arg1, String arg2) {
    }

    public Boolean uploadAdShow(String arg1, String arg2, int arg3) throws Exception {
        return Boolean.valueOf(false);
    }

    public Boolean uploadUserLog(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
        return Boolean.valueOf(false);
    }

    public Boolean uploadUserLog(@Nullable String arg1, @Nullable String arg2, @Nullable String arg3, @Nullable String arg4, @Nullable String arg5, @Nullable String arg6) throws Exception {
        return null;
    }

    public Boolean viewAd(String arg1) throws Exception {
        return Boolean.valueOf(false);
    }
}
