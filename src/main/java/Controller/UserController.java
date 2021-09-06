package Controller;

import dao.UserDao;
import model.User;

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
