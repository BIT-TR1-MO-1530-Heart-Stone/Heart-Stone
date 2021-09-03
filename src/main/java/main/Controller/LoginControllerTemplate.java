//package app.login;
//
//import app.user.UserController;
//import app.util.Path;
//import app.util.ViewUtil;
//import io.javalin.http.Handler;
//
//import java.util.Map;
//
//import static app.util.RequestUtil.*;
//
//public class LoginController {
//    //Processing the login request-the login is successful and jumps to the main page
//    public static Handler handleLoginPost = ctx -> {
//        Map<String, Object> model = ViewUtil.baseModel(ctx);
//        if (!UserController.authenticate(getQueryUsername(ctx), getQueryPassword(ctx))) {
//            model.put("authenticationFailed", true);
//            ctx.render(Path.Template.LOGIN_NEW, model);
//        } else {
//            ctx.sessionAttribute("currentUser", getQueryUsername(ctx));
//            model.put("authenticationSucceeded", true);
//            model.put("currentUser", getQueryUsername(ctx));
//            ctx.render(Path.Template.MAIN);
//        }
//    };
//    //Process exit request
//    public static Handler handleLogoutPost = ctx -> {
//        ctx.sessionAttribute("currentUser", null);
//        ctx.sessionAttribute("loggedOut", "true");
//        ctx.redirect(Path.Web.LOGIN);
//    };
//}
