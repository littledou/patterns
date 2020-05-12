package im.juejin.android.componentbase;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmptyFragment extends Fragment {
    public EmptyFragment() {
        super();
    }

    public static EmptyFragment newInstance(String arg3) {
        Bundle v0 = new Bundle();
        EmptyFragment v1 = new EmptyFragment();
        v0.putString("text", arg3);
        v1.setArguments(v0);
        return v1;
    }

    @Nullable
    public View onCreateView(LayoutInflater arg2, @Nullable ViewGroup arg3, @Nullable Bundle arg4) {
        TextView v2 = new TextView(arg3.getContext());
        v2.setText(this.getArguments().getString("text", "Empty"));
        v2.setTextColor(0xFFFF0000);
        v2.setTextSize(2, 20f);
        v2.setGravity(17);
        return ((View) v2);
    }

    public void onHiddenChanged(boolean arg1) {
        super.onHiddenChanged(arg1);
        //TODO  移除VdsAgent
//        VdsAgent.onFragmentHiddenChanged(this, arg1);
    }

    public void onPause() {
        super.onPause();
//        VdsAgent.onFragmentPause(this);
    }

    public void onResume() {
        super.onResume();
//        VdsAgent.onFragmentResume(this);
    }

    public void setUserVisibleHint(boolean arg1) {
        super.setUserVisibleHint(arg1);
//        VdsAgent.setFragmentUserVisibleHint(this, arg1);
    }
}
