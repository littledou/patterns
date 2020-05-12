package im.juejin.android.componentbase.service;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface IPinService {
    RecyclerView.ViewHolder getCommentReplyHeaderViewHolder(View arg1);

    RecyclerView.ViewHolder getCommentReplyViewHolder(View arg1);

    int getRecommendRedPointsCount(String arg1) throws Exception;

    int getRedPointsCount(String arg1, String arg2) throws Exception;
}
