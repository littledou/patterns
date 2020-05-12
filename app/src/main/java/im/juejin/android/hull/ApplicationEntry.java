package im.juejin.android.hull;

import com.tencent.tinker.loader.app.TinkerApplication;

public class ApplicationEntry extends TinkerApplication {

    public ApplicationEntry() {
        super(7, "im.juejin.android.hull.GoldApplicationLike", "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
