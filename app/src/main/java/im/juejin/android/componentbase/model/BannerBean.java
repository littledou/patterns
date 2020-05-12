package im.juejin.android.componentbase.model;

import android.os.Parcel;
import android.os.Parcelable;

import im.juejin.android.componentbase.typefactory.ITypeFactoryList;

public class BannerBean implements Parcelable, BeanType {

    public static final Creator<BannerBean> CREATOR = new Creator<BannerBean>() {
        @Override
        public BannerBean createFromParcel(Parcel in) {
            return new BannerBean(in);
        }

        @Override
        public BannerBean[] newArray(int size) {
            return new BannerBean[size];
        }
    };

    public static final String TYPE_ENTRY = "entry";
    public static final String TYPE_PIN = "pin";
    public static final String TYPE_TOPIC = "topic";
    public static final String TYPE_URL = "url";
    public static final String TYPE_VOTE = "vote";
    private String createdAt;
    private String description;
    private String endedAt;
    private String objectId;
    private String osTime;
    private String platform;
    private String position;
    private String relatedObjectId;
    private String screenshot;
    private String startedAt;
    private String title;
    private String type;
    private String updatedAt;
    private String url;


    public BannerBean() {
        super();
    }

    protected BannerBean(Parcel arg2) {
        super();
        this.objectId = arg2.readString();
        this.description = arg2.readString();
        this.startedAt = arg2.readString();
        this.type = arg2.readString();
        this.title = arg2.readString();
        this.relatedObjectId = arg2.readString();
        this.url = arg2.readString();
        this.position = arg2.readString();
        this.screenshot = arg2.readString();
        this.platform = arg2.readString();
        this.endedAt = arg2.readString();
        this.createdAt = arg2.readString();
        this.updatedAt = arg2.readString();
    }


    public int describeContents() {
        return 0;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEndedAt() {
        return this.endedAt;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getOsTime() {
        return this.osTime;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPosition() {
        return this.position;
    }

    public String getRelatedObjectId() {
        return this.relatedObjectId;
    }

    public String getScreenshot() {
        return this.screenshot;
    }

    public String getStartedAt() {
        return this.startedAt;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCreatedAt(String arg1) {
        this.createdAt = arg1;
    }

    public void setDescription(String arg1) {
        this.description = arg1;
    }

    public void setEndedAt(String arg1) {
        this.endedAt = arg1;
    }

    public void setObjectId(String arg1) {
        this.objectId = arg1;
    }

    public void setOsTime(String arg1) {
        this.osTime = arg1;
    }

    public void setPlatform(String arg1) {
        this.platform = arg1;
    }

    public void setPosition(String arg1) {
        this.position = arg1;
    }

    public void setRelatedObjectId(String arg1) {
        this.relatedObjectId = arg1;
    }

    public void setScreenshot(String arg1) {
        this.screenshot = arg1;
    }

    public void setStartedAt(String arg1) {
        this.startedAt = arg1;
    }

    public void setTitle(String arg1) {
        this.title = arg1;
    }

    public void setType(String arg1) {
        this.type = arg1;
    }

    public void setUpdatedAt(String arg1) {
        this.updatedAt = arg1;
    }

    public void setUrl(String arg1) {
        this.url = arg1;
    }

    public String toString() {
        return "BannerBean{objectId=\'" + this.objectId + '\'' + ", description=\'" + this.description + '\'' + ", startedAt=\'" + this.startedAt + '\'' + ", type=\'" + this.type + '\'' + ", title=\'" + this.title + '\'' + ", relatedObjectId=\'" + this.relatedObjectId + '\'' + ", url=\'" + this.url + '\'' + ", position=\'" + this.position + '\'' + ", screenshot=\'" + this.screenshot + '\'' + ", platform=\'" + this.platform + '\'' + ", endedAt=\'" + this.endedAt + '\'' + ", createdAt=\'" + this.createdAt + '\'' + ", updatedAt=\'" + this.updatedAt + '\'' + '}';
    }

    public int type(ITypeFactoryList arg1) {
        return arg1.type(((BeanType) this));
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeString(this.objectId);
        arg1.writeString(this.description);
        arg1.writeString(this.startedAt);
        arg1.writeString(this.type);
        arg1.writeString(this.title);
        arg1.writeString(this.relatedObjectId);
        arg1.writeString(this.url);
        arg1.writeString(this.position);
        arg1.writeString(this.screenshot);
        arg1.writeString(this.platform);
        arg1.writeString(this.endedAt);
        arg1.writeString(this.createdAt);
        arg1.writeString(this.updatedAt);
    }
}