package Controller;

import dao.UserDao;
import model.User;

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
