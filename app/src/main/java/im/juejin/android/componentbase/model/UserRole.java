package im.juejin.android.componentbase.model;

import com.alibaba.fastjson.annotation.JSONField;

public class UserRole {
    @JSONField(name = "isGranted")
    boolean isGranted;

    public UserRole() {
        super();
        this.isGranted = false;
    }

    public boolean granted() {
        return this.isGranted;
    }

    public void setGranted(boolean arg1) {
        this.isGranted = arg1;
    }
}
