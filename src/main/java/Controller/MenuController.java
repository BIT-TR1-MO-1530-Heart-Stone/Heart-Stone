package Controller;

import dao.PostDao;
import io.javalin.http.Handler;
import model.Post;
import model.User;
import util.Path;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuController {


    public static Handler handlerGoToProfile = ctx -> {

        ctx.render(Path.Template.PROFILE);

    };

    public static Handler handlerGoToLike = ctx -> {
        System.out.println("yeeeeeeeeeep");
        ctx.render(Path.Template.lIKE);
        ctx.redirect(Path.Web.QUERYALLLIKEPOSTNOW);

    };

    public static Handler handlerGoToCollection = ctx -> {
        System.out.println("yeeeeeeeeeep");
        ctx.render(Path.Template.COLLECTION);
        ctx.redirect(Path.Web.QUERYALLCOLLECTIONPOSTNOW);

    };

}
