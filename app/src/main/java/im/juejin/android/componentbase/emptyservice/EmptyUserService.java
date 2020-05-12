package im.juejin.android.componentbase.emptyservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import im.juejin.android.componentbase.model.UserBean;
import im.juejin.android.componentbase.service.IUserService;

public class EmptyUserService implements IUserService {
    public EmptyUserService() {
        super();
    }

    public boolean changeFollowState(boolean arg1, String arg2) {
        return false;
    }

    public boolean followUserList(List arg1) throws Exception {
        return false;
    }

    public String getAccountId() {
        return "5618ac3e60b26171743dcf6e";
    }

    public UserBean getUser(String arg1) throws Exception {
        return null;
    }

    public RecyclerView.ViewHolder getUserViewHolder(View arg1) {
        return null;
    }

    public boolean isCurrentUserFollow(String arg1) {
        return false;
    }

    public boolean isLogin() {
        return true;
    }


    public Fragment newUserFragment(Activity arg1, int arg2, FragmentManager arg3, Bundle arg4, String arg5) {
        return null;
    }

    public List queryIfFocus(List arg1) throws Exception {
        return arg1;
    }
}
