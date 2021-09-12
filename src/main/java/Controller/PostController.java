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
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        }else{
            System.err.println("Create a new post failed");
            ctx.render(Path.Template.CreatePost);
        }
    };

    //List all posts
    public static Handler handlerListAllPost = ctx ->{
        ArrayList<Post> allPost = new ArrayList<>();
        allPost = (ArrayList<Post>) PostDao.getAllPosts();
        Map<String, Object> model = new HashMap<>();
        model.put("post",allPost);
        System.out.printf("List all success");
        ctx.render(Path.Template.MAIN, model);
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