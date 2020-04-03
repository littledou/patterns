package im.juejin.android.componentbase.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class UserBean implements Parcelable, BeanType {

    public static final Parcelable.Creator<UserBean> CREATOR = (Parcelable.Creator<UserBean>) new Object();

    private String avatarLarge;

    public String avatar_hd;

    private String avatar_large;

    private String blogAddress;

    private int collectedEntriesCount;

    private int collectionSetCount;

    private CommunityBean community;

    public String company;

    private Date createdAt;

    @JSONField(name = "currentUserFollowed")
    @Deprecated
    private boolean currentUserFollowed;

    private String email;

    private int followeesCount;

    private int followersCount;

    private String id;

    @JSONField(name = "isAuthor")
    public boolean isAuthor;

    @JSONField(name = "isFollowerFollowed")
    @Deprecated
    private boolean isFollowerFollowed;

    private boolean isSelect;

    @JSONField(name = "isUnitedAuthor")
    public boolean isUnitedAuthor;

    public String jobTitle;

    private int juejinPower;

    private int level;

    private int likedPinCount;

    private String mobilePhoneNumber;

    private boolean mobilePhoneVerified;

    @Deprecated
    public String objectId;

    private int pinCount;

    private int postedEntriesCount;

    private int postedPostsCount;

    private int purchasedBookletCount;

    public String role;

    private UserRoles roles;

    private boolean selectAll;

    @JSONField(name = "selfDescription")
    public String self_description;

    private String statisticCategory;

    private String statisticLocation;

    private int subscribedTagsCount;

    private int tagFollowCount;

    private String tagName;

    private int totalCollectionsCount;

    private int totalCommentsCount;

    private int totalViewsCount;

    private Date updatedAt;

    public String username;

    private int viewedEntriesCount;

    private boolean viewerIsFollowing;

    public UserBean() {
    }

    protected UserBean(Parcel paramParcel) {
        boolean bool1;
        Date date1;
        long l = paramParcel.readLong();
        Date date2 = null;
        if (l == -1L) {
            date1 = null;
        } else {
            date1 = new Date(l);
        }
        this.updatedAt = date1;
        l = paramParcel.readLong();
        if (l == -1L) {
            date1 = date2;
        } else {
            date1 = new Date(l);
        }
        this.createdAt = date1;
        this.username = paramParcel.readString();
        this.avatar_hd = paramParcel.readString();
        this.objectId = paramParcel.readString();
        this.role = paramParcel.readString();
        this.company = paramParcel.readString();
        this.jobTitle = paramParcel.readString();
        this.self_description = paramParcel.readString();
        byte b = paramParcel.readByte();
        boolean bool2 = true;
        if (b != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.isFollowerFollowed = bool1;
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.currentUserFollowed = bool1;
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.viewerIsFollowing = bool1;
        this.avatar_large = paramParcel.readString();
        this.avatarLarge = paramParcel.readString();
        this.totalCollectionsCount = paramParcel.readInt();
        this.totalCommentsCount = paramParcel.readInt();
        this.viewedEntriesCount = paramParcel.readInt();
        this.postedEntriesCount = paramParcel.readInt();
        this.postedPostsCount = paramParcel.readInt();
        this.collectedEntriesCount = paramParcel.readInt();
        this.subscribedTagsCount = paramParcel.readInt();
        this.collectionSetCount = paramParcel.readInt();
        this.likedPinCount = paramParcel.readInt();
        this.followeesCount = paramParcel.readInt();
        this.followersCount = paramParcel.readInt();
        this.tagFollowCount = paramParcel.readInt();
        this.totalViewsCount = paramParcel.readInt();
        this.pinCount = paramParcel.readInt();
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.isUnitedAuthor = bool1;
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.isAuthor = bool1;
        this.blogAddress = paramParcel.readString();
        this.mobilePhoneNumber = paramParcel.readString();
        this.email = paramParcel.readString();
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.isSelect = bool1;
        if (paramParcel.readByte() != 0) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        this.selectAll = bool1;
        this.tagName = paramParcel.readString();
        this.id = paramParcel.readString();
        this.level = paramParcel.readInt();
        if (paramParcel.readByte() != 0) {
            bool1 = bool2;
        } else {
            bool1 = false;
        }
        this.mobilePhoneVerified = bool1;
        this.statisticCategory = paramParcel.readString();
        this.statisticLocation = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAvatarLarge() {
        return !TextUtils.isEmpty(this.avatar_large) ? this.avatar_large : this.avatarLarge;
    }

    @Deprecated
    public String getAvatar_hd() {
        return TextUtils.isEmpty(this.avatar_hd) ? getAvatarLarge() : this.avatar_hd;
    }

    public String getBlogAddress() {
        return this.blogAddress;
    }

    public int getCollectedEntriesCount() {
        return this.collectedEntriesCount;
    }

    public int getCollectionSetCount() {
        return this.collectionSetCount;
    }

    public CommunityBean getCommunity() {
        return this.community;
    }

    public String getCompany() {
        return this.company;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getDefaultObjectId() {
        return this.objectId;
    }

    public String getEmail() {
        return this.email;
    }

    public int getFolloweesCount() {
        return this.followeesCount;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public String getId() {
        return TextUtils.isEmpty(this.id) ? this.objectId : this.id;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public int getJuejinPower() {
        return this.juejinPower;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLikedPinCount() {
        return this.likedPinCount;
    }

    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber;
    }

    public boolean getMobilePhoneVerified() {
        return this.mobilePhoneVerified;
    }

    @Deprecated
    public String getObjectId() {
        return TextUtils.isEmpty(this.objectId) ? this.id : this.objectId;
    }

    public int getPinCount() {
        return this.pinCount;
    }

    public int getPostedEntriesCount() {
        return this.postedEntriesCount;
    }

    public int getPostedPostsCount() {
        return this.postedPostsCount;
    }

    public int getPurchasedBookletCount() {
        return this.purchasedBookletCount;
    }

    public String getRole() {
        return this.role;
    }

    public UserRoles getRoles() {
        return this.roles;
    }

    public String getSelf_description() {
        return this.self_description;
    }

    public String getStatisticCategory() {
        return this.statisticCategory;
    }

    public String getStatisticLocation() {
        return this.statisticLocation;
    }

    public int getSubscribedTagsCount() {
        return this.subscribedTagsCount;
    }

    public int getTagFollowCount() {
        return this.tagFollowCount;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int getTotalCollectionsCount() {
        return this.totalCollectionsCount;
    }

    public int getTotalCommentsCount() {
        return this.totalCommentsCount;
    }

    public int getTotalViewsCount() {
        return this.totalViewsCount;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUsername() {
        return this.username;
    }

    public int getViewedEntriesCount() {
        return this.viewedEntriesCount;
    }

    public boolean isAuthor() {
        return this.isAuthor;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isSelectAll() {
        return this.selectAll;
    }

    public boolean isUnitedAuthor() {
        return this.isUnitedAuthor;
    }

    public boolean isUserFollowed() {
        return (this.viewerIsFollowing || this.isFollowerFollowed || this.currentUserFollowed);
    }

    public boolean isViewerIsFollowing() {
        return this.viewerIsFollowing;
    }

    public void setAvatarLarge(String paramString) {
        this.avatarLarge = paramString;
        this.avatar_large = paramString;
    }

    public void setAvatar_hd(String paramString) {
        this.avatar_hd = paramString;
    }

    public void setAvatar_large(String paramString) {
        this.avatar_large = paramString;
        this.avatarLarge = paramString;
    }

    public void setBlogAddress(String paramString) {
        this.blogAddress = paramString;
    }

    public void setCollectedEntriesCount(int paramInt) {
        this.collectedEntriesCount = paramInt;
    }

    public UserBean setCollectionSetCount(int paramInt) {
        this.collectionSetCount = paramInt;
        return this;
    }

    public UserBean setCommunity(CommunityBean paramCommunityBean) {
        this.community = paramCommunityBean;
        return this;
    }

    public void setCompany(String paramString) {
        this.company = paramString;
    }

    public void setCreatedAt(Date paramDate) {
        this.createdAt = paramDate;
    }

    public void setCurrentUserFollowed(boolean paramBoolean) {
        this.isFollowerFollowed = paramBoolean;
        this.currentUserFollowed = paramBoolean;
    }

    public void setEmail(String paramString) {
        this.email = paramString;
    }

    public void setField(String paramString1, String paramString2) {
        if (TextUtils.isEmpty(paramString1))
            return;
        byte b = -1;
        switch (paramString1.hashCode()) {
            case 1117620722:
                if (paramString1.equals("blogAddress"))
                    b = 4;
                break;
            case 950484093:
                if (paramString1.equals("company"))
                    b = 3;
                break;
            case 650056976:
                if (paramString1.equals("selfDescription"))
                    b = 5;
                break;
            case 379189602:
                if (paramString1.equals("avatarLarge"))
                    b = 0;
                break;
            case 96619420:
                if (paramString1.equals("email"))
                    b = 8;
                break;
            case -181110699:
                if (paramString1.equals("mobilePhoneNumber"))
                    b = 7;
                break;
            case -265713450:
                if (paramString1.equals("username"))
                    b = 1;
                break;
            case -576407339:
                if (paramString1.equals("avatar_large"))
                    b = 6;
                break;
            case -1625529189:
                if (paramString1.equals("jobTitle"))
                    b = 2;
                break;
        }
        switch (b) {
            default:
                return;
            case 8:
                setEmail(paramString2);
                return;
            case 7:
                setMobilePhoneNumber(paramString2);
                return;
            case 6:
                setAvatar_large(paramString2);
                return;
            case 5:
                setSelf_description(paramString2);
                return;
            case 4:
                setBlogAddress(paramString2);
                return;
            case 3:
                setCompany(paramString2);
                return;
            case 2:
                setJobTitle(paramString2);
                return;
            case 1:
                setUsername(paramString2);
                return;
            case 0:
                break;
        }
        setAvatarLarge(paramString2);
    }

    public void setFolloweesCount(int paramInt) {
        this.followeesCount = paramInt;
    }

    public void setFollowerFollowed(boolean paramBoolean) {
        this.isFollowerFollowed = paramBoolean;
        this.currentUserFollowed = paramBoolean;
    }

    public void setFollowersCount(int paramInt) {
        this.followersCount = paramInt;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setJobTitle(String paramString) {
        this.jobTitle = paramString;
    }

    public void setJuejinPower(int paramInt) {
        this.juejinPower = paramInt;
    }

    public void setLevel(int paramInt) {
        this.level = paramInt;
    }

    public void setLikedPinCount(int paramInt) {
        this.likedPinCount = paramInt;
    }

    public void setMobilePhoneNumber(String paramString) {
        this.mobilePhoneNumber = paramString;
    }

    public void setMobilePhoneVerified(boolean paramBoolean) {
        this.mobilePhoneVerified = paramBoolean;
    }

    public void setObjectId(String paramString) {
        this.objectId = paramString;
    }

    public void setPinCount(int paramInt) {
        this.pinCount = paramInt;
    }

    public void setPostedEntriesCount(int paramInt) {
        this.postedEntriesCount = paramInt;
    }

    public UserBean setPostedPostsCount(int paramInt) {
        this.postedPostsCount = paramInt;
        return this;
    }

    public void setPurchasedBookletCount(int paramInt) {
        this.purchasedBookletCount = paramInt;
    }

    public void setRole(String paramString) {
        this.role = paramString;
    }

    public void setRoles(UserRoles paramUserRoles) {
        this.roles = paramUserRoles;
    }

    public void setSelect(boolean paramBoolean) {
        this.isSelect = paramBoolean;
    }

    public void setSelectAll(boolean paramBoolean) {
        this.selectAll = paramBoolean;
    }

    public void setSelf_description(String paramString) {
        this.self_description = paramString;
    }

    public void setStatisticCategory(String paramString) {
        this.statisticCategory = paramString;
    }

    public void setStatisticLocation(String paramString) {
        this.statisticLocation = paramString;
    }

    public void setSubscribedTagsCount(int paramInt) {
        this.subscribedTagsCount = paramInt;
    }

    public void setTagFollowCount(int paramInt) {
        this.tagFollowCount = paramInt;
    }

    public void setTagName(String paramString) {
        this.tagName = paramString;
    }

    public UserBean setTotalCollectionsCount(int paramInt) {
        this.totalCollectionsCount = paramInt;
        return this;
    }

    public UserBean setTotalCommentsCount(int paramInt) {
        this.totalCommentsCount = paramInt;
        return this;
    }

    public void setTotalViewsCount(int paramInt) {
        this.totalViewsCount = paramInt;
    }

    public void setUpdatedAt(Date paramDate) {
        this.updatedAt = paramDate;
    }

    public void setUsername(String paramString) {
        this.username = paramString;
    }

    public UserBean setViewedEntriesCount(int paramInt) {
        this.viewedEntriesCount = paramInt;
        return this;
    }

    public void setViewerIsFollowing(boolean paramBoolean) {
        this.viewerIsFollowing = paramBoolean;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserBean{, username='");
        stringBuilder.append(this.username);
        stringBuilder.append('\'');
        stringBuilder.append(", avatar_hd='");
        stringBuilder.append(this.avatar_hd);
        stringBuilder.append('\'');
        stringBuilder.append(", objectId='");
        stringBuilder.append(this.objectId);
        stringBuilder.append('\'');
        stringBuilder.append(", company='");
        stringBuilder.append(this.company);
        stringBuilder.append('\'');
        stringBuilder.append(", jobTitle='");
        stringBuilder.append(this.jobTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", self_description='");
        stringBuilder.append(this.self_description);
        stringBuilder.append('\'');
        stringBuilder.append(", totalCollectionsCount=");
        stringBuilder.append(this.totalCollectionsCount);
        stringBuilder.append(", totalCommentsCount=");
        stringBuilder.append(this.totalCommentsCount);
        stringBuilder.append(", viewedEntriesCount=");
        stringBuilder.append(this.viewedEntriesCount);
        stringBuilder.append(", postedEntriesCount=");
        stringBuilder.append(this.postedEntriesCount);
        stringBuilder.append(", postedPostsCount=");
        stringBuilder.append(this.postedPostsCount);
        stringBuilder.append(", collectedEntriesCount=");
        stringBuilder.append(this.collectedEntriesCount);
        stringBuilder.append(", subscribedTagsCount=");
        stringBuilder.append(this.subscribedTagsCount);
        stringBuilder.append(", collectionSetCount=");
        stringBuilder.append(this.collectionSetCount);
        stringBuilder.append(", followeesCount=");
        stringBuilder.append(this.followeesCount);
        stringBuilder.append(", followersCount=");
        stringBuilder.append(this.followersCount);
        stringBuilder.append(", tagFollowCount=");
        stringBuilder.append(this.tagFollowCount);
        stringBuilder.append(", totalViewsCount=");
        stringBuilder.append(this.totalViewsCount);
        stringBuilder.append(", likedPinCount=");
        stringBuilder.append(this.likedPinCount);
        stringBuilder.append(", pinCount=");
        stringBuilder.append(this.pinCount);
        stringBuilder.append(", isUnitedAuthor=");
        stringBuilder.append(this.isUnitedAuthor);
        stringBuilder.append(", isAuthor=");
        stringBuilder.append(this.isAuthor);
        stringBuilder.append(", blogAddress='");
        stringBuilder.append(this.blogAddress);
        stringBuilder.append('\'');
        stringBuilder.append(", mobilePhoneNumber='");
        stringBuilder.append(this.mobilePhoneNumber);
        stringBuilder.append('\'');
        stringBuilder.append(", email='");
        stringBuilder.append(this.email);
        stringBuilder.append('\'');
        stringBuilder.append(", community=");
        stringBuilder.append(this.community);
        stringBuilder.append(", id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public int type(ITypeFactoryList paramITypeFactoryList) {
        return paramITypeFactoryList.type((BeanType) this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

}
