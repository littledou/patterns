package im.juejin.android.base.events;

import im.juejin.android.base.model.CommentBean;

public class AddCommentMessage {
    public CommentBean mCommentBean;

    private AddCommentMessage(CommentBean arg1) {
        super();
        this.mCommentBean = arg1;
    }

    public static AddCommentMessage build(CommentBean arg1) {
        return new AddCommentMessage(arg1);
    }
}