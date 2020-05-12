package im.juejin.android.componentbase.service;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import im.juejin.android.componentbase.model.UserBean;

public interface IUserService {
    boolean changeFollowState(boolean arg1, String arg2) throws Exception;

    boolean followUserList(List arg1) throws Exception;

    String getAccountId();

    UserBean getUser(String arg1) throws Exception;

    RecyclerView.ViewHolder getUserViewHolder(View arg1);

    boolean isCurrentUserFollow(String arg1) throws Exception;

    boolean isLogin();

    Fragment newUserFragment(Activity arg1, int arg2, FragmentManager arg3, Bundle arg4, String arg5);

    List queryIfFocus(List arg1) throws Exception;
}
