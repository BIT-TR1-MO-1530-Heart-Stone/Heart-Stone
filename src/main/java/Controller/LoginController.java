package Controller;

import io.javalin.http.Handler;
import dao.UserDao;
import model.User;
import util.Path;

import java.util.HashMap;
import java.util.Map;

import static util.RequestUtil.*;

//@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au

public class LoginController {
    //login
    public static Handler handlerLogin = ctx -> {
        Map<String, Object> model = new HashMap<>();
        String email = getQueryEmail(ctx);
        String password = getQueryPassword(ctx);
        System.out.println(email+password);
        if (!UserController.authenticate(email, password)) {
            ctx.render(Path.Template.LOGIN, model);
            System.out.printf("login failed!");
        } else {
            User user = UserDao.getUserByUserEmailAndPassword(email, password);
            ctx.sessionAttribute("currentUser", user);
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
            System.out.printf("login success!");
        }
    };
    //login out
    public static Handler handlerLogout = ctx -> {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(Path.Web.INDEX);
    };
}
