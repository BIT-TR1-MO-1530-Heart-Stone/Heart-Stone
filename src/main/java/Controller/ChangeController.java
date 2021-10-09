package Controller;
import dao.UserDao;
import io.javalin.http.Handler;
import model.User;
import util.Path;
import util.RequestUtil;


public class ChangeController {



    public static Handler handlerBackEditPage = ctx -> {

        ctx.render(Path.Template.EditPROFILE);

    };

    public static Handler handlerChangePSW = ctx -> {

        User currentUser = ctx.sessionAttribute("currentUser");

        String pwd[] = RequestUtil.getNewAndOldPwd(ctx);

        User user = UserDao.getUserByUserEmail(currentUser.getEmail());
        System.out.println("Update user:"+currentUser.getEmail());
        if (pwd[0].equals(user.getPassword())){
            System.out.println("Feeeeeeeennng");
            if (UserDao.changePassword( user.getEmail(), user.getPassword(), pwd[1])) {
                User user1 = UserDao.getUserByUserEmailAndPassword(user.getEmail(), user.getPassword());
                ctx.sessionAttribute("currentUser", user1);
                System.out.println("success");
                ctx.render(Path.Template.LOGIN);
            } else {
                System.out.println("fail");
                ctx.render(Path.Template.ChangePsw);
            }
        }else{
            System.out.println("This is oldPsw:    "+pwd[0]);
            System.out.println("This is userPsw:     "+user.getPassword());
            System.out.println("fail2222222222222");
            ctx.render(Path.Template.ChangePsw);
        }
    };


}
