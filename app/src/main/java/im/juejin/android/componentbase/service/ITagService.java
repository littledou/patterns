package im.juejin.android.componentbase.service;

import com.alibaba.android.arouter.facade.template.IProvider;

import java.util.List;

public interface ITagService extends IProvider {
    boolean mergeLocalTags(List arg1) throws Exception;
}