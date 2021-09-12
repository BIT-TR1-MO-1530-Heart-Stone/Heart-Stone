package util;

public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String REGISTERPAGE = "/register";
        public static final String HANDLER_REGISTER = "/handlerRegister";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";

        public static final String QUERYALLPOSTNOW = "/queryAllPostNow";
        public static final String CREATEPOST = "/createpost";
        public static final String DELETEPOST = "/deletepost";
        public static final String POSTMAINPAGE = "/postmainpage";
    }

    public static class Template {
        public static final String INDEX = "WebContent/page/login.html";
        public static final String REGISTER = "WebContent/page/register.html";
        public static final String LOGIN = "WebContent/page/login.html";
        public static final String MAIN = "WebContent/page/main.html";
        public static final String CreatePost = "WebContent/page/addPost.html";
        public static final String DeletePost = "WebContent/page/Postlist(delete).html";
    }

}
