package util;

import io.javalin.http.Context;
import model.Post;
import model.User;

public class RequestUtil {
    public static String getQueryUsername(Context ctx) {
        return ctx.formParam("username");
    }
    public static String getQueryPassword(Context ctx) {
        return ctx.formParam("password");
    }
    public static User getRegisterInfo(Context ctx) {
        User user = new User();
        String email = ctx.formParam("email");
        String fullname = ctx.formParam("fullname");
        String screenname = ctx.formParam("screenname");
        String gender = ctx.formParam("gender");
        String phone_number = ctx.formParam("phone_number");
        String password = ctx.formParam("password2");
//        String profilePicture = "default.png";
        user.setEmail(email);
        user.setFullname(fullname);
        user.setScreenname(screenname);
        user.setGender(Integer.valueOf(gender));
        user.setPhone_number(phone_number);
        user.setPassword(password);
//        user.setCreate_date(getCurrentDate());
//        user.setProfile_picture(profilePicture);
        return user;
    }


    public static Post getPostInfo(Context ctx) {
        Post post = new Post();

        String category = ctx.formParam("category");
        String postInfo = ctx.formParam("postInfo");
        String title = ctx.formParam("title");
        String picture = ctx.formParam("picture");

        post.setCategory(Integer.valueOf(category));
        post.setInfo(postInfo);
        post.setTitle(title);
        post.setPicture(picture);

        return post;
    }
    public static String getDeletePostID(Context ctx) {
        return ctx.formParam("DeletePostID");
    }

}
