package Controller;

import dao.PostDao;
import io.javalin.http.Handler;
import model.Post;
import util.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import static util.RequestUtil.*;


public class PostController {
    // Jump to the Post  main page
    public static Handler CreatePostpage = ctx -> ctx.render(Path.Template.CreatePost);
    //Create a new post
    public static Handler handlerCreatePost = ctx ->{
        Post post = getPostInfo(ctx);
        if(PostDao.create(post)){
            System.out.println("Create a new post success");
            //ctx.redirect(Path.Web.QUERYALLPOSTNOW);
            ctx.render(Path.Template.DeletePost);
        }else{
            System.err.println("Create a new post failed");
            ctx.render(Path.Template.CreatePost);
        }
    };

//    //Post list in main page
//    public static Handler MainPagePostList = ctx ->{
//        ArrayList<Post> mainallPost = new ArrayList<>();
//        mainallPost = (ArrayList<Post>) PostDao.MainPagePost();
//        Map<String, Object> model = new HashMap<>();
//        model.put("post",mainallPost);
//        System.out.printf("List all post in main page success");
//        ctx.render(Path.Template.MAIN, model);
//    };

    //List all posts in Postlist(Delete) page
    public static Handler handlerListAllPost = ctx ->{
        ArrayList<Post> allPost = new ArrayList<>();
        allPost = (ArrayList<Post>) PostDao.getAllPosts();
        Map<String, Object> model = new HashMap<>();
        model.put("post",allPost);
        System.out.printf("List all success");
        ctx.render(Path.Template.DeletePost, model);
    };

    //Delete a post
    public static Handler handlerDeletePost = ctx ->{
        String DeletePostID = getDeletePostID(ctx);
        if(PostDao.delete(Integer.valueOf(DeletePostID))){
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        }else{
            System.err.println("Delete failed");
            ctx.render(Path.Template.DeletePost);
        }
    };

}