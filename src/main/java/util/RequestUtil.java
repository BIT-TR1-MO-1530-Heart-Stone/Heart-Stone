package util;

import io.javalin.http.Context;
import model.Post;
import model.User;

import java.util.Date;
import java.text.SimpleDateFormat;


public class RequestUtil {
    public static String getQueryEmail(Context ctx) {
        return ctx.formParam("email");
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
        String info = ctx.formParam("info");
        String password = ctx.formParam("password2");
//        String profilePicture = "default.png";
        user.setEmail(email);
        user.setFullname(fullname);
        user.setScreenname(screenname);
        user.setGender(Integer.valueOf(gender));
        user.setInfo(info);
        user.setPhone_number(phone_number);
        user.setPassword(password);
//        user.setCreate_date(getCurrentDate());
//        user.setProfile_picture(profilePicture);
        return user;
    }


    public static Post getPostInfo(Context ctx) {
        Post post = new Post();

//        String category = ctx.formParam("category");
//        String postInfo = ctx.formParam("postInfo");
//        String title = ctx.formParam("title");
//        String picture = ctx.formParam("picture");

        String category = "1";
        String postInfo="adasdasd";
        String title = "aaa";
        String picture = "aaaa";
        String date = getCurrentDate();
        int userId = 111;
        int Visible = 0;


        post.setCategory(Integer.valueOf(category));
        post.setInfo(postInfo);
        post.setTitle(title);
        post.setPicture(picture);

        post.setDate(date);
        System.out.println(post.getDate());
        post.setUserID(userId);
        post.setVisible(Visible);

        return post;
    }
    public static String getDeletePostID(Context ctx) {
        return ctx.formParam("DeletePostID");
    }
    public static String getCurrentDate(){


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(new Date());

    }
}

