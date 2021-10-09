package util;

public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String REGISTERPAGE = "/register";
        public static final String HANDLER_REGISTER = "/handlerRegister";
        public static final String LOGIN = "/login";
        public static final String BACKTOLOGIN = "/backLogin";

        public static final String NAVIGATION_LOGOUT = "/logout";
        public static final String QUERYALLPOSTNOW = "/queryAllPostNow";
        public static final String QUERYALLLIKEPOSTNOW = "/handlerListLikePost";
        public static final String QUERYALLCOLLECTIONPOSTNOW = "/handlerListCollectedPost";
        public static final String CREATEPOSTPAGE = "/addPost";
        public static final String HANDLER_DELETEPOST = "/handlerDeletePost";
        public static final String HANDLER_CREATEPOST = "/handlerCreatePost";
        //public static final String MAINPAGEPOSTLIST = "/MainPagePostList";
        public static final String LikePost = "/handlerLikePost";
        public static final String UnLikePost = "/handlerUnLikePost";
        public static final String CollectPost = "/handlerCollectPost";
        public static final String UnCollectPost = "/handlerUnCollectPost";

        public static final String GOTOPROFILE = "/goToProfile";
        public static final String EDITPROFILE = "/editProfile";
        public static final String GOTOLIKE = "/handlerGoToLike";
        public static final String GOTOCOLLECTION = "/handlerGoToCollection";

        public static final String CHANGEPASSWORD = "/handlerChangePsw";
        public static final String SAVEPASSWORD = "/savePassword";
        public static final String BACKEDITPAGE = "/backEditPage";
        public static final String BACKPROFILE = "/backProfile";

    }

    public static class Template {
        public static final String INDEX = "WebContent/page/login.html";
        public static final String REGISTER = "WebContent/page/register.html";
        public static final String LOGIN = "WebContent/page/login.html";
        public static final String MAIN = "WebContent/page/main.html";
        public static final String CreatePost = "WebContent/page/addPost.html";
        public static final String DeletePost = "WebContent/page/main.html";
        public static final String PROFILE = "WebContent/page/profile.html";
        public static final String EditPROFILE = "WebContent/page/editProfile.html";
        public static final String ChangePsw = "WebContent/page/changePsw.html";
        public static final String lIKE = "WebContent/page/LikeList.html";
        public static final String COLLECTION = "WebContent/page/CollectionList.html";
    }

}
