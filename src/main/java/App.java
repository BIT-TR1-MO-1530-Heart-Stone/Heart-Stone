import Controller.IndexController;
import Controller.LoginController;
import Controller.RegisterController;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import util.*;


/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the Javalin HTTP
 * Server and our web application.
 *
 * @author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au
 */
public class App {

    public static final int JAVALIN_PORT = 7001;
    public static final String CSS_DIR = "css/";
    public static final String IMAGES_DIR = "images/";
    public static final String JS_DIR = "js/";
    public static final String WEBFONT_DIR = "webfonts/";

    public static void main(String[] args) throws Exception {


        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));

//            // Uncomment this if you have files in the CSS Directory
//            config.addStaticFiles(CSS_DIR);
//
//            // Uncomment this if you have files in the Images Directory
//            config.addStaticFiles(IMAGES_DIR);
//            config.addStaticFiles(JS_DIR);
//            config.addStaticFiles(WEBFONT_DIR);
        }).start(JAVALIN_PORT);

        // capture ctrl-c signal so we can shutdown server safely
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
        }));

        // Configure Web Routes
        configureRoutes(app);
    }

    /**
     * set up each individual page of site
     **/
    public static void configureRoutes(Javalin app) {
        app.get(Path.Web.INDEX, IndexController.serverIndexPage);
        app.get(Path.Web.REGISTERPAGE, RegisterController.registerPage);
        app.post(Path.Web.LOGIN, LoginController.handlerLogin);
        app.post(Path.Web.HANDLER_REGISTER,RegisterController.handlerRegister);
    }

}
