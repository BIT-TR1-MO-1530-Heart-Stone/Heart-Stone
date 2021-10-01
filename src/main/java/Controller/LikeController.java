package Controller;

import dao.LikeDao;
import io.javalin.http.Handler;
import model.LikePost;
import util.Path;

import static util.RequestUtil.getLikePost;

public class LikeController {
    public static Handler handlerLikePost = ctx ->{
        LikePost likePost = getLikePost(ctx);
        LikeDao.like(likePost);
    };

    public static Handler handlerUnLikePost = ctx ->{
        LikePost likePost = getLikePost(ctx);
        LikeDao.unlike(likePost);
    };

}
