package Controller;

import dao.PostDao;
import dao.UserDao;
import io.javalin.http.Handler;
import model.Post;
import model.User;
import util.Path;
import util.RequestUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditController {

    public static Handler handlerEditProfile = ctx -> {
        User user = RequestUtil.getUpdateUserInfo(ctx);
        ctx.render(Path.Template.EditPROFILE);
        //print info
//        System.out.println("Update user:"+user.getEmail());
//        if (UserDao.modifyInfomation(user)) {
//            User user1 = UserDao.getUserByUserEmailAndPassword(user.getEmail(), user.getPassword());
//            ctx.sessionAttribute("currentUser", user1);
//            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
//        } else {
//            ctx.render(Path.Template.EditPROFILE);
//        }
    };
    public static Handler handlerListUserInfo = ctx ->{
        User currentUser = ctx.sessionAttribute("currentUser");
        User user = UserDao.getUserByUserEmail(currentUser.getEmail());
        Map<String, Object> model = new HashMap<>();
        model.put("userinfo",user);
        System.out.printf("get UserInfo:"+currentUser.getEmail()+" success");
        if(user != null){
             System.out.println("UserInfo:"+currentUser.getEmail()+" get false");
        }
//        ctx.render(Path.Template.MAIN, model);
    };

    public static Handler handlerEditPwd = ctx -> {
        String pwd[] = RequestUtil.getNewAndOldPwd(ctx);
        User currentUser = ctx.sessionAttribute("currentUser");
        User user = UserDao.getUserByUserEmail(currentUser.getEmail());
        System.out.println("Update user:"+currentUser.getEmail());
        if (pwd[0]==user.getPassword()){
            if (UserDao.changePassword(pwd[1], user.getEmail(), user.getPassword())) {
                User user1 = UserDao.getUserByUserEmailAndPassword(user.getEmail(), user.getPassword());
                ctx.sessionAttribute("currentUser", user1);
                System.out.println("success");
//                ctx.redirect(Path.Web.QUERYALLPOSTNOW);
            } else {
                System.out.println("fail");
//                ctx.render(Path.Template.EditPROFILE);
            }
        }

    };

    public static Handler handlerBackProfile = ctx -> {

        ctx.render(Path.Template.PROFILE);

    };
}
