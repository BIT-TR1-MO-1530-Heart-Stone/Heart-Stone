package util;

public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String REGISTER = "/register";
        public static final String HANDLER_REGISTER = "/handlerRegister";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String BOOKS = "/books";
        public static final String ONE_BOOK = "/books/:isbn";

        public static final String QUERYALLPOSTNOW = "/queryAllPostNow";

    }

    public static class Template {
        public static final String INDEX = "pages/login.html";
        public static final String INDEX_NEW = "WebContent/User/login.html";

        public static final String REGISTER = "pages/register.html";

        public static final String LOGIN = "pages/login.html";
        public static final String LOGIN_NEW = "pages/login_new.html";

        public static final String MAIN = "pages/main.html";


        public static final String BOOKS_ALL = "/velocity/book/all.vm";
        public static final String BOOKS_ONE = "/velocity/book/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}
