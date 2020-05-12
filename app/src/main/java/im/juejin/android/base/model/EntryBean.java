package im.juejin.android.base.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

import im.juejin.android.base.utils.TextUtil;
import im.juejin.android.base.utils.TimeUtils;
import im.juejin.android.common.ApplicationProvider;
import im.juejin.android.common.util.ScreenUtil;
import im.juejin.android.componentbase.model.BeanID;
import im.juejin.android.componentbase.model.BeanType;
import im.juejin.android.componentbase.model.CategoryBean;
import im.juejin.android.componentbase.model.UserBean;
import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class EntryBean implements Parcelable, BeanID, BeanType {

    public static final String TYPE_BANNER = "banner";
    public static final String TYPE_ENTRY = "entry";
    public static final String TYPE_FACTORY_RECOMMEND_USER = "type_recommend_user";
    public static final String TYPE_POST = "post";
    public static final String TYPE_VOTE = "vote";
    private String adId;
    private int attenders;
    private CategoryBean category;
    @JSONField(name="isCollected") @Deprecated private boolean collected;
    @Deprecated private int collectionCount;
    private int commentsCount;
    private String content;
    private boolean couldShowAll;
    private Date createdAt;
    private String createdAtString;
    private boolean english;
    private EventBean eventInfo;
    private boolean gfw;
    private boolean hasDetectContentLength;
    private boolean hasRead;
    private boolean hot;
    private String hotIndex;
    private String id;
    @JSONField(name="isEvent") private boolean isEvent;
    private int likeCount;
    private int lineCount;
    @Deprecated private String objectId;
    private boolean original;
    private String originalUrl;
    private int positionCode;
    private float rankIndex;
    private String screenshot;
    private boolean showAllContent;
    private boolean showFollowIfNeed;
    private String statisticCategory;
    private String statisticKey;
    private int subscribersCount;
    private String summaryInfo;
    private List tags;
    private String title;
    private String type;
    private String typeFactory;
    private Date updatedAt;
    private String updatedAtString;
    private String url;
    private UserBean user;
    private boolean viewerHasCollected;
    private boolean viewerHasLiked;
    private int viewsCount;

    public EntryBean() {
        super();
        this.attenders = -1;
        this.typeFactory = "";
        this.statisticKey = "";
        this.statisticCategory = "";
    }

    protected EntryBean(Parcel arg7) {
        super();
        this.attenders = -1;
        this.typeFactory = "";
        this.statisticKey = "";
        this.statisticCategory = "";
        long v0 = arg7.readLong();
        Date v2 = null;
        long v3 = -1;
        Date v5 = v0 == v3 ? v2 : new Date(v0);
        this.updatedAt = v5;
        v0 = arg7.readLong();
        if(v0 == v3) {
        }
        else {
            v2 = new Date(v0);
        }

        this.createdAt = v2;
        this.id = arg7.readString();
        this.objectId = arg7.readString();
        this.originalUrl = arg7.readString();
        this.screenshot = arg7.readString();
        this.updatedAtString = arg7.readString();
        this.createdAtString = arg7.readString();
        this.type = arg7.readString();
        this.url = arg7.readString();
        this.title = arg7.readString();
        this.hotIndex = arg7.readString();
        this.statisticKey = arg7.readString();
        this.statisticCategory = arg7.readString();
        this.content = arg7.readString();
        this.collectionCount = arg7.readInt();
        this.likeCount = arg7.readInt();
        this.commentsCount = arg7.readInt();
        this.viewsCount = arg7.readInt();
        this.subscribersCount = arg7.readInt();
        this.rankIndex = arg7.readFloat();
        boolean v1 = true;
        boolean v0_1 = arg7.readByte() != 0 ? true : false;
        this.collected = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.viewerHasLiked = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.viewerHasCollected = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.hot = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.original = v0_1;
        v0_1 = arg7.readByte() != 0 ? true : false;
        this.english = v0_1;
        if(arg7.readByte() != 0) {
        }
        else {
            v1 = false;
        }

        this.gfw = v1;
        this.category = arg7.readParcelable(CategoryBean.class.getClassLoader());
        this.tags = arg7.createTypedArrayList(TagBean.CREATOR);
        this.user = arg7.readParcelable(UserBean.class.getClassLoader());
        this.adId = arg7.readString();
        this.typeFactory = arg7.readString();
    }

    public void couldShowAll(boolean arg1) {
        this.couldShowAll = arg1;
    }

    public boolean couldShowAllContent() {
        return this.couldShowAll;
    }

    public int describeContents() {
        return 0;
    }

    public String getAdId() {
        return this.adId;
    }

    public int getAttenders() {
        return this.attenders;
    }

    public String getBeanId() {
        return this.getObjectId();
    }

    public CategoryBean getCategory() {
        return this.category;
    }

    public int getCollectionCount() {
        int v0 = this.likeCount;
        if(v0 != 0) {
            return v0;
        }

        return this.collectionCount;
    }

    public int getCommentsCount() {
        return this.commentsCount;
    }

    public String getContent() {
        String v0 = this.content;
        if(v0 == null) {
            v0 = "";
        }

        return v0;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getCreatedAtString() {
        String v0 = TextUtil.isEmpty(this.createdAtString) ? TimeUtils.getUTC(this.createdAt) : this.createdAtString;
        return v0;
    }

    public EventBean getEventInfo() {
        return this.eventInfo;
    }

    public String getHotIndex() {
        return this.hotIndex;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public String getObjectId() {
        if(!TextUtils.isEmpty(this.id)) {
            return this.id;
        }

        return this.objectId;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public int getPositionCode() {
        return this.positionCode;
    }

    public float getRankIndex() {
        return this.rankIndex;
    }

    public String getScreenshot() {
        return this.screenshot;
    }

    public String getScreenshot(boolean arg7) {
        if(!this.hasScreenshot()) {
            return "";
        }

        if(arg7) {
            return ImageUtils.getThumbnailUrl(this.screenshot, true, ScreenUtil.getScreenWidth(), ((int) ApplicationProvider.getApplication().getResources().getDimension(dimen.screenshot_height)), 80, "webp");
        }

        return ImageUtils.getThumbnailUrl(this.screenshot, true, ScreenUtil.dip2px(80f), ScreenUtil.dip2px(80f), 80, "webp");
    }

    public String getStatisticCategory() {
        return this.statisticCategory;
    }

    public String getStatisticKey() {
        String v0 = TextUtil.isEmpty(this.statisticKey) ? "" : this.statisticKey;
        return v0;
    }

    public int getSubscribersCount() {
        return this.subscribersCount;
    }

    public String getSummaryInfo() {
        String v0 = this.summaryInfo;
        if(v0 == null) {
            v0 = "";
        }

        return v0;
    }

    public List getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeFactory() {
        return this.typeFactory;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUpdatedAtString() {
        String v0 = TextUtil.isEmpty(this.updatedAtString) ? TimeUtils.getUTC(this.updatedAt) : this.updatedAtString;
        return v0;
    }

    public String getUrl() {
        if(TextUtil.isEmpty(this.url)) {
            return "https://juejin.im/entry/" + this.getObjectId();
        }

        return this.url;
    }

    public UserBean getUser() {
        return this.user;
    }

    public int getViewsCount() {
        return this.viewsCount;
    }

    public boolean hasRead() {
        return this.hasRead;
    }

    public boolean hasScreenshot() {
        return TextUtil.isEmpty(this.getScreenshot()) ^ 1;
    }

    public boolean hasViewerCollected() {
        return this.viewerHasCollected;
    }

    public boolean isAD() {
        return TextUtil.isEmpty(this.adId) ^ 1;
    }

    public boolean isCollected() {
        if(this.viewerHasLiked) {
            return 1;
        }

        return this.collected;
    }

    public boolean isEnglish() {
        return this.english;
    }

    public boolean isEvent() {
        return this.isEvent;
    }

    public boolean isGfw() {
        return this.gfw;
    }

    public boolean isHasDetectContentLength() {
        return this.hasDetectContentLength;
    }

    public boolean isHot() {
        return this.hot;
    }

    public boolean isOriginal() {
        return this.original;
    }

    public void setAD(String arg1) {
        this.adId = arg1;
    }

    public void setAttenders(int arg1) {
        this.attenders = arg1;
    }

    public void setCategory(CategoryBean arg1) {
        this.category = arg1;
    }

    public void setCollected(boolean arg1) {
        this.viewerHasLiked = arg1;
        this.collected = arg1;
    }

    public void setCollectionCount(int arg1) {
        this.likeCount = arg1;
        this.collectionCount = arg1;
    }

    public void setCommentsCount(int arg1) {
        this.commentsCount = arg1;
    }

    public void setContent(String arg1) {
        this.content = arg1;
    }

    public void setCreatedAt(Date arg1) {
        this.createdAt = arg1;
    }

    public void setCreatedAtString(String arg1) {
        this.createdAtString = arg1;
    }

    public void setEnglish(boolean arg1) {
        this.english = arg1;
    }

    public void setEvent(boolean arg1) {
        this.isEvent = arg1;
    }

    public void setEventInfo(EventBean arg1) {
        this.eventInfo = arg1;
    }

    public void setGfw(boolean arg1) {
        this.gfw = arg1;
    }

    public void setHasDetectContentLength(boolean arg1) {
        this.hasDetectContentLength = arg1;
    }

    public void setHasRead(boolean arg1) {
        this.hasRead = arg1;
    }

    public void setHot(boolean arg1) {
        this.hot = arg1;
    }

    public void setHotIndex(String arg1) {
        this.hotIndex = arg1;
    }

    public void setId(String arg1) {
        this.id = arg1;
    }

    public void setLikeCount(int arg1) {
        this.likeCount = arg1;
    }

    public void setLineCount(int arg1) {
        this.lineCount = arg1;
    }

    public void setObjectId(String arg1) {
        this.objectId = arg1;
    }

    public void setOriginal(boolean arg1) {
        this.original = arg1;
    }

    public void setOriginalUrl(String arg1) {
        this.originalUrl = arg1;
    }

    public void setPositionCode(int arg1) {
        this.positionCode = arg1;
    }

    public void setRankIndex(float arg1) {
        this.rankIndex = arg1;
    }

    public void setScreenshot(String arg1) {
        this.screenshot = arg1;
    }

    public void setShowAllContent(boolean arg1) {
        this.showAllContent = arg1;
    }

    public void setShowFollowIfNeed(boolean arg1) {
        this.showFollowIfNeed = arg1;
    }

    public void setStatisticCategory(String arg1) {
        this.statisticCategory = arg1;
    }

    public void setStatisticKey(String arg1) {
        this.statisticKey = arg1;
    }

    public void setSubscribersCount(int arg1) {
        this.subscribersCount = arg1;
    }

    public void setSummaryInfo(String arg1) {
        this.summaryInfo = arg1;
    }

    public void setTags(List arg1) {
        this.tags = arg1;
    }

    public void setTitle(String arg1) {
        this.title = arg1;
    }

    public void setType(String arg1) {
        this.type = arg1;
    }

    public void setTypeFactory(String arg1) {
        this.typeFactory = arg1;
    }

    public void setUpdatedAt(Date arg1) {
        this.updatedAt = arg1;
    }

    public void setUpdatedAtString(String arg1) {
        this.updatedAtString = arg1;
    }

    public void setUrl(String arg1) {
        this.url = arg1;
    }

    public void setUser(UserBean arg1) {
        this.user = arg1;
    }

    public void setViewerHasCollected(boolean arg1) {
        this.viewerHasCollected = arg1;
    }

    public void setViewerHasLiked(boolean arg1) {
        this.viewerHasLiked = arg1;
    }

    public void setViewsCount(int arg1) {
        this.viewsCount = arg1;
    }

    public boolean showAllContent() {
        return this.showAllContent;
    }

    public boolean showFollowIfNeed() {
        return this.showFollowIfNeed;
    }

    public String toString() {
        return "EntryBean{id=\'" + this.id + '\'' + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + ", objectId=\'" + this.objectId + '\'' + ", originalUrl=\'" + this.originalUrl + '\'' + ", screenshot=\'" + this.screenshot + '\'' + ", updatedAtString=\'" + this.updatedAtString + '\'' + ", createdAtString=\'" + this.createdAtString + '\'' + ", type=\'" + this.type + '\'' + ", url=\'" + this.url + '\'' + ", title=\'" + this.title + '\'' + ", content=\'" + this.content + '\'' + ", summaryInfo=\'" + this.summaryInfo + '\'' + ", hotIndex=\'" + this.hotIndex + '\'' + ", collectionCount=" + this.collectionCount + ", likeCount=" + this.likeCount + ", commentsCount=" + this.commentsCount + ", viewsCount=" + this.viewsCount + ", subscribersCount=" + this.subscribersCount + ", rankIndex=" + this.rankIndex + ", collected=" + this.collected + ", viewerHasLiked=" + this.viewerHasLiked + ", viewerHasCollected=" + this.viewerHasCollected + ", hot=" + this.hot + ", original=" + this.original + ", english=" + this.english + ", gfw=" + this.gfw + ", category=" + this.category + ", tags=" + this.tags + ", user=" + this.user + ", lineCount=" + this.lineCount + ", eventInfo=" + this.eventInfo + ", isEvent=" + this.isEvent + ", showAllContent=" + this.showAllContent + ", adId=\'" + this.adId + '\'' + ", hasRead=" + this.hasRead + ", hasDetectContentLength=" + this.hasDetectContentLength + ", couldShowAll=" + this.couldShowAll + ", attenders=" + this.attenders + ", showFollowIfNeed=" + this.showFollowIfNeed + ", typeFactory=\'" + this.typeFactory + '\'' + ", statisticKey=\'" + this.statisticKey + '\'' + ", statisticCategory=\'" + this.statisticCategory + '\'' + '}';
    }

    public int type(ITypeFactoryList arg1) {
        return arg1.type(((BeanType)this));
    }

    public void writeToParcel(Parcel arg6, int arg7) {
        Date v0 = this.updatedAt;
        long v1 = -1;
        long v3 = v0 != null ? v0.getTime() : v1;
        arg6.writeLong(v3);
        v0 = this.createdAt;
        if(v0 != null) {
            v1 = v0.getTime();
        }

        arg6.writeLong(v1);
        arg6.writeString(this.id);
        arg6.writeString(this.objectId);
        arg6.writeString(this.originalUrl);
        arg6.writeString(this.screenshot);
        arg6.writeString(this.updatedAtString);
        arg6.writeString(this.createdAtString);
        arg6.writeString(this.type);
        arg6.writeString(this.url);
        arg6.writeString(this.title);
        arg6.writeString(this.hotIndex);
        arg6.writeString(this.statisticKey);
        arg6.writeString(this.statisticCategory);
        arg6.writeString(this.content);
        arg6.writeInt(this.collectionCount);
        arg6.writeInt(this.likeCount);
        arg6.writeInt(this.commentsCount);
        arg6.writeInt(this.viewsCount);
        arg6.writeInt(this.subscribersCount);
        arg6.writeFloat(this.rankIndex);
        arg6.writeBoolean(this.collected);
        arg6.writeBoolean(this.viewerHasLiked);
        arg6.writeBoolean(this.viewerHasCollected);
        arg6.writeBoolean(this.hot);
        arg6.writeBoolean(this.original);
        arg6.writeBoolean(this.english);
        arg6.writeBoolean(this.gfw);
        arg6.writeParcelable(this.category, arg7);
        arg6.writeTypedList(this.tags);
        arg6.writeParcelable(this.user, arg7);
        arg6.writeString(this.adId);
        arg6.writeString(this.typeFactory);
    }
}