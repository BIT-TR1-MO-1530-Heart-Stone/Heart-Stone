package Controller;

import dao.UserDao;
import io.javalin.http.Handler;
import model.User;
import util.Path;

import static util.RequestUtil.getRegisterInfo;

public class UserController {
    //authenticate email & pwd
    public static boolean authenticate(String email, String password) throws Exception{
        if (email == null || password == null) {
            return false;
        }
        User user = UserDao.getUserByUserEmailAndPassword(email, password);
        return user != null;
    }
}
