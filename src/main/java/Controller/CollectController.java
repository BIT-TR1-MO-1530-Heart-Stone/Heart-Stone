package Controller;

import dao.CollectDao;
import io.javalin.http.Handler;
import model.Collect;
import util.Path;

import static util.RequestUtil.getCollectPost;

public class CollectController {
    public static Handler handlerCollectPost = ctx -> {
        Collect collect = getCollectPost(ctx);
        CollectDao.collect(collect);
        ctx.redirect(Path.Web.QUERYALLPOSTNOW);
    };

    public static Handler handlerUnCollectPost = ctx -> {
        Collect collect = getCollectPost(ctx);
        CollectDao.uncollect(collect);
        ctx.redirect(Path.Web.QUERYALLPOSTNOW);
    };
}