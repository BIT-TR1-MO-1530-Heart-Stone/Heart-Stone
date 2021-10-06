package Controller;

import io.javalin.http.Handler;
import util.Path;

public class EditController {

    public static Handler handlerEditProfile = ctx -> {
        System.out.println("yeeeeeeeeeep");
        ctx.render(Path.Template.EditPROFILE);

    };

}
