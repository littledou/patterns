package cn.readsense.pattern.thread;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();

    public void add() {
        list.add("name");
    }

    public int size() {
        return list.size();
    }
}
