package im.juejin.android.base.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import im.juejin.android.base.utils.TextUtil;
import im.juejin.android.componentbase.model.BeanType;
import im.juejin.android.componentbase.model.UserBean;
import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class CommentBean implements Parcelable, BeanType {


    private String commentId;
    private String content;
    private String createdAt;
    private boolean deleted;
    private EntryBean entryBean;
    private String entryId;
    private String id;
    @JSONField(name="isFirstComment") private boolean isFirstComment;
    @JSONField(name="isLiked") private boolean isLiked;
    private int likesCount;
    private String objectId;
    private List picList;
    private String respUser;
    private UserBean respUserInfo;
    private int subCount;
    private String targetId;
    private List topComment;
    private String updatedAt;
    private String userId;
    private UserBean userInfo;

    public CommentBean() {
        super();
    }

    protected CommentBean(Parcel arg4) {
        super();
        this.id = arg4.readString();
        this.objectId = arg4.readString();
        this.content = arg4.readString();
        this.userId = arg4.readString();
        this.respUser = arg4.readString();
        this.likesCount = arg4.readInt();
        this.createdAt = arg4.readString();
        this.updatedAt = arg4.readString();
        this.subCount = arg4.readInt();
        boolean v1 = true;
        boolean v0 = arg4.readByte() != 0 ? true : false;
        this.isLiked = v0;
        this.picList = arg4.createStringArrayList();
        this.targetId = arg4.readString();
        this.entryId = arg4.readString();
        this.entryBean = arg4.readParcelable(EntryBean.class.getClassLoader());
        this.commentId = arg4.readString();
        v0 = arg4.readByte() != 0 ? true : false;
        this.deleted = v0;
        this.userInfo = arg4.readParcelable(UserBean.class.getClassLoader());
        this.respUserInfo = arg4.readParcelable(UserBean.class.getClassLoader());
        this.topComment = arg4.createTypedArrayList(CommentBean.CREATOR);
        if(arg4.readByte() != 0) {
        }
        else {
            v1 = false;
        }

        this.isFirstComment = v1;
    }

    public static final Creator<CommentBean> CREATOR = new Creator<CommentBean>() {
        @Override
        public CommentBean createFromParcel(Parcel in) {
            return new CommentBean(in);
        }

        @Override
        public CommentBean[] newArray(int size) {
            return new CommentBean[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public EntryBean getEntryBean() {
        return this.entryBean;
    }

    public String getEntryId() {
        return this.entryId;
    }

    public String getId() {
        if(!TextUtil.isEmpty(this.id)) {
            return this.id;
        }

        return this.objectId;
    }

    public int getLikesCount() {
        return this.likesCount;
    }

    public List getPicList() {
        return this.picList;
    }

    public String getRespUser() {
        return this.respUser;
    }

    public UserBean getRespUserInfo() {
        return this.respUserInfo;
    }

    public int getSubCount() {
        return this.subCount;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public List getTopComment() {
        return this.topComment;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserBean getUserInfo() {
        return this.userInfo;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean isFirstComment() {
        return this.isFirstComment;
    }

    public boolean isLiked() {
        return this.isLiked;
    }

    public void setCommentId(String arg1) {
        this.commentId = arg1;
    }

    public void setContent(String arg1) {
        this.content = arg1;
    }

    public void setCreatedAt(String arg1) {
        this.createdAt = arg1;
    }

    public void setDeleted(boolean arg1) {
        this.deleted = arg1;
    }

    public void setEntryBean(EntryBean arg1) {
        this.entryBean = arg1;
    }

    public void setEntryId(String arg1) {
        this.entryId = arg1;
    }

    public void setFirstComment(boolean arg1) {
        this.isFirstComment = arg1;
    }

    public void setId(String arg1) {
        this.id = arg1;
    }

    public void setLiked(boolean arg1) {
        this.isLiked = arg1;
    }

    public void setLikesCount(int arg1) {
        this.likesCount = arg1;
    }

    public void setPicList(List arg1) {
        this.picList = arg1;
    }

    public void setRespUser(String arg1) {
        this.respUser = arg1;
    }

    public void setRespUserInfo(UserBean arg1) {
        this.respUserInfo = arg1;
    }

    public void setSubCount(int arg1) {
        this.subCount = arg1;
    }

    public void setTargetId(String arg1) {
        this.targetId = arg1;
    }

    public void setTopComment(List arg1) {
        this.topComment = arg1;
    }

    public void setUpdatedAt(String arg1) {
        this.updatedAt = arg1;
    }

    public void setUserId(String arg1) {
        this.userId = arg1;
    }

    public void setUserInfo(UserBean arg1) {
        this.userInfo = arg1;
    }

    public int type(ITypeFactoryList arg1) {
        return arg1.type(((BeanType)this));
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeString(this.id);
        arg2.writeString(this.objectId);
        arg2.writeString(this.content);
        arg2.writeString(this.userId);
        arg2.writeString(this.respUser);
        arg2.writeInt(this.likesCount);
        arg2.writeString(this.createdAt);
        arg2.writeString(this.updatedAt);
        arg2.writeInt(this.subCount);
        arg2.writeBoolean(this.isLiked);
        arg2.writeStringList(this.picList);
        arg2.writeString(this.targetId);
        arg2.writeString(this.entryId);
        arg2.writeParcelable(this.entryBean, arg3);
        arg2.writeString(this.commentId);
        arg2.writeBoolean(this.deleted);
        arg2.writeParcelable(this.userInfo, arg3);
        arg2.writeParcelable(this.respUserInfo, arg3);
        arg2.writeTypedList(this.topComment);
        arg2.writeBoolean(this.isFirstComment);
    }
}