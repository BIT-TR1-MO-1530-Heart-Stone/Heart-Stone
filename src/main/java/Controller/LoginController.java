package Controller;

import io.javalin.http.Handler;
import dao.UserDao;
import model.User;
import util.Path;
import java.util.HashMap;
import java.util.Map;
import static util.RequestUtil.*;

//@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au

public class LoginController{
    //login
    public static Handler handlerLogin = ctx -> {
        Map<String, Object> model =  new HashMap<>();
        String username = getQueryUsername(ctx);
        String password =getQueryPassword(ctx);
        if (!UserController.authenticate(username,password)) {
            ctx.render(Path.Template.LOGIN_NEW, model);
        } else {
            User user = UserDao.getUserByUsernameAndPssword(username,password);
            ctx.sessionAttribute("currentUser", user);
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        }
    };

    //login out
    public static Handler handlerLogout = ctx -> {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(Path.Web.INDEX);
    };
}
