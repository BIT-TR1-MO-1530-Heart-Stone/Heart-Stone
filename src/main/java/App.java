import Controller.*;
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
    public static final String CSS_DIR = "WebContent/css/";
    public static final String IMAGES_DIR = "images/";
//    public static final String JS_DIR = "js/";
    public static final String WEBFONT_DIR = "webfonts/";

    public static void main(String[] args) throws Exception {


        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));

//            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);
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
        app.get(Path.Web.GOTOPROFILE, MenuController.handlerGoToProfile);
        app.get(Path.Web.GOTOLIKE, MenuController.handlerGoToLike);
        app.get(Path.Web.GOTOCOLLECTION, MenuController.handlerGoToCollection);
        app.get(Path.Web.REGISTERPAGE, RegisterController.registerPage);
        app.post(Path.Web.LOGIN, LoginController.handlerLogin);
        app.get(Path.Web.CHANGEPASSWORD,EditController.handlerGoToChangePSW);
        app.get(Path.Web.BACKEDITPAGE,ChangeController.handlerBackEditPage);
        app.post(Path.Web.BACKEDITPAGE,ChangeController.handlerBackEditPage);

        app.get(Path.Web.BACKPROFILE,EditController.handlerBackProfile);
        app.post(Path.Web.BACKPROFILE,EditController.handlerBackProfile);

        app.post(Path.Web.HANDLER_REGISTER,RegisterController.handlerRegister);
        app.post(Path.Web.BACKTOLOGIN, RegisterController.handlerBackToLogin);

        app.post(Path.Web.LikePost, LikeController.handlerLikePost);
        app.post(Path.Web.UnLikePost, LikeController.handlerUnLikePost);
        app.post(Path.Web.CollectPost, CollectController.handlerCollectPost);
        app.post(Path.Web.UnCollectPost, CollectController.handlerUnCollectPost);
        app.post(Path.Web.GOTOPROFILE,MenuController.handlerGoToProfile);
        app.post(Path.Web.CHANGEPASSWORD,EditController.handlerGoToChangePSW);

        app.get(Path.Web.CREATEPOSTPAGE, PostController.CreatePostpage);
//        app.get(Path.Web.POSTMAINPAGE, PostController.PostMainPage);
        app.get(Path.Web.QUERYALLPOSTNOW, PostController.handlerListAllPost);
        app.post(Path.Web.HANDLER_CREATEPOST, PostController.handlerCreatePost);
        app.post(Path.Web.HANDLER_DELETEPOST, PostController.handlerDeletePost);
        app.post(Path.Web.NAVIGATION_LOGOUT, LoginController.handlerLogout);

        app.post(Path.Web.EDITPROFILE,ProfileController.handlerGoEditPage);

        app.post(Path.Web.SAVEPASSWORD,ChangeController.handlerChangePSW);
      //  app.get(Path.Web.MAINPAGEPOSTLIST, PostController.MainPagePostList);
    }

}
