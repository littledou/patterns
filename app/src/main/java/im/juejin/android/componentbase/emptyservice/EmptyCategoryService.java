package im.juejin.android.componentbase.emptyservice;

import android.content.Context;

import java.util.List;

import im.juejin.android.componentbase.service.ICategoryService;

public class EmptyCategoryService implements ICategoryService {
    public EmptyCategoryService() {
        super();
    }

    public List getCategoryList() throws Exception {
        return null;
    }

    public void init(Context arg1) {
    }
}
