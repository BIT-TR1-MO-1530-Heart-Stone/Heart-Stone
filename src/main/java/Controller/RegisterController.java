package Controller;

import io.javalin.http.Handler;
import dao.UserDao;
import model.User;
import util.*;

//@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au

import static util.RequestUtil.*;

public class RegisterController {
    // Jump to the registration page
    public static Handler registerPage = ctx -> ctx.render(Path.Template.REGISTER);
    // Process registration request - after successful registration, jump to the
    // home page (the same as successful login)
    public static Handler handlerRegister = ctx -> {
        User user = getRegisterInfo(ctx);
        System.out.println("Login as:"+user.getEmail());
        if (UserDao.register(user)) {
            User user1 = UserDao.getUserByUserEmailAndPassword(user.getEmail(), user.getPassword());
            ctx.sessionAttribute("currentUser", user1);
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        } else {
            ctx.render(Path.Template.REGISTER);
        }
    };

    //Back to login
    public static Handler handlerBackToLogin = ctx -> {

        ctx.render(Path.Template.LOGIN);
        System.out.println("Im back!!!");

    };
}