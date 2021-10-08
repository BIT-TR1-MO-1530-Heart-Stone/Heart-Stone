package Controller;
import io.javalin.http.Handler;
import util.Path;


public class ChangeController {

    public static Handler handlerGoToChangePSW = ctx -> {

        ctx.render(Path.Template.ChangePsw);

    };

    public static Handler handlerBackEditPage = ctx -> {

        ctx.render(Path.Template.EditPROFILE);

    };

}
