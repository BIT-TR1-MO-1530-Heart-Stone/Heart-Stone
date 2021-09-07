package util;

public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String REGISTERPAGE = "/register";
        public static final String HANDLER_REGISTER = "/handlerRegister";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String QUERYALLPOSTNOW = "/queryAllPostNow";
    }

    public static class Template {
        public static final String INDEX = "WebContent/User/login.html";
        public static final String REGISTER = "WebContent/User/register.html";
        public static final String LOGIN = "WebContent/User/login.html";
        public static final String MAIN = "WebContent/Main/main.html";
        public static final String CreatePost = "WebContent/Post/addPost.html";
    }

}