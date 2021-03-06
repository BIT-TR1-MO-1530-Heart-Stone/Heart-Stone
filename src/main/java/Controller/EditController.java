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
//        ctx.render(Path.Template.EditPROFILE);
        //print info
//        System.out.println("Update user:"+user.getEmail());
        if (UserDao.modifyInfomation(user)) {
            System.out.println(user.getEmail());

            User user1 = UserDao.getUserByUserEmail(user.getEmail());
            ctx.sessionAttribute("currentUser", user1);
            System.out.println(user1.getEmail());
            System.out.println(user1.getScreenname());
            ctx.render(Path.Template.PROFILE);
            System.out.println("Update UserInfo(id):"+user1.getId()+" success");
        } else {
            System.out.println("Update UserInfo(id):"+user.getId()+" fail");
            ctx.render(Path.Template.EditPROFILE);
        }
    };

    public static Handler handlerListUserInfo = ctx ->{
        User currentUser = ctx.sessionAttribute("currentUser");
        User user = UserDao.getUserByUserEmail(currentUser.getEmail());
        Map<String, Object> model = new HashMap<>();
        model.put("userinfo",user);
        System.out.println("get UserInfo:"+currentUser.getEmail()+" success");
        if(user != null){
             System.out.println("UserInfo:"+currentUser.getEmail()+" get false");
        }
//        ctx.render(Path.Template.MAIN, model);
    };



    public static Handler handlerBackProfile = ctx -> {
        ctx.render(Path.Template.PROFILE);
    };

    public static Handler handlerGoToChangePSW = ctx -> {

        ctx.render(Path.Template.ChangePsw);

    };
}
