package im.juejin.android.componentbase.typefactory;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import im.juejin.android.componentbase.model.BeanType;

public interface ITypeFactoryList {
    public static final String LIST_TYPE_NORMAL = "list_type_normal";

    public abstract RecyclerView.ViewHolder createViewHolder(Context context, View view);

    public abstract int type(BeanType beanType);

}
