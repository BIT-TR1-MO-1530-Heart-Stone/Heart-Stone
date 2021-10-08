package Controller;
import io.javalin.http.Handler;
import model.User;
import util.Path;
import util.RequestUtil;

public class ProfileController
{
    public static Handler handlerGoEditPage = ctx -> {
        ctx.render(Path.Template.EditPROFILE);
    };
}
