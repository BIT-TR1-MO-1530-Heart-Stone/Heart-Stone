package Controller;

import io.javalin.http.Handler;
import util.Path;

public class MenuController {


    public static Handler handlerGoToProfile = ctx -> {
        System.out.println("yeeeeeeeeeep");
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
