package im.juejin.android.componentbase.service;

import com.alibaba.android.arouter.facade.template.IProvider;

import java.util.List;

public interface ICategoryService extends IProvider {
    List getCategoryList() throws Exception;
}
