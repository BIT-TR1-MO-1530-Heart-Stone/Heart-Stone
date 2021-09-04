package main.Controller;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import main.dao.UserDao;
import main.model.User;
import main.util.Path;

import java.util.HashMap;
import java.util.Map;

import static main.util.RequestUtil.*;

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
