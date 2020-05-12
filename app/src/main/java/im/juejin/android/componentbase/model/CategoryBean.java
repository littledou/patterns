package im.juejin.android.componentbase.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import im.juejin.android.common.util.ListUtils;
import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class CategoryBean implements Parcelable, BeanType {
    private String background;
    private String createdAt;
    private String icon;
    private String id;
    private int index;
    private int isLocalSubscribe;
    @JSONField(name = "isSubscribe")
    private boolean isSubscribe;
    private String name;
    private String tagId;
    private String title;
    private String updatedAt;
    private String weight;


    public CategoryBean() {
        super();
    }

    protected CategoryBean(Parcel arg2) {
        super();
        this.id = arg2.readString();
        this.name = arg2.readString();
        this.title = arg2.readString();
        this.createdAt = arg2.readString();
        this.updatedAt = arg2.readString();
        this.tagId = arg2.readString();
        this.weight = arg2.readString();
        this.icon = arg2.readString();
        this.background = arg2.readString();
        boolean v0 = arg2.readByte() != 0 ? true : false;
        this.isSubscribe = v0;
        this.index = arg2.readInt();
        this.isLocalSubscribe = arg2.readInt();
    }

    public static final Creator<CategoryBean> CREATOR = new Creator<CategoryBean>() {
        @Override
        public CategoryBean createFromParcel(Parcel in) {
            return new CategoryBean(in);
        }

        @Override
        public CategoryBean[] newArray(int size) {
            return new CategoryBean[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public String getBackground() {
        return this.background;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIsLocalSubscribe() {
        return this.isLocalSubscribe;
    }

    public String getName() {
        return this.name;
    }

    public static List getSubscribeCategories(List arg3) {
        if (ListUtils.isNullOrEmpty(arg3)) {
            return new ArrayList();
        }

        ArrayList v0 = new ArrayList();
        Iterator v3 = arg3.iterator();
        while (v3.hasNext()) {
            Object v1 = v3.next();
            if (!((CategoryBean) v1).isSubscribe()) {
                continue;
            }

            ((List) v0).add(v1);
        }

        return ((List) v0);
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getWeight() {
        return this.weight;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public void setBackground(String arg1) {
        this.background = arg1;
    }

    public void setCreatedAt(String arg1) {
        this.createdAt = arg1;
    }

    public void setIcon(String arg1) {
        this.icon = arg1;
    }

    public void setId(String arg1) {
        this.id = arg1;
    }

    public void setIndex(int arg1) {
        this.index = arg1;
    }

    public void setIsLocalSubscribe(int arg1) {
        this.isLocalSubscribe = arg1;
    }

    public void setName(String arg1) {
        this.name = arg1;
    }

    public void setSubscribe(boolean arg1) {
        this.isSubscribe = arg1;
    }

    public void setTagId(String arg1) {
        this.tagId = arg1;
    }

    public void setTitle(String arg1) {
        this.title = arg1;
    }

    public void setUpdatedAt(String arg1) {
        this.updatedAt = arg1;
    }

    public void setWeight(String arg1) {
        this.weight = arg1;
    }

    public int type(ITypeFactoryList arg1) {
        return arg1.type(((BeanType) this));
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeString(this.id);
        arg1.writeString(this.name);
        arg1.writeString(this.title);
        arg1.writeString(this.createdAt);
        arg1.writeString(this.updatedAt);
        arg1.writeString(this.tagId);
        arg1.writeString(this.weight);
        arg1.writeString(this.icon);
        arg1.writeString(this.background);
        arg1.writeBoolean(this.isSubscribe);
        arg1.writeInt(this.index);
        arg1.writeInt(this.isLocalSubscribe);
    }
}