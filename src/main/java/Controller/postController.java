package Controller;

import dao.PostDao;
import io.javalin.http.Handler;
import model.Post;
import util.Path;

import java.util.ArrayList;


import static util.RequestUtil.*;


public class postController {
    // Jump to the Create post page
    public static Handler CreatePostPage = ctx -> ctx.render(Path.Template.CreatePost);
    //Create a new post
    public static Handler handlerCreatePost = ctx ->{
        Post post = getPostInfo(ctx);
        if(PostDao.create(post)){
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
    };

    //Delete a post
    public static Handler handlerDeletePost = ctx ->{
        String DeletePostID = getDeletePostID(ctx);
        if(PostDao.delete(Integer.valueOf(DeletePostID))){
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        }else{
            System.err.println("Delete failed");
        }
    };

}