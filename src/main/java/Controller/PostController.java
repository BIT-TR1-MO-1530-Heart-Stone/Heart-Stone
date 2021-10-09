package Controller;

import dao.PostDao;
import io.javalin.http.Handler;
import model.Post;
import model.User;
import util.Path;
import java.util.HashMap;
import java.util.List;
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

//    //Post list in main page
//    public static Handler MainPagePostList = ctx ->{
//        ArrayList<Post> mainallPost = new ArrayList<>();
//        mainallPost = (ArrayList<Post>) PostDao.MainPagePost();
//        Map<String, Object> model = new HashMap<>();
//        model.put("post",mainallPost);
//        System.out.printf("List all post in main page success");
//        ctx.render(Path.Template.MAIN, model);
//    };

    //List all posts in main page
    public static Handler handlerListAllPost = ctx ->{
        User user = ctx.sessionAttribute("currentUser");
        List<Post> allPost = PostDao.getAllPosts( user.getId());
        Map<String, Object> model = new HashMap<>();
        model.put("postList",allPost);
        //System.out.printf("List all success");
        if(allPost != null){
           // System.out.println(allPost.get(0).getInfo());
        }
        ctx.render(Path.Template.MAIN, model);
    };

    //Delete a post
    public static Handler handlerDeletePost = ctx ->{
        System.out.println("Deleting.......");
        User user = ctx.sessionAttribute("currentUser");
        String DeletePostID = getDeletePostID(ctx);
        System.out.println("DeletePostID is:   " + DeletePostID);
        if(PostDao.deletePost(Integer.valueOf(DeletePostID),user.getId())){
            System.out.println("Delete successfully");
            ctx.redirect(Path.Web.QUERYALLPOSTNOW);
        }else{
            System.err.println("Delete failed");
            ctx.render(Path.Template.DeletePost);
        }
    };
    public static Handler handlerListMinePost = ctx ->{
        User user = ctx.sessionAttribute("currentUser");
        List<Post> likePost = PostDao.getMinePosts(user.getId());
        Map<String, Object> model = new HashMap<>();
        model.put("postList",likePost);
        //System.out.printf("List all success");
        if(likePost != null){
            // System.out.println(allPost.get(0).getInfo());
        }
        ctx.render(Path.Template.lIKE, model);
    };
    public static Handler handlerListLikePost = ctx ->{
        User user = ctx.sessionAttribute("currentUser");
        List<Post> likePost = PostDao.getLikePosts(user.getId());
        Map<String, Object> model = new HashMap<>();
        model.put("postList",likePost);
        //System.out.printf("List all success");
        if(likePost != null){
            // System.out.println(allPost.get(0).getInfo());
        }
        ctx.render(Path.Template.lIKE, model);
    };
    public static Handler handlerListCollectedPost = ctx ->{
        User user = ctx.sessionAttribute("currentUser");
        List<Post> collectPosts = PostDao.getCollectPosts( user.getId());
        Map<String, Object> model = new HashMap<>();
        model.put("postList",collectPosts);
        //System.out.printf("List all success");
        if(collectPosts != null){
            // System.out.println(allPost.get(0).getInfo());
        }
        ctx.render(Path.Template.COLLECTION, model);
    };

}