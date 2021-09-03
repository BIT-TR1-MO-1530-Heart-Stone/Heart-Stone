package main.Controller;

import main.dao.UserDao;
import main.model.User;

public class UserController {
    //authenticate email & pwd
    public static boolean authenticate(String email, String password) {
        if (email == null || password == null) {
            return false;
        }
        User user = UserDao.getUserByUsernameAndPssword(email, password);
        return user != null;
    }

}
