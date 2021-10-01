package Controller;

import dao.CollectDao;
import io.javalin.http.Handler;
import model.Collect;

import static util.RequestUtil.getCollectPost;

public class CollectController {
    public static Handler handlerCollectPost = ctx -> {
        Collect collect = getCollectPost(ctx);
        CollectDao.collect(collect);
    };

    public static Handler handlerUnCollectPost = ctx -> {
        Collect collect = getCollectPost(ctx);
        CollectDao.uncollect(collect);
    };
}