package im.juejin.android.componentbase.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class UserBean implements Parcelable, BeanType {

    public class CommunityBean {
        public class ThirdPartBean {
            private String access_token;
            private String avatarLarge;
            private String blogAddress;
            private String expiration_in;
            private String openid;
            private String username;

            public ThirdPartBean() {
                super();
            }

            public String getAccess_token() {
                return this.access_token;
            }

            public String getAvatarLarge() {
                return this.avatarLarge;
            }

            public String getBlogAddress() {
                return this.blogAddress;
            }

            public String getExpiration_in() {
                return this.expiration_in;
            }

            public String getOpenid() {
                return this.openid;
            }

            public String getUsername() {
                return this.username;
            }

            public void setAccess_token(String arg1) {
                this.access_token = arg1;
            }

            public void setAvatarLarge(String arg1) {
                this.avatarLarge = arg1;
            }

            public ThirdPartBean setBlogAddress(String arg1) {
                this.blogAddress = arg1;
                return this;
            }

            public void setExpiration_in(String arg1) {
                this.expiration_in = arg1;
            }

            public void setOpenid(String arg1) {
                this.openid = arg1;
            }

            public void setUsername(String arg1) {
                this.username = arg1;
            }
        }

        private ThirdPartBean github;
        private ThirdPartBean wechat;
        private ThirdPartBean weibo;

        public CommunityBean() {
            super();
        }

        public ThirdPartBean getGithub() {
            return this.github;
        }

        public ThirdPartBean getWechat() {
            return this.wechat;
        }

        public ThirdPartBean getWeibo() {
            return this.weibo;
        }

        public CommunityBean setGithub(ThirdPartBean arg1) {
            this.github = arg1;
            return this;
        }

        public void setWechat(ThirdPartBean arg1) {
            this.wechat = arg1;
        }

        public CommunityBean setWeibo(ThirdPartBean arg1) {
            this.weibo = arg1;
            return this;
        }
    }

    public class UserRoles {
        UserRole administratorAuthor;
        UserRole bookAuthor;
        UserRole builderAuthor;
        UserRole favorableAuthor;

        public UserRole getAdministratorAuthor() {
            return this.administratorAuthor;
        }

        public UserRole getBookAuthor() {
            return this.bookAuthor;
        }

        public UserRole getBuilderAuthor() {
            return this.builderAuthor;
        }

        public UserRole getFavorableAuthor() {
            return this.favorableAuthor;
        }

        public void setAdministratorAuthor(UserRole arg1) {
            this.administratorAuthor = arg1;
        }

        public void setBookAuthor(UserRole arg1) {
            this.bookAuthor = arg1;
        }

        public void setBuilderAuthor(UserRole arg1) {
            this.builderAuthor = arg1;
        }

        public void setFavorableAuthor(UserRole arg1) {
            this.favorableAuthor = arg1;
        }
    }

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
        super();
    }

    protected UserBean(Parcel arg7) {
        super();
        long v0 = arg7.readLong();
        Date v2 = null;
        long v3 = -1;
        Date v5 = v0 == v3 ? v2 : new Date(v0);
        this.updatedAt = v5;
        v0 = arg7.readLong();
        if (v0 == v3) {
        } else {
            v2 = new Date(v0);
        }

        this.createdAt = v2;
        this.username = arg7.readString();
        this.avatar_hd = arg7.readString();
        this.objectId = arg7.readString();
        this.role = arg7.readString();
        this.company = arg7.readString();
        this.jobTitle = arg7.readString();
        this.self_description = arg7.readString();
        boolean v1 = true;
        boolean v0_1 = arg7.readByte() != 0 ? true : false;
        this.isFollowerFollowed = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.currentUserFollowed = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.viewerIsFollowing = v0_1;
        this.avatar_large = arg7.readString();
        this.avatarLarge = arg7.readString();
        this.totalCollectionsCount = arg7.readInt();
        this.totalCommentsCount = arg7.readInt();
        this.viewedEntriesCount = arg7.readInt();
        this.postedEntriesCount = arg7.readInt();
        this.postedPostsCount = arg7.readInt();
        this.collectedEntriesCount = arg7.readInt();
        this.subscribedTagsCount = arg7.readInt();
        this.collectionSetCount = arg7.readInt();
        this.likedPinCount = arg7.readInt();
        this.followeesCount = arg7.readInt();
        this.followersCount = arg7.readInt();
        this.tagFollowCount = arg7.readInt();
        this.totalViewsCount = arg7.readInt();
        this.pinCount = arg7.readInt();
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.isUnitedAuthor = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.isAuthor = v0_1;
        this.blogAddress = arg7.readString();
        this.mobilePhoneNumber = arg7.readString();
        this.email = arg7.readString();
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.isSelect = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.selectAll = v0_1;
        this.tagName = arg7.readString();
        this.id = arg7.readString();
        this.level = arg7.readInt();
        if (arg7.readByte() != 0) {
        } else {
            v1 = false;
        }

        this.mobilePhoneVerified = v1;
        this.statisticCategory = arg7.readString();
        this.statisticLocation = arg7.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public String getAvatarLarge() {
        if (!TextUtils.isEmpty(this.avatar_large)) {
            return this.avatar_large;
        }

        return this.avatarLarge;
    }

    @Deprecated
    public String getAvatar_hd() {
        if (TextUtils.isEmpty(this.avatar_hd)) {
            return this.getAvatarLarge();
        }

        return this.avatar_hd;
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
        if (TextUtils.isEmpty(this.id)) {
            return this.objectId;
        }

        return this.id;
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
        if (TextUtils.isEmpty(this.objectId)) {
            return this.id;
        }

        return this.objectId;
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
        boolean v0 = (this.viewerIsFollowing) || (this.isFollowerFollowed) || (this.currentUserFollowed) ? true : false;
        return v0;
    }

    public boolean isViewerIsFollowing() {
        return this.viewerIsFollowing;
    }

    public void setAvatarLarge(String arg1) {
        this.avatarLarge = arg1;
        this.avatar_large = arg1;
    }

    public void setAvatar_hd(String arg1) {
        this.avatar_hd = arg1;
    }

    public void setAvatar_large(String arg1) {
        this.avatar_large = arg1;
        this.avatarLarge = arg1;
    }

    public void setBlogAddress(String arg1) {
        this.blogAddress = arg1;
    }

    public void setCollectedEntriesCount(int arg1) {
        this.collectedEntriesCount = arg1;
    }

    public UserBean setCollectionSetCount(int arg1) {
        this.collectionSetCount = arg1;
        return this;
    }

    public UserBean setCommunity(CommunityBean arg1) {
        this.community = arg1;
        return this;
    }

    public void setCompany(String arg1) {
        this.company = arg1;
    }

    public void setCreatedAt(Date arg1) {
        this.createdAt = arg1;
    }

    public void setCurrentUserFollowed(boolean arg1) {
        this.isFollowerFollowed = arg1;
        this.currentUserFollowed = arg1;
    }

    public void setEmail(String arg1) {
        this.email = arg1;
    }

    public void setField(String tag, String msg) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }

        switch (tag) {
            case "avatarLarge": {
                this.setAvatarLarge(msg);
                break;
            }
            case "username": {
                this.setUsername(msg);
                break;
            }
            case "jobTitle": {
                this.setJobTitle(msg);
                break;
            }
            case "company": {
                this.setCompany(msg);
                break;
            }
            case "blogAddress": {
                this.setBlogAddress(msg);
                break;
            }
            case "selfDescription": {
                this.setSelf_description(msg);
                break;
            }
            case "avatar_large": {
                this.setAvatar_large(msg);
                break;
            }
            case "mobilePhoneNumber": {
                this.setMobilePhoneNumber(msg);
                break;
            }
            case "email": {
                this.setEmail(msg);
                break;
            }
            default: {
                break;
            }
        }
    }

    public void setFolloweesCount(int arg1) {
        this.followeesCount = arg1;
    }

    public void setFollowerFollowed(boolean arg1) {
        this.isFollowerFollowed = arg1;
        this.currentUserFollowed = arg1;
    }

    public void setFollowersCount(int arg1) {
        this.followersCount = arg1;
    }

    public void setId(String arg1) {
        this.id = arg1;
    }

    public void setJobTitle(String arg1) {
        this.jobTitle = arg1;
    }

    public void setJuejinPower(int arg1) {
        this.juejinPower = arg1;
    }

    public void setLevel(int arg1) {
        this.level = arg1;
    }

    public void setLikedPinCount(int arg1) {
        this.likedPinCount = arg1;
    }

    public void setMobilePhoneNumber(String arg1) {
        this.mobilePhoneNumber = arg1;
    }

    public void setMobilePhoneVerified(boolean arg1) {
        this.mobilePhoneVerified = arg1;
    }

    public void setObjectId(String arg1) {
        this.objectId = arg1;
    }

    public void setPinCount(int arg1) {
        this.pinCount = arg1;
    }

    public void setPostedEntriesCount(int arg1) {
        this.postedEntriesCount = arg1;
    }

    public UserBean setPostedPostsCount(int arg1) {
        this.postedPostsCount = arg1;
        return this;
    }

    public void setPurchasedBookletCount(int arg1) {
        this.purchasedBookletCount = arg1;
    }

    public void setRole(String arg1) {
        this.role = arg1;
    }

    public void setRoles(UserRoles arg1) {
        this.roles = arg1;
    }

    public void setSelect(boolean arg1) {
        this.isSelect = arg1;
    }

    public void setSelectAll(boolean arg1) {
        this.selectAll = arg1;
    }

    public void setSelf_description(String arg1) {
        this.self_description = arg1;
    }

    public void setStatisticCategory(String arg1) {
        this.statisticCategory = arg1;
    }

    public void setStatisticLocation(String arg1) {
        this.statisticLocation = arg1;
    }

    public void setSubscribedTagsCount(int arg1) {
        this.subscribedTagsCount = arg1;
    }

    public void setTagFollowCount(int arg1) {
        this.tagFollowCount = arg1;
    }

    public void setTagName(String arg1) {
        this.tagName = arg1;
    }

    public UserBean setTotalCollectionsCount(int arg1) {
        this.totalCollectionsCount = arg1;
        return this;
    }

    public UserBean setTotalCommentsCount(int arg1) {
        this.totalCommentsCount = arg1;
        return this;
    }

    public void setTotalViewsCount(int arg1) {
        this.totalViewsCount = arg1;
    }

    public void setUpdatedAt(Date arg1) {
        this.updatedAt = arg1;
    }

    public void setUsername(String arg1) {
        this.username = arg1;
    }

    public UserBean setViewedEntriesCount(int arg1) {
        this.viewedEntriesCount = arg1;
        return this;
    }

    public void setViewerIsFollowing(boolean arg1) {
        this.viewerIsFollowing = arg1;
    }

    public String toString() {
        return "UserBean{, username=\'" + this.username + '\'' + ", avatar_hd=\'" + this.avatar_hd + '\'' + ", objectId=\'" + this.objectId + '\'' + ", company=\'" + this.company + '\'' + ", jobTitle=\'" + this.jobTitle + '\'' + ", self_description=\'" + this.self_description + '\'' + ", totalCollectionsCount=" + this.totalCollectionsCount + ", totalCommentsCount=" + this.totalCommentsCount + ", viewedEntriesCount=" + this.viewedEntriesCount + ", postedEntriesCount=" + this.postedEntriesCount + ", postedPostsCount=" + this.postedPostsCount + ", collectedEntriesCount=" + this.collectedEntriesCount + ", subscribedTagsCount=" + this.subscribedTagsCount + ", collectionSetCount=" + this.collectionSetCount + ", followeesCount=" + this.followeesCount + ", followersCount=" + this.followersCount + ", tagFollowCount=" + this.tagFollowCount + ", totalViewsCount=" + this.totalViewsCount + ", likedPinCount=" + this.likedPinCount + ", pinCount=" + this.pinCount + ", isUnitedAuthor=" + this.isUnitedAuthor + ", isAuthor=" + this.isAuthor + ", blogAddress=\'" + this.blogAddress + '\'' + ", mobilePhoneNumber=\'" + this.mobilePhoneNumber + '\'' + ", email=\'" + this.email + '\'' + ", community=" + this.community + ", id=\'" + this.id + '\'' + '}';
    }

    public int type(ITypeFactoryList arg1) {
        return arg1.type(((BeanType) this));
    }

    public void writeToParcel(Parcel arg5, int arg6) {
        Date v6 = this.updatedAt;
        long v0 = -1;
        long v2 = v6 != null ? v6.getTime() : v0;
        arg5.writeLong(v2);
        v6 = this.createdAt;
        if (v6 != null) {
            v0 = v6.getTime();
        }

        arg5.writeLong(v0);
        arg5.writeString(this.username);
        arg5.writeString(this.avatar_hd);
        arg5.writeString(this.objectId);
        arg5.writeString(this.role);
        arg5.writeString(this.company);
        arg5.writeString(this.jobTitle);
        arg5.writeString(this.self_description);
        arg5.writeBoolean(this.isFollowerFollowed);
        arg5.writeBoolean(this.currentUserFollowed);
        arg5.writeBoolean(this.viewerIsFollowing);
        arg5.writeString(this.avatar_large);
        arg5.writeString(this.avatarLarge);
        arg5.writeInt(this.totalCollectionsCount);
        arg5.writeInt(this.totalCommentsCount);
        arg5.writeInt(this.viewedEntriesCount);
        arg5.writeInt(this.postedEntriesCount);
        arg5.writeInt(this.postedPostsCount);
        arg5.writeInt(this.collectedEntriesCount);
        arg5.writeInt(this.subscribedTagsCount);
        arg5.writeInt(this.collectionSetCount);
        arg5.writeInt(this.likedPinCount);
        arg5.writeInt(this.followeesCount);
        arg5.writeInt(this.followersCount);
        arg5.writeInt(this.tagFollowCount);
        arg5.writeInt(this.totalViewsCount);
        arg5.writeInt(this.pinCount);
        arg5.writeBoolean(this.isUnitedAuthor);
        arg5.writeBoolean(this.isAuthor);
        arg5.writeString(this.blogAddress);
        arg5.writeString(this.mobilePhoneNumber);
        arg5.writeString(this.email);
        arg5.writeBoolean(this.isSelect);
        arg5.writeBoolean(this.selectAll);
        arg5.writeString(this.tagName);
        arg5.writeString(this.id);
        arg5.writeInt(this.level);
        arg5.writeBoolean(this.mobilePhoneVerified);
        arg5.writeString(this.statisticCategory);
        arg5.writeString(this.statisticLocation);
    }
}