package main;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static io.javalin.apibuilder.ApiBuilder.before;

/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the Javalin HTTP
 * Server and our web application.
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Halil Ali, 2021. email halil.ali@rmit.edu.au
 */
public class App {

    public static final int JAVALIN_PORT = 7000;
    public static final String CSS_DIR = "css/";
    public static final String IMAGES_DIR = "images/";
    public static final String JS_DIR = "js/";
    public static final String WEBFONT_DIR = "webfonts/";

    public static void main(String[] args) throws Exception {


        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
        }).start(JAVALIN_PORT);

        // capture ctrl-c signal so we can shutdown server safely
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
        }));

//
//        // Configure Web Routes
//        configureRoutes(app);
    }

    /**
     * set up each individual page of site
     **/
//    public static void configureRoutes(Javalin app) {
//        app.get(Path.Web.INDEX, IndexController.serverIndexPage);
//        app.get(Path.Web.REGISTER,RegisterController.registerPage);
//        app.post(Path.Web.LOGIN, LoginController.handleLoginPost);
//        app.post(Path.Web.HANDLER_REGISTER,RegisterController.handlerRegisterPost);
//    }
}
