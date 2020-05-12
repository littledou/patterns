package im.juejin.android.base.model;

import com.alibaba.fastjson.annotation.JSONField;

import im.juejin.android.componentbase.model.UserBean;

public class AdBean {
    public class UserWrap {
        public String id;
        public String title;
        public UserBean user;
    }

    public static final int POSITION_FIRST = 2;
    public static final int POSITION_FOURTH = 3;
    @JSONField(name = "abstract")
    public String abstractStr;
    public String endedAt;
    public Object entry;
    public String id;
    public String imageUrl;
    public Object pin;
    public int platformCode;
    public int positionCode;
    public String startedAt;
    public String title;
    public String type;
    public String url;
    public UserWrap userWrap;

    public AdBean() {
        super();
    }

    public String getAbstract() {
        return this.abstractStr;
    }

    public String getEndedAt() {
        return this.endedAt;
    }

    public Object getEntry() {
        return this.entry;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Object getPin() {
        return this.pin;
    }

    public int getPlatformCode() {
        return this.platformCode;
    }

    public int getPositionCode() {
        return this.positionCode;
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

    public String getUrl() {
        return this.url;
    }

    public void setAbstract(String arg1) {
        this.abstractStr = arg1;
    }

    public void setEndedAt(String arg1) {
        this.endedAt = arg1;
    }

    public void setEntry(Object arg1) {
        this.entry = arg1;
    }

    public void setId(String arg1) {
        this.id = arg1;
    }

    public void setImageUrl(String arg1) {
        this.imageUrl = arg1;
    }

    public void setPin(Object arg1) {
        this.pin = arg1;
    }

    public void setPlatformCode(int arg1) {
        this.platformCode = arg1;
    }

    public void setPositionCode(int arg1) {
        this.positionCode = arg1;
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

    public void setUrl(String arg1) {
        this.url = arg1;
    }

    public String toString() {
        return "AdBean{type=\'" + this.type + '\'' + ", id=\'" + this.id + '\'' + ", url=\'" + this.url + '\'' + ", startedAt=\'" + this.startedAt + '\'' + ", endedAt=\'" + this.endedAt + '\'' + ", platformCode=" + this.platformCode + ", positionCode=" + this.positionCode + ", entry=" + this.entry + ", pin=" + this.pin + ", userWrap=" + this.userWrap + ", imageUrl=\'" + this.imageUrl + '\'' + ", title=\'" + this.title + '\'' + ", abstractStr=\'" + this.abstractStr + '\'' + '}';
    }
}
